
import java.util.List;
import java.util.Map;
import java.util.HashMap;


import dao.Sql2oSquadDao;
import dao.Sql2oHeroDao;
import dao.SquadDao;
import models.Squad;
import models.Hero;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;


public class App {
    public static void main(String[] args) { //type “psvm + tab” to autocreate this
        staticFileLocation("/public");

        String connectionString = "jdbc:postgresql://localhost:5432/todolist"; //connect to todolist, not todolist_test!
        Sql2o sql2o = new Sql2o(connectionString, "moringa", "Access1");
        Sql2oHeroDao heroDao = new Sql2oHeroDao(sql2o);
        Sql2oSquadDao squadDao = new Sql2oSquadDao(sql2o);


        //get: show a form to create a new category
        get("/squads/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Squad> squad = squadDao.getAll(); //refresh list of links for navbar
            model.put("squad", squad);
            return new ModelAndView(model, "squad-form.hbs"); //new layout
        }, new HandlebarsTemplateEngine());

        //post: process a form to create a new category
        post("/squads", (req, res) -> { //new
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("name");
            Squad newSquad = new Squad(name);
            squadDao.add(newSquad);
            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        //get: show new task form
        get("/tasks/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Squad> squad = squadDao.getAll();
            model.put("squad", squad);
            return new ModelAndView(model, "task-form.hbs");
        }, new HandlebarsTemplateEngine());

//        //get: show new post form
//        get("/posts/new", (req, res) -> {
//            Map<String, Object> model = new HashMap<>();
//            return new ModelAndView(model, "post-form.hbs");
//        }, new HandlebarsTemplateEngine());
//
//        //post: process new post form
//        post("/posts/new", (req, res) -> { //URL to make new post on POST route
//            Map<String, Object> model = new HashMap<>();
//            String content = req.queryParams("content");
//            Post newPost = new Post(content);
//            model.put("post", newPost);
//            return new ModelAndView(model, "success.hbs");
//        }, new HandlebarsTemplateEngine());
//
//        //get: show all posts
//        get("/", (req, res) -> {
//            Map<String, Object> model = new HashMap<>();
//            ArrayList<Post> posts = Post.getAll();
//            model.put("posts", posts);
//
//            return new ModelAndView(model, "index.hbs");
//        }, new HandlebarsTemplateEngine());
//
//        //get: show an individual post
//        get("/posts/:id", (req, res) -> {
//            Map<String, Object> model = new HashMap<>();
//            int idOfPostToFind = Integer.parseInt(req.params("id")); //pull id - must match route segment
//            Post foundPost = Post.findById(idOfPostToFind); //use it to find post
//            model.put("post", foundPost); //add it to model for template to display
//            return new ModelAndView(model, "post-detail.hbs"); //individual post page.
//        }, new HandlebarsTemplateEngine());
//
//        //get: show a form to update a post
//        get("/posts/:id/update", (req, res) -> {
//            Map<String, Object> model = new HashMap<>();
//            int idOfPostToEdit = Integer.parseInt(req.params("id"));
//            Post editPost = Post.findById(idOfPostToEdit);
//            model.put("editPost", editPost);
//            return new ModelAndView(model, "post-form.hbs");
//        }, new HandlebarsTemplateEngine());
//
//        //post: process a form to update a post
//        post("/posts/:id/update", (req, res) -> { //URL to make new post on POST route
//            Map<String, Object> model = new HashMap<>();
//            String newContent = req.queryParams("content");
//            int idOfPostToEdit = Integer.parseInt(req.params("id"));
//            Post editPost = Post.findById(idOfPostToEdit);
//            editPost.update(newContent);
//            return new ModelAndView(model, "success.hbs");
//        }, new HandlebarsTemplateEngine());
//
//        //get: delete an individual post
//        get("/posts/:id/delete", (req, res) -> {
//            Map<String, Object> model = new HashMap<>();
//            int idOfPostToDelete = Integer.parseInt(req.params("id")); //pull id - must match route segment
//            Post deletePost = Post.findById(idOfPostToDelete); //use it to find post
//            deletePost.deletePost();
//            return new ModelAndView(model, "success.hbs");
//        }, new HandlebarsTemplateEngine());
//
//        //get: delete all posts
//        get("/posts/delete", (req, res) -> {
//            Map<String, Object> model = new HashMap<>();
//            Post.clearAllPosts();
//            return new ModelAndView(model, "success.hbs");
//        }, new HandlebarsTemplateEngine());
    }
}
