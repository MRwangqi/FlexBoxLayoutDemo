package com.flexboxlayout.service;

import android.app.Service;
import android.content.Intent;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import aidl.wangqi.IPeople;

/**
 * Created by Administrator on 2017/3/23.
 */

public class MyService extends Service {
    IBinder iBinder;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        iBinder = new IBinder();
        return iBinder;
    }


    class IBinder extends IPeople.Stub {

        @Override
        public String getName() throws RemoteException {
            return "张三";
        }

        @Override
        public int age() throws RemoteException {
            return 14;
        }
    }
}
