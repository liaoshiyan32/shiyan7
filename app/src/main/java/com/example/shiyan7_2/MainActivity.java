package com.example.shiyan7_2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConnectivityManager cm=(ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);//获取当前的网络状态
        NetworkInfo info=cm.getActiveNetworkInfo();//获取网络状态
        boolean isConnected=info!=null&&info.isConnectedOrConnecting();
        if (isConnected){
            Log.d("MainActivity","网络已连接");
        }
        else {
            Log.d("MainActivity","网络已断开");
        }
        assert info != null;
        boolean isWiFi = info.getType() == ConnectivityManager.TYPE_WIFI;
        boolean isMobile=info.getType()==ConnectivityManager.TYPE_MOBILE;
        boolean isWiMax=info.getType()==ConnectivityManager.TYPE_WIMAX;
        if (isWiFi){
            Log.d("MainActivity","网络类型：wifi");
        }
        else if (isMobile){
            Log.d("MainActivity","已连接移动网络");
        }
        else if (isWiMax){
            Log.d("MainActivity","已连接WiMax");
        }
    }
}

