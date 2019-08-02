package com.example.myutils.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.myutils.BaseActivity;
import com.example.myutils.R;
import com.example.myutils.interfaces.BeforExitToDoListener;
import com.example.myutils.utils.ClickUtils;
import com.example.myutils.utils.ToastUtil;

public class ClickUtilsActivity extends BaseActivity {
    private TextView fastClick, doubleClickToExit, doubleClickToExittoDo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_click_utils);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        fastClick = findViewById(R.id.fast_click);
        doubleClickToExit = findViewById(R.id.double_click_to_exit);
        doubleClickToExittoDo = findViewById(R.id.double_click_to_exit_todo);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fast_click:
                ClickUtils.isFastDoubleClick(2000);
                break;
            case R.id.double_click_to_exit:
                ClickUtils.doubleClickToExit();
                break;
            case R.id.double_click_to_exit_todo:
                ClickUtils.doubleClickToExit(new BeforExitToDoListener() {
                    @Override
                    public void exit() {
                        ToastUtil.showToastForShort("退出应用");
                    }
                });
        }
    }

    @Override
    public void initOnClick() {
        fastClick.setOnClickListener(this);
        doubleClickToExit.setOnClickListener(this);
        doubleClickToExittoDo.setOnClickListener(this);
    }
}
