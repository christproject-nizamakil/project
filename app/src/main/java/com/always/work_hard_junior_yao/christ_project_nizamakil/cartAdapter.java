package com.always.work_hard_junior_yao.christ_project_nizamakil;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class cartAdapter extends RecyclerView.Adapter<cartAdapter.cartViewHolder> {
    private ArrayList<cart_items> mCartList;

    public static class cartViewHolder extends  RecyclerView.ViewHolder{

        public ImageView image;
        public TextView mTextView11;
        public TextView mTextView22;
        public TextView mTextView23;
        public Button button1;
        public Button button2;
        public int mvalues;



        public cartViewHolder(@NonNull final View itemView) {
            super(itemView);

            image=itemView.findViewById(R.id.imageView1);
            mTextView11=itemView.findViewById(R.id.textView2);
            mTextView22= itemView.findViewById(R.id.textView3);
            mTextView23= itemView.findViewById(R.id.carttextview);
            button1= itemView.findViewById(R.id.button);
            button2= itemView.findViewById(R.id.button1);
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String w = mTextView23.getText().toString().trim();
                    mvalues=Integer.parseInt(w);
                    mvalues++;
                    mTextView23.setText(Integer.toString(mvalues));
                   // button2.setVisibility(View.INVISIBLE);

                }
            });

            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    String w = mTextView23.getText().toString().trim();
                    mvalues=Integer.parseInt(w);
                    mvalues= mvalues-1;
                    mTextView23.setText(Integer.toString(mvalues));

                    if (mvalues==0)
                    {

                    }

                }
            });

        }
    }

    public cartAdapter(ArrayList<cart_items> CartList)
    {
        mCartList = CartList;
    }

    @NonNull
    @Override
    public cartViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cart_items,viewGroup,false);
        cartViewHolder junias1 = new cartViewHolder(v);
        return  junias1;
    }

    @Override
    public void onBindViewHolder(@NonNull cartViewHolder cartViewHolder, int i) {


        cart_items currentItem = mCartList.get(i);
        cartViewHolder.image.setImageResource(currentItem.getImageResources());
        cartViewHolder.mTextView11.setText(currentItem.getText1());
        cartViewHolder.mTextView22.setText(currentItem.getText2());

    }

    @Override
    public int getItemCount() { return mCartList.size(); }
}


