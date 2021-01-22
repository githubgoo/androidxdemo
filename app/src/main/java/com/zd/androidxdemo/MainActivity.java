package com.zd.androidxdemo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.zd.androidxdemo.databinding.ActivityMainBinding;
import com.zd.androidxdemo.databinding.DemoListItemBinding;
import com.zd.androidxdemo.room.AppDatabase;
import com.zd.androidxdemo.room.RoomDemoActivity;
import com.zd.androidxdemo.room.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "@_@MainActivity";

    private final String[] demoNames = {"Room Demo"};
    private final Class[] classes = {RoomDemoActivity.class};

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initView();
    }

    private void initView() {
        mBinding.rvDemoList.setAdapter(new RecyclerView.Adapter<DemoViewHolder>() {
            @NonNull
            @Override
            public DemoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                DemoListItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.demo_list_item, parent, false);
                return new DemoViewHolder(binding);
            }

            @Override
            public void onBindViewHolder(@NonNull DemoViewHolder holder, int position) {
                holder.binding.tvName.setText(demoNames[position]);
                holder.binding.cvItem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //TODO
                        Toast.makeText(MainActivity.this, "on item click: " + position, Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, classes[position]));
                    }
                });
            }

            @Override
            public int getItemCount() {
                return demoNames.length;
            }
        });
    }

    private void testDb() {
        AppExecutors.getInstance().getDiskIO().execute(new Runnable() {
            @Override
            public void run() {
                List<User> users = AppDatabase.getInstance(getApplicationContext()).userDao().getAll();
                Log.e(TAG, "users size:" + users.size());
                for (User user : users) {
                    Log.e(TAG, "user: " + user);
                }
            }
        });


//        new Thread(new Runnable() {
//            @Override
//            public void run() {
////                AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "zd-room.db").build();
////
//////                for (int i = 0; i < 100; i++) {
//////                    User user = new User();
//////                    user.uid = i;
//////                    user.firstName = "fn_" + i;
//////                    user.lastName = "ln_" + i;
//////                    db.userDao().insertAll(user);
//////                }
//
//                List<User> users = AppDatabase.getInstance(getApplicationContext()).userDao().getAll();
//                Log.e(TAG, "users size:" + users.size());
//                for (User user : users) {
//                    Log.e(TAG, "user: " + user);
//                }
//            }
//        }).start();
    }

    static class DemoViewHolder extends RecyclerView.ViewHolder {
        final DemoListItemBinding binding;

        public DemoViewHolder(DemoListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}