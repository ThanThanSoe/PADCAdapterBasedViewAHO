package com.padc.classwork.padc_adapterbasedview_aho.data.models;

import android.content.Context;

import com.padc.classwork.padc_adapterbasedview_aho.data.vos.EventVO;
import com.padc.classwork.padc_adapterbasedview_aho.network.dataagents.EventsDataAgent;
import com.padc.classwork.padc_adapterbasedview_aho.utils.EventsConstants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventModelImpl extends BaseModel implements EventModel{

    //list - allowed duplicate
    //set - difficult to search

    private static EventModelImpl objInstance;
    private Map<Integer, EventVO> eventsDataRepository;


    public EventModelImpl(Context context) {
        super(context);
        eventsDataRepository = new HashMap<>();
    }

    public static void initializeEventModel(Context context){
        objInstance = new EventModelImpl(context);
    }

    public static EventModelImpl getObjInstance(){
        if(objInstance == null){
            //objInstance = new EventModelImpl();
            throw new RuntimeException(EventsConstants.EM_EVENT_MODEL_NOT_INITIAL);
        }
        return objInstance;
    }

    //from network layer
    @Override
    public void getEvents(final GetEventsFromDataLayerDelegate delegate) {

        if(mDatabase.areEventsExistInDB()){
            List<EventVO> eventFromDB = mDatabase.eventDao().getAllEventsFromDB();
            delegate.onSuccess(eventFromDB);
        }else {
            mDataAgent.getEvents(EventsConstants.DUMMY_ACCESS_TOKEN, new EventsDataAgent.GetEventsFromNetworkDelegate(){

                @Override
                public void onSuccess(List<EventVO> events) {
                    long[] ids = mDatabase.eventDao().insertEvents(events);
                    delegate.onSuccess(events);
                }

                @Override
                public void onFailure(String errorMessage) {
                    delegate.onFailure(errorMessage);
                }
            });
        }
    }

    @Override
    public EventVO findEventById(int eventId) {
        EventVO event = eventsDataRepository.get(eventId);
        return event;
    }
}
