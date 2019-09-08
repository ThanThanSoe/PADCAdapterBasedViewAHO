package com.padc.classwork.padc_adapterbasedview_aho.data.models;

import android.content.Context;

import com.padc.classwork.padc_adapterbasedview_aho.network.dataagents.EventsDataAgent;
import com.padc.classwork.padc_adapterbasedview_aho.network.dataagents.HttpUrlEventsDataAgentImpl;
import com.padc.classwork.padc_adapterbasedview_aho.network.dataagents.RetoFitDataAgentImpl;
import com.padc.classwork.padc_adapterbasedview_aho.persistence.EventsDatabase;

public abstract class BaseModel {

    protected EventsDataAgent mDataAgent;
    protected EventsDatabase mDatabase;

    //mDataAgent = HttpUrlEventsDataAgentImpl.getObjInstance();
    //mDataAgent = OKHttpDataAgentImpl.getInstance();
    BaseModel(Context context){
        mDataAgent = RetoFitDataAgentImpl.getInstance();
        mDatabase = EventsDatabase.getObjInstance(context);
    }
}
