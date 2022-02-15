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

    public void saveOrUpadate(Department obj){
        if (obj.getId() == null){
            dao.insert(obj);
        }
        else {
            dao.update(obj);
        }
    }
    public void remove(Department obj){
        dao.deleteById(obj.getId());
    }
}
