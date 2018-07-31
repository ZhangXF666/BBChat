package com.example.zhangxinfang.bbchat;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MineFragment extends Fragment{
    private RecyclerView mRecyclerView;


    private List<Item> viewData = new ArrayList<Item>();
    ;


    private String[] ResID = new String[]{
            "jasper",
            "石头",
            "小山竹",
            "Angela",
            "Cindy",
            "小草莓",
            "杨幂",
            "赵丽颖",
            "田亮",
            "范冰冰",
            "多多",
            "KiMi",
            "林志颖",
            "陈小春",
            "饺子",
    };
    int mCurrentIndex = 0;


    private int[] imageResID = new int[]{
            R.drawable.tu1,
            R.drawable.tu2,
            R.drawable.tu3,
            R.drawable.tu4,
            R.drawable.tu5,
            R.drawable.tu6,
            R.drawable.tu7,
            R.drawable.tu8,
            R.drawable.tu9,
            R.drawable.tu10,
            R.drawable.tu11,
            R.drawable.tu12,
            R.drawable.tu13,
            R.drawable.tu14,
            R.drawable.tu15,


    };
    int mCurrentIndexImage = 0;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mine, container, false);




        return view;
    }
}
