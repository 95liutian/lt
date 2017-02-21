package com.lt.mail.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.lt.mail.R;
import com.lt.mail.entity.Tab;
import com.lt.mail.fragment.CartFragment;
import com.lt.mail.fragment.CategoryFragment;
import com.lt.mail.fragment.HomeFragment;
import com.lt.mail.fragment.HotFragment;
import com.lt.mail.fragment.MyFragment;
import com.lt.mail.view.FragmentTabHost;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private FragmentTabHost mTabhost;
    private LayoutInflater mInflater;
    private List<Tab> mTabs = new ArrayList<Tab>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initTab();
    }

    private void initTab() {
        Tab tab_home = new Tab(R.string.home,R.drawable.selector_icon_home,HomeFragment.class);
        Tab tab_hot = new Tab(R.string.hot ,R.drawable.selector_icon_hot,HotFragment.class);
        Tab tab_category = new Tab(R.string.category,R.drawable.selector_icon_my, CategoryFragment.class);
        Tab tab_cart = new Tab(R.string.cart,R.drawable.selector_icon_cart,CartFragment.class);
        Tab tab_mine = new Tab(R.string.my,R.drawable.selector_icon_my,MyFragment.class);
        mTabs.add(tab_home);
        mTabs.add(tab_hot);
        mTabs.add(tab_cart);
        mTabs.add(tab_category);
        mTabs.add(tab_mine);
//      系统的资源ID
        mTabhost = (FragmentTabHost)findViewById(android.R.id.tabhost);
        mInflater = LayoutInflater.from(this);

        //getSupportFragmentManager():使用这个扩张性好
        mTabhost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        for(Tab tab :mTabs) {
            TabHost.TabSpec tabSpec = mTabhost.newTabSpec(getString(tab.getTitle()));
            tabSpec.setIndicator(buildIndicator(tab));
            // addTab(TabSpec tabSpec, Class<?> clss, Bundle args)
            mTabhost.addTab(tabSpec, tab.getFragment(), null);

        }
        mTabhost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);
        mTabhost.setCurrentTab(0);
    }
    private View buildIndicator(Tab tab) {
        View view = mInflater.inflate(R.layout.tab_indcator,null);
        //设置视图
        ImageView img = (ImageView) view.findViewById(R.id.tab_inicator_icon_iv);
        TextView text = (TextView) view.findViewById(R.id.tab_inicator_title_tv);
        img.setBackgroundResource(tab.getIcon());
        text.setText(tab.getTitle());
        return view;
    }
}
