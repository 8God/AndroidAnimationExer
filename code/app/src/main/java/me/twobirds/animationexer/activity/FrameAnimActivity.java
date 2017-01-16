package me.twobirds.animationexer.activity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import butterknife.BindView;
import me.twobirds.animationexer.R;

/**
 * Created by CTH on 2017/1/16.
 */

public class FrameAnimActivity extends BaseActivity {

    @BindView(R.id.iv_frame_anim)
    ImageView frameAnimImageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initToolbar("帧动画", true);

        AnimationDrawable animationDrawable = (AnimationDrawable) frameAnimImageView.getDrawable();
//        animationDrawable.stop();

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_frame_anim;
    }
}
