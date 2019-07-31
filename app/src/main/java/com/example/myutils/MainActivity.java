package com.example.myutils;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.myutils.activities.DisplayUtilsActivity;
import com.example.myutils.utils.DisplayUtil;

public class MainActivity extends BaseActivity {
    private TextView displayUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        initToolBar(getResources().getString(R.string.app_name));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.display_utils:
                startActivity(new Intent(MainActivity.this, DisplayUtilsActivity.class));
                break;
        }
    }

    @Override
    public void initView() {
        displayUtil = findViewById(R.id.display_utils);
    }

    @Override
    public void initDate() {

    }

    @Override
    public void initOnClick() {
        displayUtil.setOnClickListener(this);
    }
}
