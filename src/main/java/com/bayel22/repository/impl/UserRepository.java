package com.bayel22.repository.impl;

import com.bayel22.entity.User;
import com.bayel22.repository.Repo;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserRepository implements Repo<User> {
    public static final String GET_BY_ID = """
            SELECT id, password
            FROM users
            WHERE id=?
            """;

    public static final String UPDATE = """
            UPDATE users
            SET id=?, password=?
            WHERE id=?
            """;
    @Autowired
    @Qualifier("getConnectionPool")
    private HikariDataSource connectionPool;

    @Override
    public User getById(Long id) {
        try(Connection connection = connectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setPassword(resultSet.getString("password"));
                return user;
            } else {
                throw new RuntimeException("No such user");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(User entity) {
        try(Connection connection = connectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setLong(1, entity.getId());
            preparedStatement.setString(2, entity.getPassword());
            preparedStatement.setLong(3, entity.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
