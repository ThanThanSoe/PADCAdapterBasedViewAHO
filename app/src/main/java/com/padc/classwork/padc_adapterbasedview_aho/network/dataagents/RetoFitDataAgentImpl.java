package com.padc.classwork.padc_adapterbasedview_aho.network.dataagents;

import com.padc.classwork.padc_adapterbasedview_aho.network.EventsApi;
import com.padc.classwork.padc_adapterbasedview_aho.network.responses.GetEventsResponse;
import com.padc.classwork.padc_adapterbasedview_aho.utils.EventsConstants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetoFitDataAgentImpl implements EventsDataAgent {

    private static RetoFitDataAgentImpl objectInstance;

    private EventsApi mEventsApi;

    private RetoFitDataAgentImpl(){

        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(EventsConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        mEventsApi = retrofit.create(EventsApi.class);
    }

    public static RetoFitDataAgentImpl getInstance(){
        if(objectInstance == null){
            objectInstance = new RetoFitDataAgentImpl();
        }
        return objectInstance;
    }


    @Override
    public void getEvents(String accessToken, final GetEventsFromNetworkDelegate delegate) {
        Call<GetEventsResponse> eventsCall = mEventsApi.getAllEvents(accessToken);
        eventsCall.enqueue(new Callback<GetEventsResponse>() {
            @Override
            public void onResponse(Call<GetEventsResponse> call, Response<GetEventsResponse> response) {
                GetEventsResponse getEventsResponse = response.body();
                delegate.onSuccess(getEventsResponse.getEventList());
            }

            @Override
            public void onFailure(Call<GetEventsResponse> call, Throwable t) {
                delegate.onFailure(t.getLocalizedMessage());
            }
        });
    }
}
