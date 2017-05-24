package com.dnsfrolov.unsplashapi.screen.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dnsfrolov.unsplashapi.R;
import com.dnsfrolov.unsplashapi.UnsplashApplication;
import com.dnsfrolov.unsplashapi.data.models.Photo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dnsfrolov on 22.05.2017.
 */

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoHolder> {

    private List<Photo> mList;

    public PhotoAdapter() {
        this.mList = new ArrayList<>();
    }

    public void setData(List<Photo> list) {
        if (mList == null) {
            mList = new ArrayList<>();
        }
        mList.addAll(list);
    }

    public void restoreData() {
        mList = null;
        mList = new ArrayList<>();
    }

    @Override
    public PhotoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.photos_item_list, parent, false);
        return new PhotoHolder(view);
    }

    @Override
    public void onBindViewHolder(PhotoHolder holder, int position) {
        holder.initData(holder.getAdapterPosition());
    }

    @Override
    public int getItemCount() {
        return mList != null ? mList.size() : 0;
    }

    class PhotoHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.photo_view)
        ImageView photoView;

        public PhotoHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void initData(int adapterPosition) {
            final Photo photo = mList.get(adapterPosition);
            Picasso.with(UnsplashApplication.getInstance())
                    .load(photo.getUrls().getSmall())
                    .into(photoView);
        }
    }
}
