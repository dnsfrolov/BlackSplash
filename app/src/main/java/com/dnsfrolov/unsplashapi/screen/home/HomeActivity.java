package com.dnsfrolov.unsplashapi.screen.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dnsfrolov.unsplashapi.R;
import com.dnsfrolov.unsplashapi.data.models.Photo;
import com.dnsfrolov.unsplashapi.screen.adapter.PhotoAdapter;
import com.dnsfrolov.unsplashapi.utils.EndlessRecyclerViewScrollListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dnsfrolov on 22.05.2017.
 */

public class HomeActivity extends AppCompatActivity implements HomeContract.HomeView, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.swipe_photo_list)
    SwipeRefreshLayout mRefreshLayout;

    @BindView(R.id.recycler_photo_list)
    RecyclerView mRecyclerView;

    private PhotoAdapter mAdapter;
    private HomeContract.HomePresenter mPresenter;
    private LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        setLayoutManager();
        setAdapter();

        mPresenter = new HomePresenterImpl(this);
        mPresenter.loadPhotos(1);

        mRefreshLayout.setOnRefreshListener(this);
        mRecyclerView.addOnScrollListener(new EndlessRecyclerViewScrollListener(mLayoutManager) {
            @Override
            public void onLoadMore(int currentPage, int totalItemCount) {
                mPresenter.loadPhotos(++currentPage);
            }
        });
    }

    public void setAdapter() {
        mAdapter = new PhotoAdapter();
        mRecyclerView.setAdapter(mAdapter);
    }

    public void setLayoutManager() {
        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        //mRecyclerView.setHasFixedSize(true);
    }

    @Override
    public void showPhotos(List<Photo> photoList) {
        mRefreshLayout.setRefreshing(false);
        mAdapter.setData(photoList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError(Throwable error) {

    }

    @Override
    public void onRefresh() {
        mAdapter.restoreData();
        mAdapter.notifyDataSetChanged();
        mPresenter.loadPhotos(1);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }
}
