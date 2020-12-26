package com.zd.androidxdemo;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.zd.androidxdemo.room.AppDatabase;
import com.zd.androidxdemo.room.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "zzzddd";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testDb();
    }

    private void testDb() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "zd-room.db").build();

//                for (int i = 0; i < 100; i++) {
//                    User user = new User();
//                    user.uid = i;
//                    user.firstName = "fn_" + i;
//                    user.lastName = "ln_" + i;
//                    db.userDao().insertAll(user);
//                }

                List<User> users = db.userDao().getAll();
                for (User user : users) {
                    Log.e(TAG, "user: " + user);
                }
            }
        }).start();
    }
}