package com.dnsfrolov.unsplashapi.screen.photo;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatDialogFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.dnsfrolov.unsplashapi.R;
import com.dnsfrolov.unsplashapi.data.models.Photo;
import com.dnsfrolov.unsplashapi.utils.Constants;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dnsfrolov on 26.05.2017.
 */

public class PhotoInfoDialog extends MvpAppCompatDialogFragment implements PhotoInfoView {

    @BindView(R.id.avatar_view)
    CircleImageView mAvatarView;

    @BindView(R.id.tv_firstname_dialog)
    TextView mFirstname;

    @BindView(R.id.tv_lastname_dialog)
    TextView mLastname;

    @BindView(R.id.tv_login_dialog)
    TextView mLogin;

    @BindView(R.id.location_image)
    ImageView mLocationImage;

    @BindView(R.id.tv_location_dialog)
    TextView mLocation;

    @BindView(R.id.tv_photos_count_dialog)
    TextView mPhotosCount;

    @BindView(R.id.tv_collections_count_dialog)
    TextView mCollectionsCount;

    @BindView(R.id.progress_bar)
    ProgressBar mProgressBar;

    @BindView(R.id.ll_dialog)
    LinearLayout mBaseLayout;

    @InjectPresenter
    PhotoInfoPresenter mPresenter;

    public static PhotoInfoDialog newInstance(String id) {

        PhotoInfoDialog photoInfoDialog = new PhotoInfoDialog();
        Bundle args = new Bundle();

        args.putString(Constants.PHOTO_ID, id);
        photoInfoDialog.setArguments(args);

        return photoInfoDialog;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View root = LayoutInflater.from(getActivity()).inflate(R.layout.photo_info_dialog, null, false);
        ButterKnife.bind(this, root);

        mPresenter = new PhotoInfoPresenter();
        mPresenter.loadChosenPhoto(getArguments().getString(Constants.PHOTO_ID));

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
    public void showPhotoInfo(Photo photo) {

        Picasso.with(getContext())
                .load(photo.getUser().getProfileImage().getLarge())
                .into(mAvatarView);

        mFirstname.setText(String.format("%s %s", getContext().getString(R.string.by),
                photo.getUser().getFirstName()));

        if (photo.getUser().getLastName() != null) {
            mLastname.setVisibility(View.VISIBLE);
            mLastname.setText(photo.getUser().getLastName());
        } else {
            mLastname.setVisibility(View.GONE);
        }

        mLogin.setText(photo.getUser().getUsername());

        if (photo.getUser().getLocation() != null) {
            mLocationImage.setVisibility(View.VISIBLE);
            mLocation.setVisibility(View.VISIBLE);
            mLocation.setText(photo.getUser().getLocation());
        } else {
            mLocationImage.setVisibility(View.GONE);
            mLocation.setVisibility(View.GONE);
        }

        mPhotosCount.setText(String.format("%s: %s", getContext().getString(R.string.photos),
                photo.getUser().getTotalPhotos()));

        mCollectionsCount.setText(String.format("%s: %s", getContext().getString(R.string.collections),
                photo.getUser().getTotalCollections()));
    }

    @Override
    public void showError(Throwable error) {
        Toast.makeText(getContext(), error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        getDialog().cancel();
    }
}
