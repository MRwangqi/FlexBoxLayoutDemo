package com.client;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import aidl.wangqi.IPeople;

public class MainActivity extends AppCompatActivity {
    private IPeople people;//协议接口

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //点击进行传送
    public void get() {
        Intent intent = new Intent();
        intent.setAction("com.flexboxlayout.service.MyService");
        intent.setPackage("com.flexboxlayout");
        bindService(intent, conn, Service.BIND_AUTO_CREATE);
    }


    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            people = IPeople.Stub.asInterface(iBinder);

            try {
                Log.i("tag", people.getName() + people.age());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            people = null;
        }
    };
}
