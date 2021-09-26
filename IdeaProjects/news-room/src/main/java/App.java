import com.google.gson.Gson;
import exceptions.ApiException;
import models.DepartmentNews;
import models.Department;
import models.NewsDetails;
import models.dao.Sql2ODepartmentDao;
import models.dao.Sql2ODepartmentNewsDao;
import models.dao.Sql2ONewsDetailsDao;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {

    public static void main(String[] args) {
        Sql2ODepartmentNewsDao departmentNewsDao;
        Sql2ODepartmentDao departmentDao;
        Sql2ONewsDetailsDao newsDetailsDao;
        Connection conn;
        Gson gson = new Gson();

        staticFileLocation("/public");
        String connectionString = "jdbc:h2:~/jadle.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");

        departmentDao = new Sql2ODepartmentDao(sql2o);
        departmentNewsDao = new Sql2ODepartmentNewsDao(sql2o);
        newsDetailsDao = new Sql2ONewsDetailsDao(sql2o);
        conn = sql2o.open();

        //ROUTES
//        get("/restaurants"
//                get("/restaurants/:id"
//                        post("/restaurants/new"
//                                post("/foodtypes/new"
//                                        get("/foodtypes"
//                                                get("/restaurants/:id/reviews"
//                                                        post("/restaurants/:restaurantId/reviews/new

        //CREATE
        post("/restaurants/new", "application/json", (req, res) -> {
            Department restaurant = gson.fromJson(req.body(), Department.class);
            departmentDao.add(restaurant);
            res.status(201);;
            return gson.toJson(restaurant);
        });

        //READ
        get("/restaurants", "application/json", (req, res) -> {
            return gson.toJson(departmentDao.getAll());
        });

        get("/restaurants/:id", "application/json", (req, res) -> {
            int restaurantId = Integer.parseInt(req.params("id"));
            return gson.toJson(departmentDao.findById(restaurantId));
        });

        //FILTERS
        after((req, res) ->{
            res.type("application/json");
        });


        //CREATE
        post("/restaurants/:restaurantId/foodtype/:foodtypeId", "application/json", (req, res) -> {

            int restaurantId = Integer.parseInt(req.params("restaurantId"));
            int foodtypeId = Integer.parseInt(req.params("foodtypeId"));
            Department restaurant = departmentDao.findById(restaurantId);
            DepartmentNews departmentNews = departmentNewsDao.findById(foodtypeId);


            if (restaurant != null && departmentNews != null){
                //both exist and can be associated
                departmentNewsDao.addFoodtypeToRestaurant(departmentNews, restaurant);
                res.status(201);
                return gson.toJson(String.format("Restaurant '%s' and Foodtype '%s' have been associated",departmentNews.getName(), restaurant.getName()));
            }
            else {
                throw new ApiException(404, String.format("Restaurant or Foodtype does not exist"));
            }
        });

        get("/restaurants/:id/foodtypes", "application/json", (req, res) -> {
            int restaurantId = Integer.parseInt(req.params("id"));
            Department restaurantToFind = departmentDao.findById(restaurantId);
            if (restaurantToFind == null){
                throw new ApiException(404, String.format("No restaurant with the id: \"%s\" exists", req.params("id")));
            }
            else if (departmentDao.getAllFoodtypesByRestaurant(restaurantId).size()==0){
                return "{\"message\":\"I'm sorry, but no foodtypes are listed for this restaurant.\"}";
            }
            else {
                return gson.toJson(departmentDao.getAllFoodtypesByRestaurant(restaurantId));
            }
        });

        get("/foodtypes/:id/restaurants", "application/json", (req, res) -> {
            int foodtypeId = Integer.parseInt(req.params("id"));
            DepartmentNews foodtypeToFind = departmentNewsDao.findById(foodtypeId);
            if (foodtypeToFind == null){
                throw new ApiException(404, String.format("No foodtype with the id: \"%s\" exists", req.params("id")));
            }
            else if (departmentNewsDao.getAllDepartmentsForANewsDetail(foodtypeId).size()==0){
                return "{\"message\":\"I'm sorry, but no restaurants are listed for this foodtype.\"}";
            }
            else {
                return gson.toJson(departmentNewsDao.getAllDepartmentsForANewsDetail(foodtypeId));
            }
        });


        post("/restaurants/:restaurantId/reviews/new", "application/json", (req, res) -> {
            int restaurantId = Integer.parseInt(req.params("restaurantId"));
            NewsDetails review = gson.fromJson(req.body(), NewsDetails.class);

            review.setDepartmentId(restaurantId); //we need to set this separately because it comes from our route, not our JSON input.
            newsDetailsDao.add(review);
            res.status(201);
            return gson.toJson(review);
        });

        post("/foodtypes/new", "application/json", (req, res) -> {
            NewsDetails foodtype = gson.fromJson(req.body(), NewsDetails.class);
            newsDetailsDao.add(foodtype);
            res.status(201);
            return gson.toJson(foodtype);
        });

        //READ
        get("/restaurants", "application/json", (req, res) -> {
            System.out.println(departmentDao.getAll());

            if(departmentDao.getAll().size() > 0){
                return gson.toJson(departmentDao.getAll());
            }

            else {
                return "{\"message\":\"I'm sorry, but no restaurants are currently listed in the database.\"}";
            }

        });

        get("/restaurants/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
            int restaurantId = Integer.parseInt(req.params("id"));
            Department restaurantToFind = departmentDao.findById(restaurantId);
            if (restaurantToFind == null){
                throw new ApiException(404, String.format("No restaurant with the id: \"%s\" exists", req.params("id")));
            }
            return gson.toJson(restaurantToFind);
        });

        get("/restaurants/:id/reviews", "application/json", (req, res) -> {
            int restaurantId = Integer.parseInt(req.params("id"));

            Department restaurantToFind = departmentDao.findById(restaurantId);
            List<NewsDetails> allReviews;

            if (restaurantToFind == null){
                throw new ApiException(404, String.format("No restaurant with the id: \"%s\" exists", req.params("id")));
            }

            allReviews = newsDetailsDao.getAllNewsDetailsByDepartment(restaurantId);

            return gson.toJson(allReviews);
        });

        get("/foodtypes", "application/json", (req, res) -> {
            return gson.toJson(newsDetailsDao.getAll());
        });

        post("/restaurants/:restaurantId/reviews/new", "application/json", (req, res) -> {
            int restaurantId = Integer.parseInt(req.params("restaurantId"));
            NewsDetails review = gson.fromJson(req.body(), NewsDetails.class);
            review.setCreatedat(); //I am new!
            review.setFormattedCreatedAt();
            review.setDepartmentId(restaurantId);
            newsDetailsDao.add(review);
            res.status(201);
            return gson.toJson(review);
        });
        get("/restaurants/:id/sortedReviews", "application/json", (req, res) -> { //// TODO: 1/18/18 generalize this route so that it can be used to return either sorted reviews or unsorted ones.
            int restaurantId = Integer.parseInt(req.params("id"));
            Department restaurantToFind = departmentDao.findById(restaurantId);
            List<NewsDetails> allReviews;
            if (restaurantToFind == null){
                throw new ApiException(404, String.format("No restaurant with the id: \"%s\" exists", req.params("id")));
            }
            allReviews = newsDetailsDao.getAllNewsDetailsByDepartmentSortedNewestToOldest(restaurantId);
            return gson.toJson(allReviews);
        });
        //CREATE
        post("/restaurants/new", "application/json", (req, res) -> {
            Department restaurant = gson.fromJson(req.body(), Department.class);
            departmentDao.add(restaurant);
            res.status(201);
            return gson.toJson(restaurant);
        });


        //FILTERS
        exception(ApiException.class, (exc, req, res) -> {
            ApiException err = (ApiException) exc;
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("status", err.getStatusCode());
            jsonMap.put("errorMessage", err.getMessage());
            res.type("application/json"); //after does not run in case of an exception.
            res.status(err.getStatusCode()); //set the status
            res.body(gson.toJson(jsonMap));  //set the output.
        });


        after((req, res) ->{
            res.type("application/json");
        });

    }
    }
