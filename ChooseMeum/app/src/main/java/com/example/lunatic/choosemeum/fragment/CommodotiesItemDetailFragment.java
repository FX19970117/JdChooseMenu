package com.example.lunatic.choosemeum.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.lunatic.choosemeum.R;
import com.example.lunatic.choosemeum.adapter.CommoditiesItemTitleAdapter;
import com.example.lunatic.choosemeum.model.Commodity;

import java.util.ArrayList;

/**
 * Created by liufeng on 2017/8/3.
 */

public class CommodotiesItemDetailFragment  extends Fragment {
    private ArrayList<Commodity> list;
    private ImageView hint_img;
    private CommoditiesItemTitleAdapter adapter;
    private Commodity type;
    private ProgressBar progressBar;
    private String typename;
    private ListView listView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_commodity_detail, null);
        progressBar=(ProgressBar) view.findViewById(R.id.progressBar);
        hint_img=(ImageView) view.findViewById(R.id.hint_img);
      //  listView = (GridView) view.findViewById(R.id.listView);
        listView= (ListView) view.findViewById(R.id.listView);
        typename=getArguments().getString("typename");
       // ((TextView)view.findViewById(R.id.toptype)).setText(typename);
        GetTypeList();
        adapter=new CommoditiesItemTitleAdapter(getActivity(), list);
         listView.setAdapter(adapter);
         listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
              //  Intent intent =new Intent(getContext(), SingleCommoditiesActivity.class);
               // startActivity(intent);
                Toast.makeText(getContext(),"read to buy",Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }


    private void GetTypeList() {
        list=new ArrayList<Commodity>();
        for(int i=1;i<35;i++){
            type=new Commodity(i, typename+i, "");
            list.add(type);
        }
        progressBar.setVisibility(View.GONE);
    }
}

