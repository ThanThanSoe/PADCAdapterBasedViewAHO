package com.padc.classwork.padc_adapterbasedview_aho.persistence.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.padc.classwork.padc_adapterbasedview_aho.data.vos.EventVO;

import java.util.List;

@Dao
public interface EventDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertEvents(List<EventVO> events);

    @Query("SELECT * FROM event")
    List<EventVO> getAllEventsFromDB();
}

