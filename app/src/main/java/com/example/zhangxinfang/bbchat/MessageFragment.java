package com.example.zhangxinfang.bbchat;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MessageFragment extends Fragment {

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

        for(int i=0;i<15;i++) {
            viewData.add(new Item(R.drawable.delete,ResID[i],imageResID[i]));

        }

        //通过findViewById拿到RecyclerView实例
        mRecyclerView = (RecyclerView) view.findViewById(R.id.id_rv);
        //设置RecyclerView管理器
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        /*//初始化适配器
        mAdapter = new MyRecyclerViewAdapter(list);
        //设置添加或删除item时的动画，这里使用默认动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());*/
        //设置适配器
        mRecyclerView.setAdapter(new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
                VH vh = new VH(view);
                return vh;
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                VH vh = (VH) holder;
                final Item item = viewData.get(position);
        /*        holder.delete.setImageResource(item.getDelete());
                holder.mTextView.setText(item.getTextviewId());
                holder.mImageView.setImageResource(item.getImageId());*/
                vh.mTextView.setText(ResID[(++mCurrentIndex)%ResID.length]);
                vh.mImageView.setImageResource(imageResID[(++mCurrentIndex)%imageResID.length]);
            }

            @Override
            public int getItemCount() {
                return null == viewData ? 0 : viewData.size();
            }

            class VH extends RecyclerView.ViewHolder {
                public ImageView mImageView;
                public TextView mTextView;
                public ImageButton delete;

                public VH(final View itemView) {
                    super(itemView);
                    mImageView = (ImageView) itemView.findViewById(R.id.image_title);
                    mTextView = (TextView) itemView.findViewById(R.id.textview_list);
                    delete = (ImageButton) itemView.findViewById(R.id.button_delete);
                    delete.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            viewData.remove(getAdapterPosition());

                            notifyItemRemoved(getAdapterPosition());
                            notifyItemRangeChanged(getAdapterPosition(), viewData.size());
                        }
                    });
                    mTextView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            // startActivity(new Intent(getActivity(),Main2Activity.class));
                            Intent intent = new Intent(getActivity(), ChatActivity.class);
                            Log.i("people------------->", mTextView.getText().toString());
                            intent.putExtra("people", mTextView.getText().toString());
                            startActivity(intent);

                        }
                    });


                }
            }
        });


        return view;
    }

}
