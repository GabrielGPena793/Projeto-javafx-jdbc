package com.uldemy.model.services;

import com.uldemy.model.dao.DaoFactory;
import com.uldemy.model.dao.DepartmentDao;
import com.uldemy.model.entities.Department;

import java.util.ArrayList;
import java.util.List;

public class DepartmentService {

    private DepartmentDao dao = DaoFactory.createDepartmentDao();

    public List<Department> findAll(){
        return dao.findAll();
    }
}