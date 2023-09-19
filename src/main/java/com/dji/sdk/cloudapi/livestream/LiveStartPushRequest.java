package com.dji.sdk.cloudapi.livestream;

import com.dji.sdk.cloudapi.device.VideoId;
import com.dji.sdk.common.BaseModel;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author sean
 * @version 1.7
 * @date 2023/5/23
 */
public class LiveStartPushRequest extends BaseModel {

    @NotNull
    private UrlTypeEnum urlType;

    /**
     * RTMP: (rtmp://xxxxxxx) Example: rtmp://192.168.1.1:8080/live
     * RTSP：(uerName&password&port) Example: userName=dji-cloud-api&password=123456&port=8080
     * GB28181：(serverIP&serverPort&serverID&agentID&agentPassword&localPort&channel)
     *  Example: serverIP=192.168.1.1&serverPort=8080&serverID=34000000000000000000&agentID=
     *  300000000010000000000&agentPassword=0000000&localPort=7060&channel=340000000000000000000
     * AGORA：(channel&sn&token&uid)
     *  Example: channel=1ZNDH360010162_39-0-7&sn=1ZNDH360010162&token=006dca67721582a48768ec4d8
     *  17b7b25a86IAB4cw2JgN6iX8BpTPdc3e4S1Iendz94IFJ56aSXKvzAJei27MqF2zyCIgCLIIoBt41+YAQAAQC3jX
     *  5gAgC3jX5gAwC3jX5gBAC3jX5g&uid=50000
     *  Notice: The token generated by Shengwang may have special characters such as '+' ' ',
     *  and need to do url encode, otherwise there will be a parsing error on the PILOT side
     */
    @NotBlank
    private String url;

    /**
     * The format is #{uav_sn}/#{camera_id}/#{video_index},
     * drone serial number/payload and mounted location enumeration value/payload lens numbering
     */
    @NotNull
    private VideoId videoId;

    @NotNull
    private VideoQualityEnum videoQuality;

    public LiveStartPushRequest() {
    }

    @Override
    public String toString() {
        return "LiveStartPushRequest{" +
                "urlType=" + urlType +
                ", url='" + url + '\'' +
                ", videoId=" + videoId +
                ", videoQuality=" + videoQuality +
                '}';
    }

    public UrlTypeEnum getUrlType() {
        return urlType;
    }

    public LiveStartPushRequest setUrlType(UrlTypeEnum urlType) {
        this.urlType = urlType;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public LiveStartPushRequest setUrl(String url) {
        this.url = url;
        return this;
    }

    public VideoId getVideoId() {
        return videoId;
    }

    public LiveStartPushRequest setVideoId(VideoId videoId) {
        this.videoId = videoId;
        return this;
    }

    public VideoQualityEnum getVideoQuality() {
        return videoQuality;
    }

    public LiveStartPushRequest setVideoQuality(VideoQualityEnum videoQuality) {
        this.videoQuality = videoQuality;
        return this;
    }
}
