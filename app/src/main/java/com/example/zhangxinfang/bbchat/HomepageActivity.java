package com.example.zhangxinfang.bbchat;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class HomepageActivity extends AppCompatActivity{
    //声明ViewPager
    private ViewPager viewPager;
    //声明TabLayout
    private TabLayout tabLayout;
    private List<Fragment> fragments = new ArrayList<>();
    private List<String> tabs = new ArrayList<>(); //标签名称
    private List<Integer> tabNumbers = new ArrayList<>(); //信息数目
    private ViewHolder holder;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//???
        setContentView(R.layout.homepage);

        initViews();//初始化控件
//        initEvents();//初始化事件
        initDatas();//初始化数据

    }

    private void initDatas(){
        tabs.add("消息" );
        tabs.add("好友");
        tabs.add("我的");

        tabNumbers.add(999);
        tabNumbers.add(99);
        tabNumbers.add(9);

        fragments.add(new TabFragment(this,tabs.get(0)));
        fragments.add(new TabFragment(this,tabs.get(1)));
        fragments.add(new TabFragment(this,tabs.get(2)));
//
//        //初始化适配器
//        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
//            @Override
//            public Fragment getItem(int position) {//从集合中获取对应位置的Fragment
//                return mFragments.get(position);
//            }
//
//            @Override
//            public int getCount() {//获取集合中Fragment的总数
//                return mFragments.size();
//            }
//
//        };
//
//        //不要忘记设置ViewPager的适配器
//        mViewPager.setAdapter(mAdapter);
//        //设置ViewPager的切换监听
//        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            //页面滚动事件
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            //页面选中事件
//            @Override
//            public void onPageSelected(int position) {
//                //设置position对应的集合中的Fragment
//                mViewPager.setCurrentItem(position);
//                resetImgs();
//                selectTab(position);
//            }
//
//            @Override
//            //页面滚动状态改变事件
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
    }
//
//    private void initEvents(){
//        mTabMessage.setOnClickListener(this);
//        mTabFrd.setOnClickListener(this);
//        mTabMine.setOnClickListener(this);
//
//    }

    private void initViews(){
        tabLayout = (TabLayout) findViewById(R.id.tayLayout);
        viewPager = (ViewPager) findViewById(R.id.home_viewpager);
        //设置TabLayout的模式
        tabLayout.setTabMode(TabLayout.MODE_FIXED);

        //设置分割线
        LinearLayout linearLayout = (LinearLayout) tabLayout.getChildAt(0);
        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        linearLayout.setDividerDrawable(ContextCompat.getDrawable(this,
                R.drawable.divider)); //设置分割线的样式
        linearLayout.setDividerPadding(dip2px(10)); //设置分割线间隔

        viewPager.setAdapter(new TabAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);

        setTabView();
    }
    /**
     * 设置Tab的样式
     */
    private void setTabView() {
        holder = null;
        for (int i = 0; i < tabs.size(); i++) {
            //依次获取标签
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            //为每个标签设置布局
            tab.setCustomView(R.layout.home_tab_item);
            holder = new ViewHolder(tab.getCustomView());
            //为标签填充数据
            holder.tvTabName.setText(tabs.get(i));
            holder.tvTabNumber.setText(String.valueOf(tabNumbers.get(i)));
            //默认选择第一项
            if (i == 0){
                holder.tvTabName.setSelected(true);
                holder.tvTabNumber.setSelected(true);
                holder.tvTabName.setTextSize(18);
                holder.tvTabNumber.setTextSize(18);
            }
        }

        //tab选中的监听事件
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                holder = new ViewHolder(tab.getCustomView());
                holder.tvTabName.setSelected(true);
                holder.tvTabNumber.setSelected(true);
                //选中后字体变大
                holder.tvTabName.setTextSize(18);
                holder.tvTabNumber.setTextSize(18);
                //让Viewpager跟随TabLayout的标签切换
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                holder = new ViewHolder(tab.getCustomView());
                holder.tvTabName.setSelected(false);
                holder.tvTabNumber.setSelected(false);
                //恢复为默认字体大小
                holder.tvTabName.setTextSize(16);
                holder.tvTabNumber.setTextSize(16);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    class ViewHolder{
        TextView tvTabName;
        TextView tvTabNumber;

        public ViewHolder(View tabView) {
            tvTabName = (TextView) tabView.findViewById(R.id.tv_tab_name);
            tvTabNumber = (TextView) tabView.findViewById(R.id.tv_tab_number);
        }
    }

    class TabAdapter extends FragmentPagerAdapter{

        public TabAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        //显示标签上的文字
        @Override
        public CharSequence getPageTitle(int position) {
            return tabs.get(position);
        }

//        @Override
//        public CharSequence getPageTitle(int position) {
//            return tabs.get(position % tabs.size());
//        }
    }

    //像素单位转换
    public int dip2px(int dip) {
        float density = getResources().getDisplayMetrics().density;
        return (int) (dip * density + 0.5);
    }
}
