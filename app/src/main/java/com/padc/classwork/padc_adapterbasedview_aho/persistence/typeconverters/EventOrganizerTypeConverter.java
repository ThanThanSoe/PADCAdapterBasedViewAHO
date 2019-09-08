package com.padc.classwork.padc_adapterbasedview_aho.persistence.typeconverters;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.padc.classwork.padc_adapterbasedview_aho.data.vos.EventOrganizerVO;

public class EventOrganizerTypeConverter {
    @TypeConverter
    public static String eventOrganizerToJson(EventOrganizerVO eventOrganizer){
        return new Gson().toJson(eventOrganizer);
    }

    @TypeConverter
    public static EventOrganizerVO jsonToEventOrganizser(String eventOrganizerJson){
        return new Gson().fromJson(eventOrganizerJson, EventOrganizerVO.class);
    }
}
