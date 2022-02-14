package com.uldemy.model.dao;

import com.uldemy.model.entities.Department;

import java.util.List;

public interface DepartmentDao {

    void insert(Department obj);
    void update(Department obj);
    void deleteById(Integer id);
    Department fingById(Integer id);
    List<Department> findAll();

}
