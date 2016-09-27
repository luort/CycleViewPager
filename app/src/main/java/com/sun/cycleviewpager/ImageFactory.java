package com.sun.cycleviewpager;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * ImageView创建工厂
 * Created on 2016/9/27.
 */

public class ImageFactory {

    /**
     * 获取ImageView视图的同时加载显示url
     * @param context
     * @param url
     * @return
     */
    public static ImageView getImageView(Context context, String url) {
        return getImageView(context, url, R.drawable.img_default_banner);
    }

    /**
     * 获取ImageView视图的同时加载显示url
     * @param context
     * @param url
     * @param defaultImg
     * @return
     */
    public static ImageView getImageView(Context context, String url, int defaultImg) {
        ImageView imageView = (ImageView) LayoutInflater.from(context).inflate(R.layout.layout_imageview, null);
        Glide.with(context).load(url).placeholder(defaultImg).into(imageView);
        return imageView;
    }
}
