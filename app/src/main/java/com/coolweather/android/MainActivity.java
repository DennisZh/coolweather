package com.coolweather.android;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.preference.PreferenceManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if (prefs.getString("weather", null) != null) {
            Intent intent = new Intent(this, WeatherActivity.class);
            startActivity(intent);
            finish();
        }

//        //添加申请权限
//        List<String> permissionList = new ArrayList<>();
//        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
//            permissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
//        }
//        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//            permissionList.add(Manifest.permission.CALL_PHONE);
//        }
//        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            permissionList.add(Manifest.permission.ACCESS_FINE_LOCATION);
//        }
//        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            permissionList.add(Manifest.permission.ACCESS_COARSE_LOCATION);
//        }
//        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED){
//            permissionList.add(Manifest.permission.READ_PHONE_STATE);
//        }
//
//        //申请权限
//        if (!permissionList.isEmpty()) {
//            String [] permissions = permissionList.toArray(new String[permissionList.size()]);
//            ActivityCompat.requestPermissions(MainActivity.this, permissions, 1);
//        }

    }



    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                } else {
                    Toast.makeText(this, "拒绝权限将无法使用本程序！", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }

}
