package com.padc.classwork.padc_adapterbasedview_aho.persistence.daos;

import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

public interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertEvents(List<UserDao> events);

    @Query("SELECT * FROM event")
    List<UserDao> getAllEventsFromDB();
}
