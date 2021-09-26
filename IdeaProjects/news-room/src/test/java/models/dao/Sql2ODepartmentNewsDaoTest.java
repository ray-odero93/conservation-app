package models.dao;

import models.DepartmentNews;
import models.Department;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2ODepartmentNewsDaoTest {
    private Sql2ODepartmentNewsDao foodtypeDao;
    private Sql2ODepartmentDao restaurantDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {

      String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
    Sql2o sql2o = new Sql2o(connectionString, "", "");
        restaurantDao = new Sql2ODepartmentDao(sql2o);
        foodtypeDao = new Sql2ODepartmentNewsDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addingFoodSetsId() throws Exception {
        DepartmentNews testDepartmentNews = setupNewFoodtype();
        int originalFoodtypeId = testDepartmentNews.getId();
        foodtypeDao.add(testDepartmentNews);
        assertNotEquals(originalFoodtypeId, testDepartmentNews.getId());
    }

    @Test
    public void addedFoodtypesAreReturnedFromGetAll() throws Exception {
        DepartmentNews testfoodtype = setupNewFoodtype();
        foodtypeDao.add(testfoodtype);
        assertEquals(1, foodtypeDao.getAll().size());
    }

    @Test
    public void noFoodtypesReturnsEmptyList() throws Exception {
        assertEquals(0, foodtypeDao.getAll().size());
    }

    @Test
    public void deleteByIdDeletesCorrectFoodtype() throws Exception {
        DepartmentNews departmentNews = setupNewFoodtype();
        foodtypeDao.add(departmentNews);
        foodtypeDao.deleteById(departmentNews.getId());
        assertEquals(0, foodtypeDao.getAll().size());
    }

    @Test
    public void clearAll() throws Exception {
        DepartmentNews testDepartmentNews = setupNewFoodtype();
        DepartmentNews otherDepartmentNews = setupNewFoodtype();
        foodtypeDao.clearAll();
        assertEquals(0, foodtypeDao.getAll().size());
    }

    @Test
    public void addFoodTypeToRestaurantAddsTypeCorrectly() throws Exception {

        Department testDepartment = setupRestaurant();
        Department altDepartment = setupAltRestaurant();

        restaurantDao.add(testDepartment);
        restaurantDao.add(altDepartment);

        DepartmentNews testDepartmentNews = setupNewFoodtype();

        foodtypeDao.add(testDepartmentNews);

        foodtypeDao.addFoodtypeToRestaurant(testDepartmentNews, testDepartment);
        foodtypeDao.addFoodtypeToRestaurant(testDepartmentNews, altDepartment);

        assertEquals(2, foodtypeDao.getAllDepartmentsForANewsDetail(testDepartmentNews.getId()).size());
    }

    @Test
    public void deleteingRestaurantAlsoUpdatesJoinTable() throws Exception {
        DepartmentNews testDepartmentNews = new DepartmentNews("Seafood");
        foodtypeDao.add(testDepartmentNews);

        Department testDepartment = setupRestaurant();
        restaurantDao.add(testDepartment);

        Department altDepartment = setupAltRestaurant();
        restaurantDao.add(altDepartment);

        restaurantDao.addDepartmentToDepartmentNews(testDepartment, testDepartmentNews);
        restaurantDao.addDepartmentToDepartmentNews(altDepartment, testDepartmentNews);

        restaurantDao.deleteById(testDepartment.getId());
        assertEquals(0, restaurantDao.getAllFoodtypesByRestaurant(testDepartment.getId()).size());
    }

    // helpers

    public DepartmentNews setupNewFoodtype(){
        return new DepartmentNews("Sushi");
    }

    public Department setupRestaurant (){
        Department department = new Department("Fish Omena", "214 NE Safaricom", "97232", "254-402-9874", "http://fishwitch.com", "hellofishy@fishwitch.com");
        restaurantDao.add(department);
        return department;
    }

    public Department setupAltRestaurant (){
        Department department = new Department("Fish Omena", "214 NE Safaricom", "97232", "254-402-9874");
        restaurantDao.add(department);
        return department;
    }
}