package com.padc.classwork.padc_adapterbasedview_aho.persistence;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.padc.classwork.padc_adapterbasedview_aho.data.vos.EventOrganizerVO;
import com.padc.classwork.padc_adapterbasedview_aho.data.vos.EventVO;
import com.padc.classwork.padc_adapterbasedview_aho.network.dataagents.EventsDataAgent;
import com.padc.classwork.padc_adapterbasedview_aho.persistence.daos.EventDao;
import com.padc.classwork.padc_adapterbasedview_aho.persistence.typeconverters.EventOrganizerTypeConverter;
import com.padc.classwork.padc_adapterbasedview_aho.persistence.typeconverters.EventRequirementTypeConverter;
import com.padc.classwork.padc_adapterbasedview_aho.persistence.typeconverters.UserTypeConverter;
import com.padc.classwork.padc_adapterbasedview_aho.utils.EventsConstants;

@Database(entities = {EventVO.class}, version = 4, exportSchema = false)
@TypeConverters({EventOrganizerTypeConverter.class, EventRequirementTypeConverter.class,UserTypeConverter.class})
public abstract class EventsDatabase extends RoomDatabase {
    public abstract EventDao eventDao();

    private static EventsDatabase objInstance;

    public static EventsDatabase getObjInstance(Context context){
        if(objInstance == null){
            objInstance = Room.databaseBuilder(context, EventsDatabase.class, EventsConstants.EVENT_DB)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return objInstance;
    }

    public boolean areEventsExistInDB(){
         return !eventDao().getAllEventsFromDB().isEmpty();
    }
}
