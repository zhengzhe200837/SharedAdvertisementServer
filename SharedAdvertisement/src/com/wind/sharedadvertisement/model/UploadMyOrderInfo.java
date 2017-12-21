package com.wind.sharedadvertisement.model;

import java.util.List;

public class UploadMyOrderInfo {
    private String todo;
    private String tableName;
    private String orderId;
    private int billBoardId;
    private long totalPrice;
    private int durationTime;
    private int playTimes;
    private int orderStatus;
    private String userPhone;
    private String playStartTime;  //年月日时分秒
    private String mediaName;
    public  String businessPhone;
    private List<String> mJustSelectedPlayTimeSegments;

    public UploadMyOrderInfo(String todo, String tableName, String orderId, int billBoardId, long totalPrice, int durationTime, int playTimes,
                             int orderStatus, String userPhone, String playStartTime, String mediaName, String businessPhone,
                             List<String> justSelectedPlayTimeSegments) {
        this.todo = todo;
        this.tableName = tableName;
        this.orderId = orderId;
        this.billBoardId = billBoardId;
        this.totalPrice = totalPrice;
        this.durationTime = durationTime;
        this.playTimes = playTimes;
        this.orderStatus = orderStatus;
        this.userPhone = userPhone;
        this.playStartTime = playStartTime;
        this.mediaName = mediaName;
        this.businessPhone = businessPhone;
        this.mJustSelectedPlayTimeSegments = justSelectedPlayTimeSegments;
    }

    public int getDurationTime() {
        return durationTime;
    }

    public List<String> getmJustSelectedPlayTimeSegments() {
        return mJustSelectedPlayTimeSegments;
    }
}
