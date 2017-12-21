package com.wind.sharedadvertisement;

import com.google.gson.Gson;
import com.wind.sharedadvertisement.model.BillboardInfo;
import com.wind.sharedadvertisement.model.SelectedPlayTimeSegment;
import com.wind.sharedadvertisement.model.UploadMyOrderInfo;
import com.wind.sharedadvertisement.util.Constants;
import com.wind.sharedadvertisement.util.DatabaseUtils;

import javax.servlet.ServletException;
import javax.servlet.UnavailableException;
import java.io.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@javax.servlet.annotation.WebServlet(name = "SharedAdvertisement")
public class SharedAdvertisement extends javax.servlet.http.HttpServlet {

    private DatabaseUtils mDatabaseUtils = null;
    private BillboardInfo mBillboardInfo;

    public void init() throws javax.servlet.ServletException {
        mDatabaseUtils = new DatabaseUtils();
        mDatabaseUtils.registerJdbcDriver();
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
//        UploadMyOrderInfo info = gson.fromJson(userjson, UploadMyOrderInfo.class);
//        int year = info.getDurationTime();
//        List<String> list = info.getmJustSelectedPlayTimeSegments();
//        System.out.println("listsize = "+ list.size());
//        for(int i = 0; i < list.size(); i++) {
//            System.out.println("content = "+ list.get(i));
//        }
//        response.getWriter().println("成功success");
//        String utf8Json = new String(userjson.getBytes(), "utf-8");
//        System.out.println("utf8Json:"+utf8Json.toString());
//        response.setCharacterEncoding("utf-8");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
//        String sql = "SELECT * FROM taobao";
//        ResultSet rs = mDatabaseUtils.executeQuery(sql);
//        try {
//            while(rs.next()) {
//                System.out.print(rs.getString("user"));
//            }
//            mDatabaseUtils.createDB("location_info");
//            mDatabaseUtils.closeResource();
//        } catch (Exception e) {
//            mDatabaseUtils.closeResource();
//        }
    }
}
