package com.wind.sharedadvertisement;

import com.google.gson.Gson;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MyOrderServlet")
public class MyOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InputStream is = request.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String body = br.readLine();
        System.out.println("zz + MyOrderServlet + body = " + body);

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
            VideoInfo vi = new VideoInfo(video, domain + video, 1, "20171120180000");
            list.add(vi);
        }
        response.setCharacterEncoding("utf-8");
        PrintWriter pw = response.getWriter();
        pw.println(gson.toJson(list));
        System.out.println("zz + MyOrderServlet + response = " + gson.toJson(list));
    }

    public static class VideoInfo {
        private String name;
        private String url;
        private int order_status;   //订单状态：0审核通过还未播放，1已播放，2未审核，3审核不通过，4审核通过未上传
        private String playTime = null;
        public VideoInfo(String name, String url, int status, String playTime) {
            this.name = name;
            this.url = url;
            this.order_status = status;
            this.playTime = playTime;
        }
    }
}
