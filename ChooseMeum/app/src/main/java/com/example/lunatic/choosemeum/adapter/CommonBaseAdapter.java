package com.example.lunatic.choosemeum.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public abstract class CommonBaseAdapter<T> extends BaseAdapter {

    protected int layoutResId;
    protected LayoutInflater inflater;
    protected Context context;
    protected List<T> dataList = new ArrayList<T>();

    @Override
    public boolean areAllItemsEnabled() {
        return true;
    }

    @Override
    public boolean isEnabled(int position) {
        return true;
    }

    public CommonBaseAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context).cloneInContext(context);
    }

    public CommonBaseAdapter(Context context, List<T> dataList) {
        this.context = context;
        this.dataList = dataList;
        inflater = LayoutInflater.from(context).cloneInContext(context);
    }

    @Override
    public int getCount() {
        if (dataList == null) {
            return 0;
        }
        return dataList.size();
    }

    @Override
    public T getItem(int position) {
        if (position < 0 || position >= dataList.size()) {
            return null;
        }
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean isEmpty() {
        return dataList.isEmpty();
    }

    public void clear() {
        dataList = new ArrayList<T>();
        notifyDataSetChanged();
    }

    public void setDataList(List<T> list) {
        if (list != null) {
            dataList = list;
            notifyDataSetChanged();
        }
    }

    public void setDataList(T[] array) {
        if (array != null) {
            dataList.clear();
            for (T item : array) {
                dataList.add(item);
            }
            notifyDataSetChanged();
        }
    }

    public List<T> getDataList() {
        return dataList;
    }

    public final void refresh() {
        notifyDataSetChanged();
    }

    public void fixListViewHeight(ListView listView) {

        // 如果没有设置数据适配器，则ListView没有子项，返回。
        int totalHeight = 0;
        for (int index = 0, len = getCount(); index < len; index++) {
            View listViewItem = getView(index, null, listView);
            // 计算子项View 的宽高
            try {
                listViewItem.measure(0, 0);
            } catch (Exception e) {
            }
            // 计算所有子项的高度和
            totalHeight += listViewItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        // listView.getDividerHeight()获取子项间分隔符的高度
        // params.height设置ListView完全显示需要的高度
        params.height = totalHeight + (listView.getDividerHeight() * (getCount() - 1));
        listView.setLayoutParams(params);
    }

}
