package com.wuye;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.wuye.api.bean.UserBean;
import com.wuye.utils.SpUtils;
import com.wuye.weixiu.MyBaoXiuActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView name, phone, address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        address = findViewById(R.id.address);

        UserBean userInfo = SpUtils.getUserInfo(this);
        if (userInfo != null) {
            name.setText(userInfo.userName);
            phone.setText(userInfo.userPhone);
            address.setText(userInfo.address);
            Log.i("qcl0318", new Gson().toJson(userInfo));
            Log.i("qcl0318", new Gson().toJson(userInfo));
        }

        findViewById(R.id.baoxiu).setOnClickListener(this);
        findViewById(R.id.my_baoxiu).setOnClickListener(this);
        findViewById(R.id.ll_logout).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.ll_logout) {
            SpUtils.saveUserInfo(this, null);
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        } else if (id == R.id.baoxiu) {
            startActivity(new Intent(this, SubmitActivity.class));
        } else if (id == R.id.my_baoxiu) {
            startActivity(new Intent(this, MyBaoXiuActivity.class));
        }
    }
}
