package me.twobirds.animationexer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.OnClick;
import me.twobirds.animationexer.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.btn_base_anim)
    private Button baseAnimBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
..
    @OnClick(R.id.btn_base_anim)
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_base_anim:
                startActivity(new Intent(this, BaseAnimationActivity.class));
                break;
        }
    }
}
