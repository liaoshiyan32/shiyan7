package com.example.broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.util.Log;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentFilter intentFilter=new IntentFilter(Intent.ACTION_BATTERY_CHANGED);//设置意图过滤器,监测电量的改变
        Intent batteryStatus=registerReceiver(null,intentFilter);//注册广播接收器
        int status=batteryStatus.getIntExtra(BatteryManager.EXTRA_STATUS,-1);//得到电池的当前状态
        boolean isCharging=status==BatteryManager.BATTERY_STATUS_CHARGING;//是否处于充电状态
        int chargePlug=batteryStatus.getIntExtra(BatteryManager.EXTRA_PLUGGED,-1);//获取充电方式
        boolean usbCharge=chargePlug==BatteryManager.BATTERY_PLUGGED_USB;//USB充电
        boolean acCharge=chargePlug==BatteryManager.BATTERY_PLUGGED_AC;//交流电充电
        int level=batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL,-1);//判断当前电池电量
        int scale=batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE,-1);
        float battery=level/(float)scale*100;

        if (isCharging){
            Log.d("MainActivity","正在充电");
        }
        if (usbCharge){
            Log.d("MainActivity","使用USB充电");
        }
        if (acCharge){
            Log.d("MainActivity","使用交流电充电");
        }
        Log.i("MainActivity","电量:"+battery);
        if (battery<=0.2){
            Log.d("MainActivity","电量较低");
        }else {
            Log.d("MainActivity","电量充足");
        }
    }
}


