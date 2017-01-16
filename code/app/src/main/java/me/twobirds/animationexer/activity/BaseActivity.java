package me.twobirds.animationexer.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.twobirds.animationexer.R;

/**
 * Created by DuoNuo on 2017/1/16.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected Unbinder unbinder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(this.getLayoutResId());

        unbinder = ButterKnife.bind(this);
    }

    protected abstract int getLayoutResId();

    protected void initToolbar(String title) {
        initToolbar(title, false);
    }

    protected void initToolbar(String title, boolean isAllowedBack) {

        Toolbar toolbar = (Toolbar) findViewById(R.id.tb_toolbar);
        TextView titleTextView = (TextView) findViewById(R.id.tv_title);

        if (toolbar != null) {
            toolbar.setTitle("");
            titleTextView.setText(title);
            if (isAllowedBack) {
                toolbar.setNavigationIcon(R.mipmap.ic_back);
            } else {
                toolbar.setNavigationIcon(null);
            }
            setSupportActionBar(toolbar);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    protected Context getContext() {
        return this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unbinder.unbind();
    }
}
