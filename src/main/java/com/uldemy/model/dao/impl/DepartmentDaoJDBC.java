package com.uldemy.model.dao.impl;

import com.uldemy.db.DB;
import com.uldemy.db.DbException;
import com.uldemy.db.DbIntegrityException;
import com.uldemy.model.dao.DepartmentDao;
import com.uldemy.model.entities.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDao {

    private Connection conn;

    public DepartmentDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Department obj) {
        PreparedStatement st = null;
        ResultSet rs = null;
         try {
             st = conn.prepareStatement("""
                     INSERT INTO department
                     (Name)
                     VALUES
                     (?)
                     """, Statement.RETURN_GENERATED_KEYS);

             st.setString(1, obj.getName());

             int rowsAffected = st.executeUpdate();

             if (rowsAffected > 0){
                 rs = st.getGeneratedKeys();
                 if (rs.next()){
                     int id = rs.getInt(1);
                     obj.setId(id);
                 }
             }
             else {
                 throw new DbException("Unexpected error! No rows affected!");
             }

         } catch (SQLException e) {
             e.printStackTrace();
         }
         finally {
             DB.closeStatement(st);
             DB.closeResultSet(rs);
         }

    }

    @Override
    public void update(Department obj) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("""
                    UPDATE department
                    SET Name = ?
                    WHERE Id = ?
                    """);

            st.setString(1, obj.getName());
            st.setInt(2, obj.getId());

            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
        }

    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("""
                    DELETE FROM department
                    WHERE Id = ?
                    """);

            st.setInt(1, id);
            int rows = st.executeUpdate();

            if (rows == 0){
                throw new DbException("No exist id");
            }

        } catch (SQLException e) {
            throw new DbIntegrityException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public Department fingById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("""
                    SELECT * FROM department
                    WHERE Id = ?
                    """);

            st.setInt(1, id);

            rs = st.executeQuery();

            if (rs.next()) {
                return instantiateDepartment(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
        return null;
    }

    @Override
    public List<Department> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("""
                    SELECT * FROM department
                    ORDER BY Name
                    """);

            rs = st.executeQuery();
            List<Department> departments = new ArrayList<>();

            while (rs.next()){
                Department department = instantiateDepartment(rs);
                departments.add(department);
            }

            return departments;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
        return null;
    }

    private Department instantiateDepartment(ResultSet rs) throws SQLException {
        Department dep = new Department();
        dep.setId(rs.getInt("Id"));
        dep.setName(rs.getString("Name"));
        return dep;
    }
}
