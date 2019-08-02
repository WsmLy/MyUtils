package com.example.myutils.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.myutils.BaseActivity;
import com.example.myutils.R;
import com.example.myutils.utils.DisplayUtil;
import com.example.myutils.utils.ToastUtil;

public class DisplayUtilsActivity extends BaseActivity {
    private TextView spValue, dpValue, pxValue;
    private TextView transform;
    private TextView screenValue, statusBarValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_display_utils);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.transform:
                if (getCurrentFocus()==spValue && !"".equals(spValue.getText().toString())) {
                    pxValue.setText(String.valueOf(DisplayUtil.sp2px(Integer.parseInt(spValue.getText().toString()))));
                    dpValue.setText(String.valueOf(DisplayUtil.sp2dp(Integer.parseInt(spValue.getText().toString()))));
                } else if (getCurrentFocus() == dpValue && !"".equals(dpValue.getText().toString())) {
                    spValue.setText(String.valueOf(DisplayUtil.dp2sp(Integer.parseInt(dpValue.getText().toString()))));
                    pxValue.setText(String.valueOf(DisplayUtil.dp2px(Integer.parseInt(dpValue.getText().toString()))));
                } else if (getCurrentFocus() == pxValue && !"".equals(pxValue.getText().toString())) {
                    dpValue.setText(String.valueOf(DisplayUtil.px2dp(Integer.parseInt(pxValue.getText().toString()))));
                    spValue.setText(String.valueOf(DisplayUtil.px2sp(Integer.parseInt(pxValue.getText().toString()))));
                } else {
                    ToastUtil.showToastForShort("请输入sp值或dp值或px值");
                }
                break;
        }
    }

    @Override
    public void initDate() {
        screenValue.setText(new StringBuilder().append("宽度：").append(DisplayUtil.getScreenSize().getWidth()).append("px  高度：").append(DisplayUtil.getScreenSize().getHeight()).append("px"));
        statusBarValue.setText(new StringBuilder().append(DisplayUtil.getStatusBarHeight()).append("px"));
    }

    @Override
    public void initView() {
        spValue = findViewById(R.id.sp_value);
        dpValue = findViewById(R.id.dp_value);
        pxValue = findViewById(R.id.px_value);

        transform = findViewById(R.id.transform);

        screenValue = findViewById(R.id.screen_value);
        statusBarValue = findViewById(R.id.statusbar_value);
    }

    @Override
    public void initOnClick() {
        transform.setOnClickListener(this);
    }
}
