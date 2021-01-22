package com.zd.androidxdemo.room;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.zd.androidxdemo.R;
import com.zd.androidxdemo.databinding.ActivityRoomDemoBinding;

/**
 * @ClassName: RoomDemoActivity
 * @Description:
 * @Author: zhangdi
 * @Date: 20-12-29 下午4:12
 */
public class RoomDemoActivity extends AppCompatActivity {
    private static final String TAG = "@_@MainActivity";
    private ActivityRoomDemoBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_room_demo);
        initView();
    }

    private void initView() {
        RoomAdapter adapter = new RoomAdapter();
        mBinding.rvList.setAdapter(adapter);
        mBinding.setIsLoading(false);
    }
}
