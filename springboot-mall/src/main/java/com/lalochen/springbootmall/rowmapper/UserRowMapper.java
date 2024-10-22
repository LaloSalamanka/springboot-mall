package com.lalochen.springbootmall.rowmapper;

import com.lalochen.springbootmall.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

// 將資料庫的結果，轉換為 User Object

public class UserRowMapper implements RowMapper<User> {

    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setUserId(resultSet.getInt("user_Id"));
        user.setEmail(resultSet.getString("email"));
        user.setPassword(resultSet.getString("password"));
        user.setCreatedDate(resultSet.getTimestamp("created_Date"));
        user.setLastModifiedDate(resultSet.getTimestamp("last_Modified_Date"));
        return user;
    }

}
