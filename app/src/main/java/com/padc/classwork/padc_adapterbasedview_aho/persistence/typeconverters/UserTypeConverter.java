package com.padc.classwork.padc_adapterbasedview_aho.persistence.typeconverters;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.padc.classwork.padc_adapterbasedview_aho.data.vos.UserVO;

public class UserTypeConverter {
    @TypeConverter
    public static String eventOrganizerToJson(UserVO user){
        return new Gson().toJson(user);
    }

    @TypeConverter
    public static UserVO jsonToEventOrganizser(String userJson){
        return new Gson().fromJson(userJson, UserVO.class);
    }
}
