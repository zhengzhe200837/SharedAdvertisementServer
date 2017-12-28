package com.wind.sharedadvertisement.model;

public class BillboardInfo {
    private String billboardId;
    private long price;
    private String address;
    private String equipmentType;
    private String screenType;
    private long screenWidth;
    private long screenHeight;

    private String startDate;  //开始年月日
    private String endDate;    //结束年月日
    private String startTime;  //每天开始的时分秒
    private String endTime;    //每天结束的时分秒

    private String businessPhone;
    private String pictureUrl;
    private String equipmentAttribute;
    private String screenAttritute;
    private String equipmentName;

    public BillboardInfo(String billboardId, long price, String address, String equipmentType,
                         String screenType, long screenWidth, long screenHeight, String businessPhone,
                         String startDate, String endDate, String startTime, String endTime,
                         String pictureUrl, String equipmentAttribute, String screenAttritute,
                         String equipmentName){
        this.billboardId = billboardId;
        this.businessPhone = businessPhone;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.pictureUrl = pictureUrl;
        this.price = price;
        this.address = address;
        this.equipmentType = equipmentType;
        this.screenType = screenType;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.equipmentAttribute = equipmentAttribute;
        this.screenAttritute = screenAttritute;
        this.equipmentName = equipmentName;
    }
}
