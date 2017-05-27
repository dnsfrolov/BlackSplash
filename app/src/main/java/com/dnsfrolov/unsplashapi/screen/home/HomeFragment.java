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
import android.widget.ProgressBar;
import android.widget.Toast;

import com.dnsfrolov.unsplashapi.R;
import com.dnsfrolov.unsplashapi.data.models.Photo;
import com.dnsfrolov.unsplashapi.screen.adapter.PhotoAdapter;
import com.dnsfrolov.unsplashapi.screen.photo.PhotoInfoDialog;
import com.dnsfrolov.unsplashapi.utils.Constants;
import com.dnsfrolov.unsplashapi.utils.EndlessRecyclerViewScrollListener;
import com.dnsfrolov.unsplashapi.utils.OnItemClickListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dnsfrolov on 24.05.2017.
 */

public class HomeFragment extends Fragment implements HomeContract.HomeView,
        SwipeRefreshLayout.OnRefreshListener,
        OnItemClickListener.OnLikeClickListener<Photo>,
        OnItemClickListener.OnPhotoClickListener<Photo> {

    @BindView(R.id.swipe_photo_list)
    SwipeRefreshLayout mRefreshLayout;

    @BindView(R.id.recycler_photo_list)
    RecyclerView mRecyclerView;

    @BindView(R.id.progress_bar)
    ProgressBar mProgressBar;

    private PhotoAdapter mAdapter;
    private HomeContract.HomePresenter mPresenter;
    private LinearLayoutManager mLayoutManager;

    public static HomeFragment newInstance(String sortBy) {
        HomeFragment homeFragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(Constants.SORT_BY, sortBy);
        homeFragment.setArguments(args);
        return homeFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, root);

        setLayoutManager();
        setAdapter();

        mPresenter = new HomePresenterImpl(this);
        mPresenter.loadPhotos(Constants.FIRST_PAGE, getArguments().getString(Constants.SORT_BY));

        mRefreshLayout.setOnRefreshListener(this);
        mRecyclerView.addOnScrollListener(new EndlessRecyclerViewScrollListener(mLayoutManager) {
            @Override
            public void onLoadMore(int currentPage, int totalItemCount) {
                mPresenter.loadPhotos(++currentPage, getArguments().getString(Constants.SORT_BY));
            }
        });

        return root;
    }

    public void setAdapter() {
        mAdapter = new PhotoAdapter(this, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    public void setLayoutManager() {
        mLayoutManager = new LinearLayoutManager(getContext());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);
    }

    @Override
    public void showProgressIndicator() {
        mRefreshLayout.setVisibility(View.GONE);
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressIndicator() {
        mRefreshLayout.setVisibility(View.VISIBLE);
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showPhotos(List<Photo> photoList) {
        mRefreshLayout.setRefreshing(false);
        mAdapter.setData(photoList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError(Throwable error) {
        mRefreshLayout.setRefreshing(false);
        Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRefresh() {
        mAdapter.restoreData();
        mAdapter.notifyDataSetChanged();
        mPresenter.loadPhotos(Constants.FIRST_PAGE, getArguments().getString(Constants.SORT_BY));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    @Override
    public void onLikeClick(Photo item) {
        if (item.isLikedByUser()) {
            item.setLikedByUser(false);
            mPresenter.doDislike(item.getId());
        } else {
            item.setLikedByUser(true);
            mPresenter.doLike(item.getId());
        }
    }

    @Override
    public void onPhotoClick(Photo item) {
        if (item != null) {
            PhotoInfoDialog.newInstance(item.getId()).show(getFragmentManager(), null);
        }
    }
}
