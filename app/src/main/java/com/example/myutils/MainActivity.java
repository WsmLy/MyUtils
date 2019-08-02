package com.example.myutils;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.myutils.activities.ClickUtilsActivity;
import com.example.myutils.activities.DisplayUtilsActivity;
import com.example.myutils.utils.ClickUtils;
import com.example.myutils.utils.DisplayUtil;

public class MainActivity extends BaseActivity {
    private TextView displayUtil;//尺寸工具
    private TextView clickUtils;//点击工具

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        initToolBar(getResources().getString(R.string.app_name));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.display_utils://尺寸工具
                startActivity(new Intent(MainActivity.this, DisplayUtilsActivity.class));
                break;
            case R.id.click_utils://点击工具
                startActivity(new Intent(MainActivity.this, ClickUtilsActivity.class));
                break;
        }
    }

    @Override
    public void initView() {
        displayUtil = findViewById(R.id.display_utils);
        clickUtils = findViewById(R.id.click_utils);
    }

    @Override
    public void initDate() {

    }

    @Override
    public void initOnClick() {
        displayUtil.setOnClickListener(this);
        clickUtils.setOnClickListener(this);
    }
}
