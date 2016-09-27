package com.sun.cycleviewpager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //ImageInfo  List
    private List<ImageInfo> mImageList ;
    //轮播图控件
    private CycleViewPager mCycleViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        parseData();
    }

    /**
     * 初始化View
     */
    private void initView() {
        mCycleViewPager = (CycleViewPager) findViewById(R.id.cycle_view);

        /*if (mCycleViewPager != null){
            mCycleViewPager.setIndicators(R.mipmap.ad_select, R.mipmap.ad_unselect);
        }
        //设置轮播间隔时间，默认为4000
        mCycleViewPager.setDelay(2000);*/

    }

    /**
     * 解析数据
     */
    private void parseData() {
        mImageList = new ArrayList<>();
        mImageList.add(new ImageInfo( "http://ww3.sinaimg.cn/mw690/a7295e45gw1f87era1f79j21e00xch57.jpg","标题1"));
        mImageList.add(new ImageInfo( "http://ww3.sinaimg.cn/mw690/a7295e45gw1f87er81a8ej20e40b4tbs.jpg","标题2"));
        mImageList.add(new ImageInfo("http://ww3.sinaimg.cn/mw690/a7295e45gw1f87er7ui5mj20f0096whc.jpg","标题3"));
        mImageList.add(new ImageInfo("http://ww1.sinaimg.cn/mw690/a7295e45gw1f87er8l9qnj20gc09gn08.jpg","标题4"));
        mImageList.add(new ImageInfo("http://ww4.sinaimg.cn/mw690/a7295e45gw1f87er87b7pj20es0b4acz.jpg","标题5"));
        List<ImageView> imageViews = new ArrayList<>();
        // 将最后一个ImageView添加进来
        imageViews.add(ImageFactory.getImageView(this,mImageList.get(mImageList.size()-1).getImgUrl()));
        for (int i = 0; i < mImageList.size(); i ++){
            imageViews.add(ImageFactory.getImageView(this,mImageList.get(i).getImgUrl()));
        }
        // 将第一个ImageView添加进来
        imageViews.add(ImageFactory.getImageView(this,mImageList.get(0).getImgUrl()));
        if (mImageList.size() == 1) {
            mCycleViewPager.hideIndicator();
            // 设置循环，在调用setData方法前调用
            mCycleViewPager.setCycle(false);
            // 设置轮播
            mCycleViewPager.setWheel(false);
        } else {
            // 设置循环，在调用setData方法前调用
            mCycleViewPager.setCycle(true);
            // 设置轮播
            mCycleViewPager.setWheel(true);
        }

        mCycleViewPager.setData(imageViews,mImageList, mCycleViewListener);
        //设置轮播间隔时间，默认为4000
        mCycleViewPager.setDelay(2000);
        mCycleViewPager.setIndicatorCenter();
    }

    /**
     * 轮播图点击监听
     */
    private CycleViewPager.ImageCycleViewListener mCycleViewListener = new CycleViewPager.ImageCycleViewListener() {

        @Override
        public void onImageClick(ImageInfo imageInfo, int position, View imageView) {

            if (mCycleViewPager.isCycle()) {
                position = position - 1;
            }
            Toast.makeText(MainActivity.this, imageInfo.getDescription() + "选择了--" + position, Toast.LENGTH_LONG).show();
        }
    };


}
