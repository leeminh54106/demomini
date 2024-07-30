package com.example.miniproject.dao.impl;

import com.example.miniproject.dao.ICategoryDao;
import com.example.miniproject.entity.Category;
import com.example.miniproject.utils.ConnectionDB;
import jdk.vm.ci.meta.SpeculationLog;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements ICategoryDao {


    @Override
    public List<Category> findAll() {
        //1 tao ket noi
        Connection con = ConnectionDB.openConnection();
        List<Category> categories = new ArrayList<>();
        try {
        // 2. thực hiện truy vấn
            PreparedStatement ps = con.prepareStatement("select * from category");
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                category.setStatus(rs.getBoolean("status"));
                categories.add(category);
            }
        } catch (SQLException e) {
           throw new RuntimeException(e);

        } finally {
            // 3. đóng kết nối
            ConnectionDB.closeConnection(con);
        }
        return categories;
    }
}
