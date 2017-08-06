package com.example.lunatic.choosemeum;

import android.app.Fragment;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.lunatic.choosemeum.fragment.CommoditiesItemTitleFragment;

public class MainActivity extends AppCompatActivity {
    private Button btn_jump;
    private Fragment viewer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    /**
     * Dispatch onResume() to fragments.  Note that for better inter-operation
     * with older versions of the platform, at the point of this call the
     * fragments attached to the activity are <em>not</em> resumed.  This means
     * that in some cases the previous state may still be saved, not allowing
     * fragment transactions that modify the state.  To correctly interact
     * with fragments in their proper state, you should instead override
     * {@link #onResumeFragments()}.
     */
//    @Override
//    protected void onResume() {
//        CommoditiesItemTitleFragment fragment2 = new CommoditiesItemTitleFragment();
//        FragmentManager fmanger = getSupportFragmentManager();
//        FragmentTransaction transaction = fmanger.beginTransaction();
//        transaction.replace(R.id.viewer, fragment2);
//        transaction.commit();
//        Intent i=new Intent();
//        i.setClass(MainActivity.this,CommoditiesItemTitleFragment.class);
//    }

    public  void initView() {
        android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
        CommoditiesItemTitleFragment fragment2 = new CommoditiesItemTitleFragment();
        android.support.v4.app.FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.right, fragment2);
        transaction.commit();



    }
}
