package com.always.work_hard_junior_yao.christ_project_nizamakil;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class fragment_amir_cart extends Fragment {
    private RecyclerView recyclerView;

    private RecyclerView.Adapter adapter1;
    private RecyclerView.LayoutManager layoutManager1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.amir_fragment_card,container,false);




        ArrayList<cart_items> CartList = new ArrayList<>();

        CartList.add(new cart_items(R.drawable.im2,"Block four","Bryanni","1",1,2));
        CartList.add(new cart_items(R.drawable.imag4,"Block four","Bryanni","1",1,1));
        CartList.add(new cart_items(R.drawable.im1,"Block four","Bryanni","1",1,2));
        CartList.add(new cart_items(R.drawable.im2,"Block four","Bryanni","1",1,2));
        CartList.add(new cart_items(R.drawable.imag4,"Block four","Bryanni","1",1,1));
        CartList.add(new cart_items(R.drawable.im1,"Block four","Bryanni","1",1,2));
        CartList.add(new cart_items(R.drawable.im2,"Block four","Bryanni","1",1,2));
        CartList.add(new cart_items(R.drawable.imag4,"Block four","Bryanni","1",1,1));



        RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.recyclecart);
        recyclerView.setHasFixedSize(true);
        layoutManager1= new LinearLayoutManager(getActivity());
        adapter1= new cartAdapter(CartList);




        recyclerView.setLayoutManager(layoutManager1);
        recyclerView.setAdapter(adapter1);



        return root;
    }
}
