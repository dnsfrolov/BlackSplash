package com.dnsfrolov.unsplashapi.screen.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.dnsfrolov.unsplashapi.R;
import com.dnsfrolov.unsplashapi.screen.photo.random.RandomPhotoDialog;
import com.dnsfrolov.unsplashapi.utils.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dnsfrolov on 22.05.2017.
 */

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }

        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fl_container, HomeFragment.newInstance(Constants.LATEST)).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();

        switch (item.getItemId()) {
            case R.id.action_random_photo:
                RandomPhotoDialog.newInstance().show(getSupportFragmentManager(), null);
                return true;
            case R.id.menu_item_latest:
                fragmentTransaction.replace(R.id.fl_container, HomeFragment.newInstance(Constants.LATEST)).commit();
                return true;
            case R.id.menu_item_oldest:
                fragmentTransaction.replace(R.id.fl_container, HomeFragment.newInstance(Constants.OLDEST)).commit();
                return true;

            case R.id.menu_item_popular:
                fragmentTransaction.replace(R.id.fl_container, HomeFragment.newInstance(Constants.POPULAR)).commit();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
