package com.example.admin.week_test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ScrollView;

import com.example.admin.week_test.presenter.Show_Presenter;
import com.example.admin.week_test.view.Iview;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Iview {
    private MyTitle main_title;
    private PullToRefreshScrollView scrollView;
    private RecyclerView recyclerView;
    private Show_Presenter presenter;
    private List<GoodBean.DataBean> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initListener();
        initOperation();
    }

    private void initOperation() {
        presenter = new Show_Presenter(this);
        presenter.getDatas();
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        ILoadingLayout proxy = scrollView.getLoadingLayoutProxy(true, false);
        proxy.setPullLabel("正在下拉刷新");
        proxy.setRefreshingLabel("正在玩命加载");
        proxy.setReleaseLabel("放开以便刷新");
        ILoadingLayout layoutProxy = scrollView.getLoadingLayoutProxy(false, true);
        layoutProxy.setPullLabel("正在上拉加载更多");
        layoutProxy.setRefreshingLabel("正在玩命加载");
        layoutProxy.setReleaseLabel("放开以便刷新");
        scrollView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ScrollView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                presenter.getDatas();
                scrollView.onRefreshComplete();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                presenter.getDatas();
                scrollView.onRefreshComplete();
            }
        });
    }

    private void initListener() {
        main_title.setCallback(new MyTitle.ViewCallback() {
            @Override
            public void onSearch(String context) {
                Intent intent = new Intent(MainActivity.this, ShowActivity.class);
                intent.putExtra("text",context);
                startActivity(intent);
            }

            @Override
            public void onSearchView(String json) {
                finish();
            }
        });
    }

    private void initViews() {
        main_title = findViewById(R.id.main_title);
        scrollView = findViewById(R.id.scrollview);
        recyclerView = findViewById(R.id.recyclerview);
    }

    @Override
    public void view_onSuccess(GoodBean goodBean) {
        data = goodBean.getData();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                MyAdapter myAdapter = new MyAdapter(MainActivity.this, data);
                recyclerView.setAdapter(myAdapter);
                scrollView.onRefreshComplete();
            }
        });
    }

    @Override
    public void view_onFail(int code) {

    }
}
