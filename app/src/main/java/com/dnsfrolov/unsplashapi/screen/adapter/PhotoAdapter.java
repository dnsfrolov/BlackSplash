package com.dnsfrolov.unsplashapi.screen.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dnsfrolov.unsplashapi.R;
import com.dnsfrolov.unsplashapi.UnsplashApplication;
import com.dnsfrolov.unsplashapi.data.models.Photo;
import com.dnsfrolov.unsplashapi.utils.OnItemClickListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dnsfrolov on 22.05.2017.
 */

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoHolder> {

    private List<Photo> mList;
    private OnItemClickListener.OnLikeClickListener<Photo> mLikeListener;
    private OnItemClickListener.OnPhotoClickListener<Photo> mPhotoListener;

    public PhotoAdapter(OnItemClickListener.OnLikeClickListener<Photo> likeListener,
                        OnItemClickListener.OnPhotoClickListener<Photo> photoListener) {
        this.mList = new ArrayList<>();
        this.mLikeListener = likeListener;
        this.mPhotoListener = photoListener;
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
    public void onBindViewHolder(final PhotoHolder holder, final int position) {
        holder.initData(holder.getAdapterPosition());
        //Like image change when I click on it
        holder.mLikeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLikeListener.onLikeClick(mList.get(holder.getAdapterPosition()));
                notifyItemChanged(holder.getAdapterPosition());
                notifyItemChanged(holder.getAdapterPosition(), holder.mLikesCount);
            }
        });

        holder.mPhotoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPhotoListener.onPhotoClick(mList.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList != null ? mList.size() : 0;
    }

    class PhotoHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.photo_view)
        ImageView mPhotoView;

        @BindView(R.id.avatar_view)
        CircleImageView mAvatarView;

        @BindView(R.id.tv_firstname_photo_list)
        TextView mFirstname;

        @BindView(R.id.tv_lastname_photo_list)
        TextView mLastname;

        @BindView(R.id.like_view)
        ImageView mLikeView;

        @BindView(R.id.tv_likes_count)
        TextView mLikesCount;

        public PhotoHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void initData(int adapterPosition) {
            final Photo photo = mList.get(adapterPosition);

            Picasso.with(UnsplashApplication.getInstance())
                    .load(photo.getUrls().getSmall())
                    .into(mPhotoView);

            Picasso.with(UnsplashApplication.getInstance())
                    .load(photo.getUser().getProfileImage().getMedium())
                    .into(mAvatarView);

            mFirstname.setText(String.format("%s %s", UnsplashApplication.getInstance().getString(R.string.by),
                    photo.getUser().getFirstName()));

            if (photo.getUser().getLastName() != null) {
                mLastname.setVisibility(View.VISIBLE);
                mLastname.setText(photo.getUser().getLastName());
            } else {
                mLastname.setVisibility(View.GONE);
            }

            mLikesCount.setText(String.valueOf(photo.getLikes()));

            if (photo.isLikedByUser()) {
                mLikeView.setImageResource(R.drawable.heart);
            } else {
                mLikeView.setImageResource(R.drawable.heart_outline);
            }
        }
    }
}
