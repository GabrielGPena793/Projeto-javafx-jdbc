package com.uldemy.model.services;

import com.uldemy.model.dao.DaoFactory;
import com.uldemy.model.dao.DepartmentDao;
import com.uldemy.model.dao.SellerDao;
import com.uldemy.model.entities.Department;
import com.uldemy.model.entities.Seller;

import java.util.List;

public class SellerService {

    private SellerDao dao = DaoFactory.createSellerDao();

    public List<Seller> findAll(){
        return dao.findAll();
    }

    public void saveOrUpadate(Seller obj){
        if (obj.getId() == null){
            dao.insert(obj);
        }
        else {
            dao.update(obj);
        }
    }

    public void remove(Seller obj){
        dao.deleteById(obj.getId());
    }
}
