package com.always.work_hard_junior_yao.christ_project_nizamakil;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.ContentViewHolder> {
    private ArrayList<ContentItems> mContentList;

    public  static  class ContentViewHolder extends  RecyclerView.ViewHolder{
        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;

        public ContentViewHolder(@NonNull View itemView) {
            super(itemView);

            mImageView = itemView.findViewById(R.id.imageView);
            mTextView1 = itemView.findViewById(R.id.textView);
            mTextView2 = itemView.findViewById(R.id.textView1);
        }
    }

    public ContentAdapter(ArrayList<ContentItems>  ContentList){

        mContentList= ContentList;
    }

    @NonNull
    @Override
    public ContentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.content_items,viewGroup,false);
        ContentViewHolder junias = new ContentViewHolder(v);
        return junias;

    }

    @Override
    public void onBindViewHolder(@NonNull ContentViewHolder contentViewHolder, int i) {

        ContentItems currentItem = mContentList.get(i);
        contentViewHolder.mImageView.setImageResource(currentItem.getImageResources());
        contentViewHolder.mTextView1.setText(currentItem.getText1());
        contentViewHolder.mTextView2.setText(currentItem.getText2());


    }

    @Override
    public int getItemCount() {
        return mContentList.size();
    }
}
