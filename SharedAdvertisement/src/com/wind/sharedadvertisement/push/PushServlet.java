package com.wind.sharedadvertisement.push;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PushServlet")
public class PushServlet extends HttpServlet {

    private static final String appKey ="4519ee6936564bda67f9690f";
    private static final String masterSecret = "2a3fe87e16a22a7b3a7fd6ba";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Jdpush.testSendPush(appKey,masterSecret);
    }
}
