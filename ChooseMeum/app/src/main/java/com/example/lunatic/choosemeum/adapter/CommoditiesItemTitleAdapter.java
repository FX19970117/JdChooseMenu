package com.example.lunatic.choosemeum.adapter;


import android.content.Context;
import android.support.v7.widget.ViewUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lunatic.choosemeum.R;
import com.example.lunatic.choosemeum.model.Commodity;

import java.util.ArrayList;


public class CommoditiesItemTitleAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private ArrayList<Commodity> list;
    private Context context;
    private Commodity type;

    public CommoditiesItemTitleAdapter(Context context, ArrayList<Commodity> list) {
        mInflater = LayoutInflater.from(context);
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        if (list != null && list.size() > 0)
            return list.size();
        else
            return 0;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final MyView view;
        if (convertView == null) {
            view = new MyView();
            convertView = mInflater.inflate(R.layout.totlal_commodoties_item, null);
            view.icon = (ImageView) convertView.findViewById(R.id.image_total_commodoties_item);
            view.name = (TextView) convertView.findViewById(R.id.tv_total_commodoties_name);
           // view.price= (TextView) convertView.findViewById(R.id.tv_total_commodoties_price);
            view.progressBar= (ProgressBar) convertView.findViewById(R.id.pb_total_commodities_rate);
            view.btn_buy= (Button) convertView.findViewById(R.id.Btn_total_commodities_buy);
            view.btn_buy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   // ViewUtils.showToast("ready to buy the commodity");

                }
            });
            convertView.setTag(view);
        } else {
            view = (MyView) convertView.getTag();
        }
        if (list != null && list.size() > 0) {
            type = list.get(position);
            view.name.setText(type.getTypename());
            if (type.getTypename().contains("电脑办公")) {
                view.icon.setBackgroundResource(R.drawable.testmac);
                view.name .setText("电脑");
                view.price.setText("100");
                view.progressBar.setProgress(50);


            } else if (type.getTypename().contains("个护化妆")) {
                view.icon.setBackgroundResource(R.drawable.testmac);
                view.name .setText("电脑");
                view.price.setText("100");
                view.progressBar.setProgress(50);
            } else if (type.getTypename().contains("鞋靴箱包")) {
                view.icon.setBackgroundResource(R.drawable.testmac);
                view.name .setText("电脑");
                view.price.setText("100");
                view.progressBar.setProgress(50);
            } else if (type.getTypename().contains("潮流女装")) {
                view.icon.setBackgroundResource(R.drawable.testmac);
                view.name .setText("电脑");
                view.progressBar.setProgress(50);
            } else if (type.getTypename().contains("图书")) {
                view.icon.setBackgroundResource(R.drawable.testmac);
                view.name .setText("电脑");
                view.price.setText("100");
                view.progressBar.setProgress(50);
            } else if (type.getTypename().contains("玩具乐器")) {
                view.icon.setBackgroundResource(R.drawable.testmac);
                view.name .setText("电脑");
                view.price.setText("100");
                view.progressBar.setProgress(50);
            } else if (type.getTypename().contains("音像制品")) {
                view.icon.setBackgroundResource(R.drawable.testmac);
                view.name .setText("电脑");
                view.price.setText("100");
                view.progressBar.setProgress(50);
            } else if (type.getTypename().contains("常用分类")) {
                view.icon.setBackgroundResource(R.drawable.testmac);
            } else if (type.getTypename().contains("品牌男装")) {
                view.icon.setBackgroundResource(R.drawable.testmac);
            } else if (type.getTypename().contains("内衣配饰")) {
                view.icon.setBackgroundResource(R.drawable.testmac);
            } else if (type.getTypename().contains("家用电器")) {
                view.icon.setBackgroundResource(R.drawable.testmac);
            } else if (type.getTypename().contains("手机数码")) {
                view.icon.setBackgroundResource(R.drawable.testmac);
            } else {
                view.icon.setBackgroundResource(R.drawable.testmac);
            }
        }

        return convertView;
    }


    private class MyView {
        private ImageView icon;
        private TextView name;
        private TextView price;
        private ProgressBar progressBar;
        private Button btn_buy;
    }


}
