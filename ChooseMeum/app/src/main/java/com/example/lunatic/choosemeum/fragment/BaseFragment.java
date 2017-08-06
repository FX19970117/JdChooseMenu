package com.example.lunatic.choosemeum.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


public abstract class BaseFragment extends Fragment {

   // protected LogUtil log = new LogUtil(getClass());
    private String mTag = null;
    private Dialog mDialog;
    private TextView tvContent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(getContentView(), container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initListener();
        initData();
    }

    @LayoutRes
    protected abstract int getContentView();

    protected abstract void initView(View view);

    protected abstract void initListener();

    protected abstract void initData();


    protected void onClickTitleLeft(View v) {
    }

    protected void onClickTitleRight(View v) {
    }

    protected String getRequestTag() {
        if (mTag == null) {
            mTag = getClass().getName() + "-" + getClass().hashCode();
        }
        return mTag;
    }

    protected void showToast(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }



    protected void cancelLoading() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mDialog != null && mDialog.isShowing()) {
                    mDialog.dismiss();
                }
            }
        });
    }


}