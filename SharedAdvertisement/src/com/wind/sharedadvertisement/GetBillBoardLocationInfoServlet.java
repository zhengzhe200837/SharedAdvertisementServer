package com.wind.sharedadvertisement;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "GetBillBoardLocationInfoServlet")
public class GetBillBoardLocationInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取post中的body
        InputStream is = request.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String body = br.readLine();
        System.out.println("zz + GetBillBoardLocationInfoServlet + body = " + body);

        LocationPoint lp1 = new LocationPoint(31.168754 + 0.001, 121.41196 + 0.001, "zz1");   //维度 31.168754  经度 121.41196
        LocationPoint lp2 = new LocationPoint(31.168754 - 0.001, 121.41196 + 0.001, "zz2");
        LocationPoint lp3 = new LocationPoint(31.168754 + 0.001, 121.41196 - 0.001, "zz3");
        LocationPoint lp4 = new LocationPoint(31.168754 - 0.001, 121.41196 - 0.001, "zz4");
        List<LocationPoint> list = new ArrayList<>();
        list.add(lp1);
        list.add(lp2);
        list.add(lp3);
        list.add(lp4);
        Gson gson = new Gson();
        String r = gson.toJson(list);
        response.getWriter().println(r);
        System.out.println("zz + GetBillBoardLocationInfoServlet + response = " + r);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public static class LocationPoint {
        private double latitude;
        private double longitude;
        private String billboardId;

        public LocationPoint(double latitude, double longitude, String billboardId) {
            this.latitude = latitude;
            this.longitude = longitude;
            this.billboardId = billboardId;
        }
    }
}
