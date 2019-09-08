package com.padc.classwork.padc_adapterbasedview_aho.network.responses;

import com.google.gson.annotations.SerializedName;
import com.padc.classwork.padc_adapterbasedview_aho.data.vos.EventVO;
import com.padc.classwork.padc_adapterbasedview_aho.utils.EventsConstants;

import java.util.List;

public class GetEventsResponse {

    @SerializedName("message")
    private String message;

    @SerializedName("code")
    private String code;

    @SerializedName("data")
    private List<EventVO> eventList;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return Integer.valueOf(code);
    }

    public Boolean isResponseOk(){
        return getCode() == EventsConstants.CODE_RESPONSE_OK && eventList != null;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<EventVO> getEventList() {
        return eventList;
    }

    public void setEventList(List<EventVO> eventList) {
        this.eventList = eventList;
    }
}
