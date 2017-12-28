package com.wind.sharedadvertisement;

import com.google.gson.Gson;
import com.wind.sharedadvertisement.model.BillboardInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@WebServlet(name = "GetBillBoardDetailInfoServlet")
public class GetBillBoardDetailInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取postbody中数据
        InputStream is = request.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String body = br.readLine();
        System.out.println("zz + GetBillBoardDetailInfoServlet + body = " + body);

        Gson gson = new Gson();
        BillboardInfo bi = new BillboardInfo("billboard", 30, "陕西", "设备类型",
                "屏幕类型", 100, 200, "15800734916", "20171221", "20171230",
                "150000", "180000", "http://192.168.31.109:8080/SharedAdvertisement/picture2.png",
                "设备属性", "屏幕属性", "世博大屏");
        String r = gson.toJson(bi);
        response.setCharacterEncoding("utf-8");  //确保接收到的汉字不乱码
        response.getWriter().println(r);
        System.out.println("zz + GetBillBoardDetailInfoServlet + response = " + r);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
