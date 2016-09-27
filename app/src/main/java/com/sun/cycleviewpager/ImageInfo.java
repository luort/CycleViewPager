package com.sun.cycleviewpager;

/**
 * ImageView基础类
 * Created on 2016/9/27.
 */
public class ImageInfo {

    //图片地址
    private String imgUrl;
    //图片链接地址
    private String linkUrl;
    //图片内容描述
    private String description;


    public ImageInfo(String imgUrl, String description) {
        this.imgUrl = imgUrl;
        this.description = description;
    }

    public ImageInfo(String imgUrl, String linkUrl, String description) {
        this.imgUrl = imgUrl;
        this.linkUrl = linkUrl;
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
