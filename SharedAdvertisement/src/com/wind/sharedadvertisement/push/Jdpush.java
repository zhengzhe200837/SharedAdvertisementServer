package com.wind.sharedadvertisement.push;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.audience.AudienceTarget;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

import java.util.Calendar;

public class Jdpush {
    protected static final Logger LOG = LoggerFactory.getLogger(Jdpush.class);
    // demo App defined in resources/jpush-api.conf

    public static final String ALERT = "您有新的订单信息";
    public static final String MSG_CONTENT = "订单信息";
    public static final String REGISTRATION_ID = "13065ffa4e0d53ae034";
    public static final String TAG = "tag_api";

    public  static JPushClient jpushClient=null;

    public static void testSendPush(String appKey ,String masterSecret) {
        jpushClient = new JPushClient(masterSecret, appKey, 3);

        //生成推送的内容
        PushPayload payload=buildPushObject_audience_messageWithExtras();

        try {
            System.out.println(payload.toString());
            PushResult result = jpushClient.sendPush(payload);
            System.out.println(result+"................................");

            LOG.info("Got result - " + result);

        } catch (Exception e) {
            LOG.error("Connection error. Should retry later. ", e);
        }
    }

    public static PushPayload buildPushObject_audience_messageWithExtras() {
        getCurrentTime();

        Gson gson = new Gson();
        VideoUrl vu = new VideoUrl("http://192.168.31.109:8080/SharedAdvertisement/VID.3gp", "20171226154100", 0, "VID.3gp", 10, "zhengzhe");
        String vuG = gson.toJson(vu);
        System.out.println(vuG);

        return PushPayload.newBuilder()
                .setPlatform(Platform.all())//设置接受的平台
//                 .setAudience(Audience.registrationId(REGISTRATION_ID))//客户端调用接口获取到的registration id
                .setAudience(Audience.all())
                .setNotification(Notification.alert(ALERT))
                .setMessage(Message.newBuilder()
                        .setMsgContent(MSG_CONTENT)
                        .addExtra("message", vuG)
                        .build())
                .build();
    }

    private static String mCurrentTime;

    private static void getCurrentTime() {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int date = c.get(Calendar.DATE);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);
        mCurrentTime = "" + year + month + date + hour + minute + second;
        System.out.println("mCurrentTime = " + mCurrentTime);
    }

    public static class VideoUrl {
        private String url = null;
        private String playTime = null;
        private int order_status = -1;
        private String name;
        private int playTimes;
        private String orderId;
        public VideoUrl(String url, String playTime, int order_status, String name, int playTimes, String orderId) {
            this.url = url;
            this.playTime = playTime;
            this.order_status = order_status;
            this.name = name;
            this.playTimes = playTimes;
            this.orderId = orderId;
        }
    }

//     public static PushPayload buildPushObject_ios_tagAnd_alertWithExtrasAndMessage() {
//         return PushPayload.newBuilder()
//                 .setPlatform(Platform.ios())
//                 .setAudience(Audience.tag_and("tag1", "tag_all"))
//                 .setNotification(Notification.newBuilder()
//                         .addPlatformNotification(IosNotification.newBuilder()
//                                 .setAlert(ALERT)
//                                 .setBadge(5)
//                                .setSound("happy")
//                                 .addExtra("from", "JPush")
//                                 .build())
//                         .build())
//                  .setMessage(Message.content(MSG_CONTENT))
//                  .setOptions(Options.newBuilder()
//                          .setApnsProduction(true)
//                          .build())
//                  .build();
//     }
}

