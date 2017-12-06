package com.wind.sharedadvertisement;

import com.wind.sharedadvertisement.util.Constants;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "UploadVideoServlet")
public class UploadVideoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        if (!ServletFileUpload.isMultipartContent(request)) {
            response.setCharacterEncoding("utf-8");
            pw.println("Error: 表单必须包含 enctype=multipart/form-data");
            return;
        }
        //获得磁盘文件条目工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
        factory.setSizeThreshold(Constants.UPLOAD_VIDEO_MEMORY_THRESHOLD);
        // 设置临时存储目录
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
        System.out.println("java.io.tmpdir = " + System.getProperty("java.io.tmpdir"));

        ServletFileUpload upload = new ServletFileUpload(factory);
        // 设置最大文件上传值
        upload.setFileSizeMax(Constants.UPLOAD_VIDEO_MAX_FILE_SIZE);
        // 设置最大请求值 (包含文件和表单数据)
        upload.setSizeMax(Constants.UPLOAD_VIDEO_MAX_REQUEST_SIZE);
        upload.setHeaderEncoding("utf-8");  // 中文处理

//        文件上传需要保存的路径
//        String uploadPath = request.getServletContext().getRealPath("./") +
//                Constants.UPLOAD_VIDEO_DIRECTORY;
        String uploadPath = "E:\\server\\project\\zhengzhe\\IdeaProjects\\SharedAdvertisement\\SharedAdvertisement\\web";
        System.out.println("getRealPath = " + request.getServletContext().getRealPath("./"));
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        try {
            List<FileItem> items = upload.parseRequest(request);
            if (items != null && items.size() > 0) {
                for(FileItem item : items) {
                    //如果获取的表单信息是普通的文本信息
                    if (item.isFormField()) {

                    } else {  //如果传入的是非简单字符串，而是图片，音频，视频等二进制文件
                        System.out.println("item.getName() = " + item.getName());
                        String fileName = new File(item.getName()).getName();
                        String filePath = uploadPath + File.separator + fileName;
                        System.out.println("filePath = " + filePath);
                        File storeFile = new File(filePath);
                        item.write(storeFile);
                    }
                }
            }
        } catch (Exception e) {
            pw.println("upload_error");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
