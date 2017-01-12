package me.twobirds.animationexer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;
import me.twobirds.animationexer.R;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("cth","before ButterKnife.bind");
        ButterKnife.bind(this);
        Log.i("cth","after ButterKnife.bind");


    }


    @OnClick(R.id.btn_base_anim)
    public void onClick(View view) {
        Log.i("cth", "onClick");
        Toast.makeText(this, "onClick", Toast.LENGTH_SHORT).show();
        switch (view.getId()) {
            case R.id.btn_base_anim:
                startActivity(new Intent(this, BaseAnimationActivity.class));
                break;
        }
    }
}
