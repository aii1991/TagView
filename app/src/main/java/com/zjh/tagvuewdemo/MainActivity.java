package com.zjh.tagvuewdemo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;

import com.zjh.library.bean.TagBean;
import com.zjh.library.widget.TagView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TagView mTagView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTagView = (TagView) findViewById(R.id.tag_view);
        initData();
    }

    private void initData() {
        List<TagBean> tags = new ArrayList<>();
        TagBean tag1 = new TagBean.Builder()
                .setText("德玛西亚")
                .setBgColor(Color.RED)
                .setTextColor(Color.WHITE)
                .setTop(1)
                .setLeft(80)
                .setRight(300)
                .setBottom(100)
                .setStrokeColor(Color.GRAY)
                .setStrokeWidth(10)
                .setTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,15,getResources().getDisplayMetrics()))
                .setRotateDegrees(30)
                .build();
        tags.add(tag1);



        TagBean tag2 = new TagBean.Builder()
                .setText("我的大刀已饥渴难耐")
                .setBgColor(Color.BLUE)
                .setTextColor(Color.WHITE)
                .setTop(300)
                .setLeft(150)
                .setPadding(50)
                .setTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,15,getResources().getDisplayMetrics()))
                .setRotateDegrees(10)
                .build();
        tags.add(tag2);


        TagBean tag3 = new TagBean.Builder()
                .setText("我的剑就是你的剑")
                .setBgColor(Color.GREEN)
                .setTextColor(Color.WHITE)
                .setTop(600)
                .setLeft(200)
                .setPadding(50)
                .setTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,15,getResources().getDisplayMetrics()))
                .build();
        tags.add(tag3);

        mTagView.setTags(tags);
    }
}
