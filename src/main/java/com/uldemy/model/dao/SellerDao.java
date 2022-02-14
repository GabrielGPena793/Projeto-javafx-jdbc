package com.uldemy.model.dao;

import com.uldemy.model.entities.Department;
import com.uldemy.model.entities.Seller;


import java.util.List;

public interface SellerDao {

    void insert(Seller obj);
    void update(Seller obj);
    void deleteById(Integer id);
    Seller fingById(Integer id);
    List<Seller> findAll();
    List<Seller> findByDepartment(Department department);
}
