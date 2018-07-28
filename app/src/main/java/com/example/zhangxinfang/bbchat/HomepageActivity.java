package com.example.zhangxinfang.bbchat;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class HomepageActivity extends FragmentActivity implements View.OnClickListener {
//    //声明ViewPager
//    private ViewPager viewPager;
//    //声明TabLayout
//    private TabLayout tabLayout;
//    //适配器
//    private FragmentPagerAdapter mAdapter;
//    //装载Fragment的集合
//    private List<Fragment> mFragments;
//    private List<String> tabs = new ArrayList<>(); //标签名称
//    private List<Integer> tabNumbers = new ArrayList<>(); //信息数目
////    private List<Integer> tabNumbers = new ArrayList<>(); //信息数目
//    private ViewHolder holder;
//
//
//    @Override
//    protected void onCreate( Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        setContentView(R.layout.activity_homepage);
//
//        initView();//初始化控件
////        initEvents();//初始化事件
//        initData();//初始化数据
//
//    }
//
//    private void initData(){
//        mFragments = new ArrayList<>();
//        //将四个Fragment加入集合中
//        mFragments.add(new MessageFragment());
//        mFragments.add(new FrdFragment());
//        mFragments.add(new MineFragment());
//
//        tabs.add("新消息aaa" );
//        tabs.add("朋友圈");
//        tabs.add("公众号");
//        tabNumbers.add(999);
//        tabNumbers.add(99);
//        tabNumbers.add(9);
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
//        viewPager.setAdapter(mAdapter);
//        //设置ViewPager的切换监听
//        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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
//                viewPager.setCurrentItem(position);
//
//            }
//
//            @Override
//            //页面滚动状态改变事件
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
//    }
////
////    private void initEvents(){
////        mTabMessage.setOnClickListener(this);
////        mTabFrd.setOnClickListener(this);
////        mTabMine.setOnClickListener(this);
////
////    }
//
//    private void initView(){
//        tabLayout = (TabLayout) findViewById(R.id.tayLayout);
//        viewPager = (ViewPager) findViewById(R.id.viewPager);
//        //设置TabLayout的模式
//        tabLayout.setTabMode(TabLayout.MODE_FIXED);
//
//        //设置分割线
//        LinearLayout linearLayout = (LinearLayout) tabLayout.getChildAt(0);
//        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
//        linearLayout.setDividerDrawable(ContextCompat.getDrawable(this,
//                R.drawable.divider)); //设置分割线的样式
//        linearLayout.setDividerPadding(dip2px(10)); //设置分割线间隔
//
//        viewPager.setAdapter(new TabAdapter(getSupportFragmentManager()));
//        tabLayout.setupWithViewPager(viewPager);
//
//        setTabView();
//    }
//    /**
//     * 设置Tab的样式
//     */
//    private void setTabView() {
//        holder = null;
//        for (int i = 0; i < tabs.size(); i++) {
//            //依次获取标签
//            TabLayout.Tab tab = tabLayout.getTabAt(i);
//            //为每个标签设置布局
//            tab.setCustomView(R.layout.home_tab_item);
//            holder = new ViewHolder(tab.getCustomView());
//            //为标签填充数据
//            holder.tvTabName.setText(tabs.get(i));
//            holder.tvTabNumber.setText(String.valueOf(tabNumbers.get(i)));
//            //默认选择第一项
//            if (i == 0){
//                holder.tvTabName.setSelected(true);
//                holder.tvTabNumber.setSelected(true);
//                holder.tvTabName.setTextSize(18);
//                holder.tvTabNumber.setTextSize(18);
//            }
//        }
//
//        //tab选中的监听事件
//        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                holder = new ViewHolder(tab.getCustomView());
//                holder.tvTabName.setSelected(true);
//                holder.tvTabNumber.setSelected(true);
//                //选中后字体变大
//                holder.tvTabName.setTextSize(18);
//                holder.tvTabNumber.setTextSize(18);
//                //让Viewpager跟随TabLayout的标签切换
//                viewPager.setCurrentItem(tab.getPosition());
//
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//                holder = new ViewHolder(tab.getCustomView());
//                holder.tvTabName.setSelected(false);
//                holder.tvTabNumber.setSelected(false);
//                //恢复为默认字体大小
//                holder.tvTabName.setTextSize(16);
//                holder.tvTabNumber.setTextSize(16);
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
//    }
//
//    @Override
//    public void onClick(View v) {
//
//    }
//
//    class ViewHolder{
//        TextView tvTabName;
//        TextView tvTabNumber;
//
//        public ViewHolder(View tabView) {
//            tvTabName = (TextView) tabView.findViewById(R.id.tv_tab_name);
//            tvTabNumber = (TextView) tabView.findViewById(R.id.tv_tab_number);
//        }
//    }
//
//    class TabAdapter extends FragmentPagerAdapter{
//
//        public TabAdapter(FragmentManager fm) {
//            super(fm);
//        }
//
//        @Override
//        public Fragment getItem(int position) {
//            return mFragments.get(position);
//        }
//
//        @Override
//        public int getCount() {
//            return mFragments.size();
//
//        }
//
//        //显示标签上的文字
//        @Override
//        public CharSequence getPageTitle(int position) {
//            return tabs.get(position);
//        }
//
////        @Override
////        public CharSequence getPageTitle(int position) {
////            return tabs.get(position % tabs.size());
////        }
//    }
//
//    //像素单位转换
//    public int dip2px(int dip) {
//        float density = getResources().getDisplayMetrics().density;
//        return (int) (dip * density + 0.5);
//    }




    //声明ViewPager
    private ViewPager mViewPager;
    //    private RecyclerView mRecyclerView;//7.15
    //适配器
    private FragmentPagerAdapter mAdapter;
    //装载Fragment的集合
    private List<Fragment> mFragments;

    //四个Tab对应的布局
    private LinearLayout mTabMessage;
    private LinearLayout mTabFrd;
    private LinearLayout mTabMine;

   private TextView mTextMessage;
   private TextView mTextFrd;
   private TextView mTextMine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_homepage);

//        setContentView(R.layout.recycler_view);//7.15
        initViews();//初始化控件
        initEvents();//初始化事件
        initData();//初始化数据
    }

    private void initData() {
        mFragments = new ArrayList<>();
        //将四个Fragment加入集合中
        mFragments.add(new MineFragment());
        mFragments.add(new MineFragment());
        mFragments.add(new MineFragment());


        //初始化适配器
        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {//从集合中获取对应位置的Fragment
                return mFragments.get(position);
            }

            @Override
            public int getCount() {//获取集合中Fragment的总数
                return mFragments.size();
            }

        };



        //7.15recyclerview适配器
//        MyBaseAdapter_RecyclerView remAdapter = new MyBaseAdapter_RecyclerView(list);//7.15

        //不要忘记设置ViewPager的适配器
        mViewPager.setAdapter(mAdapter);
//        mRecyclerView.setAdapter();//7.15
        //设置ViewPager的切换监听
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            //页面滚动事件
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            //页面选中事件
            @Override
            public void onPageSelected(int position) {
                //设置position对应的集合中的Fragment
                mViewPager.setCurrentItem(position);
                resetText();
                selectTab(position);
            }

            @Override
            //页面滚动状态改变事件
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    //初始化控件
    private void initViews() {
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
//        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);//7.15
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        mTabMessage = (LinearLayout) findViewById(R.id.tab_message);
        mTabFrd = (LinearLayout) findViewById(R.id.tab_frd);
        mTabMine = (LinearLayout) findViewById(R.id.tab_mine);


        mTextMessage=(TextView)findViewById(R.id.text_message);
        mTextFrd=(TextView)findViewById(R.id.text_frd);
        mTextMine=(TextView)findViewById(R.id.text_mine);
    }
    private void initEvents() {
        //设置四个Tab的点击事件
        mTabMessage.setOnClickListener(this);
        mTabFrd.setOnClickListener(this);
        mTabMine.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        //先将四个ImageButton置为灰色
        resetText();

        //根据点击的Tab切换不同的页面及设置对应的ImageButton为绿色
        switch (v.getId()) {
            case R.id.tab_message:
                selectTab(0);
                break;
            case R.id.tab_frd:
                selectTab(1);
                break;
            case R.id.tab_mine:
                selectTab(2);
                break;

        }
    }

    private void selectTab(int i) {
        //根据点击的Tab设置对应的ImageButton为绿色
        switch (i) {
            case 0:
                mTextMessage.setTextColor(android.graphics.Color.parseColor("#e19172e2"));
                break;
            case 1:
                mTextFrd.setTextColor(android.graphics.Color.parseColor("#e19172e2"));
                break;
            case 2:
                mTextMine.setTextColor(android.graphics.Color.parseColor("#e19172e2"));
                break;

        }
        //设置当前点击的Tab所对应的页面
        mViewPager.setCurrentItem(i);
    }

    //将四个ImageButton设置为灰色
    private void resetText() {
        mTextMessage.setTextColor(android.graphics.Color.parseColor("#e1b8a5e9"));
        mTextFrd.setTextColor(android.graphics.Color.parseColor("#e1b8a5e9"));
        mTextMine.setTextColor(android.graphics.Color.parseColor("#e1b8a5e9"));

        }
}
