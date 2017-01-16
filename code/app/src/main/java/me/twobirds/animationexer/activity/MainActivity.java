package me.twobirds.animationexer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.OnClick;
import me.twobirds.animationexer.R;

public class MainActivity extends BaseActivity {


    @BindView(R.id.btn_tween_anim)
    Button baseAnimBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initToolbar("首页");
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }


    @OnClick({R.id.btn_tween_anim, R.id.btn_frame_anim})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_tween_anim:
                startActivity(new Intent(this, TweenAnimationActivity.class));
                break;
            case R.id.btn_frame_anim:
                startActivity(new Intent(this, FrameAnimActivity.class));
                break;
        }
    }
}
