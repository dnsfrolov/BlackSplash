package com.dnsfrolov.unsplashapi.screen.photo.random;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatDialogFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.dnsfrolov.unsplashapi.R;
import com.dnsfrolov.unsplashapi.data.models.Photo;
import com.dnsfrolov.unsplashapi.screen.photo.PhotoInfoDialog;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dnsfrolov on 28.05.2017.
 */

public class RandomPhotoDialog extends MvpAppCompatDialogFragment implements RandomPhotoView {

    @BindView(R.id.photo_view)
    ImageView mPhotoView;

    @BindView(R.id.avatar_view)
    CircleImageView mAvatarView;

    @BindView(R.id.tv_firstname_photo_dialog)
    TextView mFirstname;

    @BindView(R.id.tv_lastname_photo_dialog)
    TextView mLastname;

    @BindView(R.id.like_view)
    ImageView mLikeView;

    @BindView(R.id.tv_likes_count)
    TextView mLikesCount;

    @BindView(R.id.progress_bar)
    ProgressBar mProgressBar;

    @BindView(R.id.photo_card_widget)
    CardView mBaseLayout;

    @InjectPresenter
    RandomPhotoPresenter mPresenter;

    public static RandomPhotoDialog newInstance() {
        return new RandomPhotoDialog();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View root = LayoutInflater.from(getActivity()).inflate(R.layout.random_photo_dialog, null, false);
        ButterKnife.bind(this, root);

        mPresenter.loadRandomPhoto();

        return new AlertDialog.Builder(getActivity())
                .setView(root)
                .create();
    }

    @Override
    public void showProgressIndicator() {
        mBaseLayout.setVisibility(View.GONE);
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressIndicator() {
        mBaseLayout.setVisibility(View.VISIBLE);
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showRandomPhoto(final Photo photo) {
        Picasso.with(getContext())
                .load(photo.getUrls().getSmall())
                .into(mPhotoView);

        Picasso.with(getContext())
                .load(photo.getUser().getProfileImage().getMedium())
                .into(mAvatarView);

        mFirstname.setText(String.format("%s %s", getContext().getString(R.string.by),
                photo.getUser().getFirstName()));

        if (photo.getUser().getLastName() != null) {
            mLastname.setVisibility(View.VISIBLE);
            mLastname.setText(photo.getUser().getLastName());
        } else {
            mLastname.setVisibility(View.GONE);
        }

        mLikesCount.setText(String.valueOf(photo.getLikes()));

        mLikeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (photo.isLikedByUser()) {
                    mLikesCount.setText(String.valueOf(photo.getLikes()));
                    mLikeView.setImageResource(R.drawable.heart_outline);
                    photo.setLikedByUser(false);
                    mPresenter.doDislike(photo.getId());
                } else {
                    mLikesCount.setText(String.valueOf(photo.getLikes() + 1));
                    mLikeView.setImageResource(R.drawable.heart);
                    photo.setLikedByUser(true);
                    mPresenter.doLike(photo.getId());
                }
            }
        });

        mPhotoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhotoInfoDialog.newInstance(photo.getId()).show(getFragmentManager(), null);
            }
        });
    }

    @Override
    public void showError(Throwable error) {
        Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
        getDialog().cancel();
    }
}
