package com.wind.sharedadvertisement;

import com.google.gson.Gson;
import com.wind.sharedadvertisement.util.Constants;
import com.wind.sharedadvertisement.util.DatabaseUtils;

import javax.servlet.ServletException;
import javax.servlet.UnavailableException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@javax.servlet.annotation.WebServlet(name = "SharedAdvertisement")
public class SharedAdvertisement extends javax.servlet.http.HttpServlet {

    private DatabaseUtils mDatabaseUtils = null;

    public void init() throws javax.servlet.ServletException {
        mDatabaseUtils = new DatabaseUtils();
        mDatabaseUtils.registerJdbcDriver();
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String sql = "SELECT * FROM taobao";
        ResultSet rs = mDatabaseUtils.executeQuery(sql);
        try {
            while(rs.next()) {
                System.out.print(rs.getString("user"));
            }
            mDatabaseUtils.createDB("location_info");
            mDatabaseUtils.closeResource();
        } catch (Exception e) {
            mDatabaseUtils.closeResource();
        }

            response.setContentType("text/html");
            response.setCharacterEncoding("utf-8");
            PrintWriter out = response.getWriter();

            VideoUrl vu = new VideoUrl("http://192.168.31.109:8080/SharedAdvertisement/Video1.mp4");
            Gson gson = new Gson();
            out.println(gson.toJson(vu));
    }

    public static class VideoUrl {
        private String url = null;
        public VideoUrl(String url) {
            this.url = url;
        }
    }
}
