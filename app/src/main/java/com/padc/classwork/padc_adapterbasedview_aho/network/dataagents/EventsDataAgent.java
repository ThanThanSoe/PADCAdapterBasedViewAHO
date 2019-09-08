package com.padc.classwork.padc_adapterbasedview_aho.network.dataagents;

import com.padc.classwork.padc_adapterbasedview_aho.data.vos.EventVO;

import java.util.List;

public interface EventsDataAgent {

    void getEvents(String accessToken , GetEventsFromNetworkDelegate delegate);

    //delegation for connect network <-> data | impl in data layer
    interface GetEventsFromNetworkDelegate {
        void onSuccess(List<EventVO> events);
        void onFailure(String errorMessage);
    }
}
