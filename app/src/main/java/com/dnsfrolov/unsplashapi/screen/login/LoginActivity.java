package com.dnsfrolov.unsplashapi.screen.login;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.dnsfrolov.unsplashapi.R;
import com.dnsfrolov.unsplashapi.screen.home.HomeActivity;
import com.dnsfrolov.unsplashapi.utils.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements LoginView {

    @BindView(R.id.web_view)
    WebView mWebView;

    @BindView(R.id.progress_bar)
    ProgressBar mProgressBar;

    LoginPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        mPresenter = new LoginPresenter();
    }

    @Override
    public void showProgressIndicator() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressIndicator() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void loginSuccess() {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);

    }

    @Override
    public void showError() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        mWebView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Uri uri = Uri.parse(url);
                String code = uri.getLastPathSegment();
                mPresenter.signIn(code);
                return false;
            }
        });

        mWebView.loadUrl(Constants.LOAD_AUTH_URL);
    }
}
