package com.zwc.clockinassistant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextSwitcher;
import android.widget.TextView;

import java.util.Arrays;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
    }

    @Override
    protected void onStart() {
        super.onStart();

        // 读取
        String text = "";
        for (String line : Global.wifiNames) {
            text += line + "\n";
        }

        TextView wifiTextView = findViewById(R.id.wifiText);
        wifiTextView.setText(text);

        TextView editTextTextCheckoutTime = findViewById(R.id.editTextTextCheckoutTime);
        editTextTextCheckoutTime.setText(Global.getCheckoutTimeAsString());
    }

    public void save(View view) {

        // 保存
        TextView wifiTextView = findViewById(R.id.wifiText);
        String text = wifiTextView.getText().toString();
        Global.wifiNames = Arrays.asList(text.trim().split("\n"));
        TextView editTextTextCheckoutTime = findViewById(R.id.editTextTextCheckoutTime);
        Global.setCheckoutTimeFromString(editTextTextCheckoutTime.getText().toString().trim(), this);
        Global.changed = true;

        // 回到主页面
        finish();
    }
}
