package com.wind.sharedadvertisement.util;

public class Constants {
//    JDBC 驱动名
    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//    数据库 URL
    public static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    public static final String USER = "root";
    public static final String PASS = "App123";
//    上传视频文件存储目录
    public static final String UPLOAD_VIDEO_DIRECTORY = "upload_video";
//    上传配置
    public static final int UPLOAD_VIDEO_MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    public static final int UPLOAD_VIDEO_MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    public static final int UPLOAD_VIDEO_MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
}
