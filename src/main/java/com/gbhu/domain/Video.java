package com.gbhu.domain;

import java.util.Date;

/**
 *   `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
 *   `title` varchar(524) DEFAULT NULL COMMENT '视频标题',
 *   `summary` varchar(1026) DEFAULT NULL COMMENT '概述',
 *   `cover_img` varchar(524) DEFAULT NULL COMMENT '封面图',
 *   `price` int(11) DEFAULT NULL COMMENT '价格,分',
 *   `create_time` datetime DEFAULT NULL COMMENT '创建时间',
 *   `point` double(11,2) DEFAULT '8.70' COMMENT '默认8.7，最高10分',
 *   PRIMARY KEY (`id`)
 */
public class Video {

    private Integer videoId;

    private String title;

    private String summary;

    private String coverImg;

    private Integer price;

    private Date createTime;

    private Double point;

//    private List<Chapter> chapterList;


    @Override
    public String toString() {
        return "Video{" +
                "id=" + videoId +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", coverImg='" + coverImg + '\'' +
                ", price=" + price +
                ", createTime=" + createTime +
                ", point=" + point +
                '}';
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }

//    public List<Chapter> getChapterList() {
//        return chapterList;
//    }
//
//    public void setChapterList(List<Chapter> chapterList) {
//        this.chapterList = chapterList;
//    }
}
