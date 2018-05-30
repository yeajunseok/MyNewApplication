package com.example.yeajunseoked.mynewapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class CategoryFragment1 extends Fragment implements StoreAdapter.MyRecyclerViewClickListener {
    RecyclerView recyclerView;
    StoreAdapter storeAdapter;
    MenuActivity activity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (MenuActivity) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.categoryfragment1, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);

        //매니져
        //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        storeAdapter = new StoreAdapter(getActivity().getApplicationContext());

        storeAdapter.addItem(new StoreItem("1블렉홀PC", "4000만 혜택"));
        storeAdapter.addItem(new StoreItem("2폴더PC", "업계 최저"));
        storeAdapter.addItem(new StoreItem("3아이비스PC", "이유있는 1등"));
        storeAdapter.addItem(new StoreItem("4헌터PC", "성공으로 향한다."));
        storeAdapter.addItem(new StoreItem("5피에스타PC", "오픈부터 매매까지"));
        storeAdapter.addItem(new StoreItem("6옥스PC", "정직한 "));
        storeAdapter.addItem(new StoreItem("7하나점포PC", "나다라"));
        storeAdapter.addItem(new StoreItem("8인디고PC", "01099999999"));
        storeAdapter.addItem(new StoreItem("99PC", "01099999999"));
        storeAdapter.addItem(new StoreItem("10PC", "01099999999"));
        storeAdapter.addItem(new StoreItem("11PC", "01099999999"));
        storeAdapter.addItem(new StoreItem("22PC", "01099999999"));

        recyclerView.setAdapter(storeAdapter);

        /*storeAdapter.setOnItemClickListener(new StoreAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(StoreAdapter.ViewHolder holder, View view, int position) {
                StoreItem storeItem = storeAdapter.getItem(position);
                Toast.makeText(getActivity().getApplicationContext(), "아이템 선택됨 :"+storeItem.getTitle(), Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getActivity().getApplicationContext(), OostoreActivity.class); //프래그먼트는 intent사용하면 안된다고 함.
                *//*ArrayList<String> names = new ArrayList<String>();
                names.add("test");
                intent.putExtra("names", names);*//*

                startActivity(intent);
            }
        });*/

       storeAdapter.setOnClickListenertttttttt(this);
       return rootView;
    }

    @Override
    public void onItemClicked(int position) {
        Toast.makeText(activity, "" + position, Toast.LENGTH_SHORT).show();
        activity.AAA(0);
    }

    @Override
    public void onShareButtonClocked(int position) {
        Toast.makeText(activity, "share"+ position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLearnMoreButtonClicked(int position) {
        Toast.makeText(activity, "more"+ position, Toast.LENGTH_SHORT).show();
    }
}
