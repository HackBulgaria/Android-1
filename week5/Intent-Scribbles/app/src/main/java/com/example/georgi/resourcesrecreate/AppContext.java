package com.example.georgi.resourcesrecreate;

import android.app.Application;

/**
 * Created by georgi on 11/22/14.
 */
public class AppContext extends Application{
    private Object bluetoothGlobalListener;

    @Override
    public Object getSystemService(String name) {
        if (name.equals("BluetoothGlobalListtener")){
            if (bluetoothGlobalListener == null){
                bluetoothGlobalListener = new Object();
            }
            return bluetoothGlobalListener;
        }
        return super.getSystemService(name);
    }
}
