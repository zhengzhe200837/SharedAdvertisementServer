package com.wind.sharedadvertisement.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseUtils {
    private Statement mStatement = null;
    private Connection mConnection = null;

    public void registerJdbcDriver() {
        try {
            Class.forName(Constants.JDBC_DRIVER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createConnectionAndStatement() {
        try {
            mConnection = DriverManager.getConnection(Constants.DB_URL, Constants.USER, Constants.PASS);
            mStatement = mConnection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createDB(String name) {
        String sql = "CREATE DATABASE " + name;
        if (mStatement == null) {
            createConnectionAndStatement();
        }
        try {
            mStatement.executeUpdate(sql);
        } catch (Exception e) {

        }
    }

    public ResultSet executeQuery(String sql) {
        ResultSet rs = null;
        if (mStatement == null) {
            createConnectionAndStatement();
        }
        try {
            rs = mStatement.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public void closeResource() {
        try {
            mConnection.close();
            mStatement.close();
            mConnection = null;
            mStatement = null;
        } catch (Exception e) {

        }
    }
}
