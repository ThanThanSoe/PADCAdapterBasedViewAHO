package com.padc.classwork.padc_adapterbasedview_aho.network;

import com.padc.classwork.padc_adapterbasedview_aho.network.responses.GetEventsResponse;
import com.padc.classwork.padc_adapterbasedview_aho.utils.EventsConstants;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface EventsApi {
    @FormUrlEncoded
    @POST(EventsConstants.GET_EVENTS)
    Call<GetEventsResponse> getAllEvents(@Field(EventsConstants.PARAM_ACCESS_TOKEN) String accessToken);
}
