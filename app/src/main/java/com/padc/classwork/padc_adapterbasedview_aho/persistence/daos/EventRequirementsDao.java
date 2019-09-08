package com.padc.classwork.padc_adapterbasedview_aho.persistence.daos;

import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.padc.classwork.padc_adapterbasedview_aho.data.vos.EventRequirementsVO;

import java.util.List;

public interface EventRequirementsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertEvents(List<EventRequirementsVO> events);

    @Query("SELECT * FROM event")
    List<EventRequirementsVO> getAllEventsFromDB();
}
