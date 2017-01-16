package me.twobirds.animationexer.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import me.twobirds.animationexer.R;

/**
 * Created by CTH on 2017/1/11.
 */

public class TweenAnimationActivity extends BaseActivity {


    @BindView(R.id.iv_translate)
    ImageView translateView;      //平移的控件
    @BindView(R.id.iv_rotate)
    ImageView rotateView;    //旋转的控件
    @BindView(R.id.iv_alpha)
    ImageView alphaView;  //透明的控件
    @BindView(R.id.iv_scale)
    ImageView scaleView;  //缩放的控件

    @BindView(R.id.tv_translate)
    TextView translateTextView;      //平移的控件
    @BindView(R.id.tv_rotate)
    TextView rotateTextView;    //旋转的控件
    @BindView(R.id.tv_alpha)
    TextView alphaTextView;  //透明的控件
    @BindView(R.id.tv_scale)
    TextView scaleTextView;  //缩放的控件

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initToolbar("补间动画+属性动画练习",true);

        initAnimMethod();

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_base_animation;
    }

    private void initAnimMethod() {
        Log.i("cth","initAnimMethod");

        //平移动画
        final Animation translateAnim = AnimationUtils.loadAnimation(TweenAnimationActivity.this, R.anim.anim_translate);
        translateAnim.setFillAfter(true);
        translateAnim.setInterpolator(TweenAnimationActivity.this, R.anim.interpalator_bounce);
        final Animation rotateReverseAnim = AnimationUtils.loadAnimation(TweenAnimationActivity.this, R.anim.anim_rotate_reverse);
        rotateReverseAnim.setFillAfter(true);

        translateTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                translateView.startAnimation(translateAnim);
            }
        });

        //旋转动画
        final Animation rotateAnim = AnimationUtils.loadAnimation(TweenAnimationActivity.this, R.anim.anim_rotate);
        rotateAnim.setFillAfter(true);
        rotateAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                rotateView.startAnimation(rotateReverseAnim);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        rotateTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rotateView.startAnimation(rotateAnim);
            }
        });

        //透明动画
        final ObjectAnimator alphaAnimation = ObjectAnimator.ofFloat(alphaView, "alpha", 1.0f, 0.5f, 0.8f, 0.0f, 1.0f);
        alphaAnimation.setDuration(4000);
        alphaTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alphaAnimation.start();
            }
        });

        //缩放动画
        ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(scaleView, "scaleX", 1.0f, 0.5f, 1.0f);
        ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(scaleView, "scaleY", 1.0f, 0.5f, 1.0f);
        scaleXAnimator.setInterpolator(new BounceInterpolator());
        scaleXAnimator.setDuration(1500);
        scaleYAnimator.setInterpolator(new BounceInterpolator());
        scaleYAnimator.setDuration(1500);

        ObjectAnimator translateXAnim = ObjectAnimator.ofFloat(scaleView, "translationX", 0f, 100f);
        ObjectAnimator translateYAnim = ObjectAnimator.ofFloat(scaleView, "translationY", 0f, 100f);
        translateXAnim.setDuration(1000);
        translateYAnim.setDuration(1000);

        final AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(translateXAnim, translateYAnim);
        animatorSet.playTogether(scaleXAnimator, scaleYAnimator);
        animatorSet.play(scaleXAnimator).after(translateXAnim);

        scaleTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animatorSet.start();
            }
        });

    }


}
