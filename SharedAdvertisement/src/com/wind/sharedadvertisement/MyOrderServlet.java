package com.wind.sharedadvertisement;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MyOrderServlet")
public class MyOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = "E:\\server\\project\\zhengzhe\\IdeaProjects\\SharedAdvertisement\\SharedAdvertisement\\web";
        String domain = "http://192.168.31.109:8080/SharedAdvertisement/";
        File file = new File("E:\\server\\project\\zhengzhe\\IdeaProjects\\SharedAdvertisement\\SharedAdvertisement\\web");
        String[] videos = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if (name.endsWith("mp4") || name.endsWith("3gp")) {
                    return true;
                }
                return false;
            }
        });
        Gson gson = new Gson();
        List<VideoInfo> list = new ArrayList<VideoInfo>();
        for (String video : videos) {
            VideoInfo vi = new VideoInfo(video, domain + video, "checking");
            list.add(vi);
        }
        response.setCharacterEncoding("utf-8");
        PrintWriter pw = response.getWriter();
        pw.println(gson.toJson(list));
    }

    public static class VideoInfo {
        private String videoName = null;
        private String videoUrl = null;
        private String status = null;
        public VideoInfo(String name, String url, String status) {
            this.videoName = name;
            this.videoUrl = url;
            this.status = status;
        }
    }
}
