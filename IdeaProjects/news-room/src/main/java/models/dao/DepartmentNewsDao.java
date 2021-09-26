package models.dao;
import models.DepartmentNews;
import models.Department;

import java.util.List;

public interface DepartmentNewsDao {
    //create
    void add(DepartmentNews departmentNews);
    void addNewsDetailsToDepartment(DepartmentNews departmentNews, Department department);

    //read
    List<DepartmentNews> getAll();
    List<Department> getAllDepartmentsForANewsDetail(int id);
    DepartmentNews findById(int id);
    //update
    //omit for now

    //delete
    void deleteById(int id);
    void clearAll();

}
