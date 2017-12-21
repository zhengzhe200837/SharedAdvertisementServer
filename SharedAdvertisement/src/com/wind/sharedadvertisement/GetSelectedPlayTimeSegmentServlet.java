package com.wind.sharedadvertisement;

import com.google.gson.Gson;
import com.wind.sharedadvertisement.model.SelectedPlayTimeSegment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "GetSelectedPlayTimeSegmentServlet")
public class GetSelectedPlayTimeSegmentServlet extends HttpServlet {
    private List<SelectedPlayTimeSegment> mSelectedPlayTimeSegments = new ArrayList<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InputStream is = request.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String body = br.readLine();
        System.out.println("zz + GetSelectedPlayTimeSegmentServlet + body = " + body);

        SelectedPlayTimeSegment s1 = new SelectedPlayTimeSegment("0", "20171220", "153030", 1);
        SelectedPlayTimeSegment s2 = new SelectedPlayTimeSegment("0", "20171220", "163030", 1);
        SelectedPlayTimeSegment s3 = new SelectedPlayTimeSegment("0", "20171220", "172000", 1);
        SelectedPlayTimeSegment s4 = new SelectedPlayTimeSegment("0", "20171220", "175930", 1);
        mSelectedPlayTimeSegments.add(s1);
        mSelectedPlayTimeSegments.add(s2);
        mSelectedPlayTimeSegments.add(s3);
        mSelectedPlayTimeSegments.add(s4);
        Gson gson = new Gson();
        String responseData = gson.toJson(mSelectedPlayTimeSegments);
        PrintWriter pw = response.getWriter();
        pw.println(responseData);
        System.out.println("zz + GetSelectedPlayTimeSegmentServlet + response = " + responseData);
    }
}
