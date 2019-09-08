package com.padc.classwork.padc_adapterbasedview_aho.persistence.typeconverters;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.padc.classwork.padc_adapterbasedview_aho.data.vos.EventRequirementsVO;

public class EventRequirementTypeConverter {

    @TypeConverter
    public static String eventOrganizerToJson(EventRequirementsVO eventRequirement){
        return new Gson().toJson(eventRequirement);
    }

    @TypeConverter
    public static EventRequirementsVO jsonToEventOrganizser(String eventRequirementJson){
        return new Gson().fromJson(eventRequirementJson, EventRequirementsVO.class);
    }
}
