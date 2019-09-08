package com.padc.classwork.padc_adapterbasedview_aho;

import android.app.Application;

import com.padc.classwork.padc_adapterbasedview_aho.data.models.EventModelImpl;

public class EventsApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        EventModelImpl.initializeEventModel(getApplicationContext());
    }
}
