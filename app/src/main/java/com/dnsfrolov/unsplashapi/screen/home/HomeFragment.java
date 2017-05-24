package com.dnsfrolov.unsplashapi.screen.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dnsfrolov.unsplashapi.R;
import com.dnsfrolov.unsplashapi.data.models.Photo;
import com.dnsfrolov.unsplashapi.screen.adapter.PhotoAdapter;
import com.dnsfrolov.unsplashapi.utils.EndlessRecyclerViewScrollListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dnsfrolov on 24.05.2017.
 */

public class HomeFragment extends Fragment implements HomeContract.HomeView, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.swipe_photo_list)
    SwipeRefreshLayout mRefreshLayout;

    @BindView(R.id.recycler_photo_list)
    RecyclerView mRecyclerView;

    private PhotoAdapter mAdapter;
    private HomeContract.HomePresenter mPresenter;
    private LinearLayoutManager mLayoutManager;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, root);

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

        return root;
    }

    public void setAdapter() {
        mAdapter = new PhotoAdapter();
        mRecyclerView.setAdapter(mAdapter);
    }

    public void setLayoutManager() {
        mLayoutManager = new LinearLayoutManager(getContext());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);
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
    public void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }
}
