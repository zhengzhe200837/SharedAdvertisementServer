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

    public BillboardInfo(String billboardId, long price, String address, String equipmentType,
                         String screenType, long screenWidth, long screenHeight, String businessPhone,
                         String startDate, String endDate, String startTime, String endTime,
                         String pictureUrl, String equipmentAttribute, String screenAttritute){
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
    }

    public static class BillBoardInfoBuilder {
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

        public BillBoardInfoBuilder() {
        }

        public BillboardInfo build() {
            return new BillboardInfo(billboardId, price, address, equipmentType,
                    screenType, screenWidth, screenHeight, businessPhone,
                    startDate, endDate, startTime, endTime,
                    pictureUrl, equipmentAttribute, screenAttritute);
        }
        public BillBoardInfoBuilder setEquipmentAttribute(String equipmentAttribute) {
            this.equipmentAttribute = equipmentAttribute;
            return this;
        }
        public BillBoardInfoBuilder setScreenAttritute(String screenAttritute) {
            this.screenAttritute = screenAttritute;
            return this;
        }
        public BillBoardInfoBuilder setPictureUrl(String picture_url) {
            this.pictureUrl = picture_url;
            return this;
        }

        public long getPrice() {
            return this.price;
        }

        public BillBoardInfoBuilder setPrice(long price) {
            this.price = price;
            return this;
        }

        public String getAddress() {
            return this.address;
        }

        public BillBoardInfoBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public String getEquipmentType() {
            return this.equipmentType;
        }

        public BillBoardInfoBuilder setEquipmentType(String equipmentType) {
            this.equipmentType = equipmentType;
            return this;
        }

        public String getScreenType() {
            return this.screenType;
        }

        public BillBoardInfoBuilder setScreenType(String screenType) {
            this.screenType = screenType;
            return this;
        }

        public long getScreenWidth() {
            return this.screenWidth;
        }

        public BillBoardInfoBuilder setScreenWidth(long width) {
            this.screenWidth = width;
            return this;
        }

        public long getScreenHeight() {
            return this.screenHeight;
        }

        public BillBoardInfoBuilder setScreenHeight(long height) {
            this.screenHeight = height;
            return this;
        }

    }

    public long getPrice() {
        return this.price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEquipmentType() {
        return this.equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public String getScreenType() {
        return this.screenType;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    public long getScreenWidth() {
        return this.screenWidth;
    }

    public void setScreenWidth(long width) {
        this.screenWidth = width;
    }

    public long getScreenHeight() {
        return this.screenHeight;
    }

    public void setScreenHeight(long height) {
        this.screenHeight = height;
    }
}
