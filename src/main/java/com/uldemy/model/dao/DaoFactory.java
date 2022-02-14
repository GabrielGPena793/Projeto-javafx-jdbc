package com.uldemy.model.dao;

import com.uldemy.db.DB;
import com.uldemy.model.dao.impl.DepartmentDaoJDBC;
import com.uldemy.model.dao.impl.SellerDaoJDBC;

public class DaoFactory {

    public static SellerDao createSellerDao(){
        return new SellerDaoJDBC(DB.getConnection());
    }

    public static DepartmentDao createDepartmentDao(){
        return new DepartmentDaoJDBC(DB.getConnection());
    }
}
