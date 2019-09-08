package com.padc.classwork.padc_adapterbasedview_aho.network.dataagents;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.padc.classwork.padc_adapterbasedview_aho.network.responses.GetEventsResponse;
import com.padc.classwork.padc_adapterbasedview_aho.utils.EventsConstants;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpDataAgentImpl implements EventsDataAgent {

    private OkHttpClient mHttpClient;

    private static OkHttpDataAgentImpl objectInstance;

    private OkHttpDataAgentImpl(){
        mHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

    }

    public static OkHttpDataAgentImpl getInstance(){
        if(objectInstance == null){
            objectInstance = new OkHttpDataAgentImpl();
        }
        return objectInstance;
    }
    @Override
    public void getEvents(String accessToken, GetEventsFromNetworkDelegate delegate) {
        new GetEventsTask(mHttpClient,accessToken, delegate).execute();
    }

    public static class GetEventsTask extends AsyncTask<Void, Void, GetEventsResponse>{

        private OkHttpClient mOkHttpClient;

        private String accessToken;

        private GetEventsFromNetworkDelegate mDelegate;

        public GetEventsTask(OkHttpClient okHttpClient, String accessToken, GetEventsFromNetworkDelegate eventsFromNetworkDelegate) {
            this.mOkHttpClient = okHttpClient;
            this.accessToken = accessToken;
            this.mDelegate = eventsFromNetworkDelegate;
        }

        @Override
        protected GetEventsResponse doInBackground(Void... voids) {
            RequestBody fromBody = new FormBody.Builder()
                    .add(EventsConstants.PARAM_ACCESS_TOKEN, accessToken)
                    .build();
            Request request = new Request.Builder()
                    .url(EventsConstants.BASE_URL+EventsConstants.GET_EVENTS)
                    .post(fromBody)
                    .build();
            try{
                Response response = mOkHttpClient.newCall(request).execute();
                if(response.isSuccessful()){
                    String responseString = response.body().string();

                    GetEventsResponse getEventsResponse = new Gson().fromJson(responseString, GetEventsResponse.class);
                    return getEventsResponse;
                }
            }catch (Exception e){

            }

            return null;
        }

        @Override
        protected void onPostExecute(GetEventsResponse getEventsResponse) {
            super.onPostExecute(getEventsResponse);
            if(getEventsResponse != null)
            {
                //The process is success if the code is 200 and data is not null
                if(getEventsResponse.isResponseOk()) {

                    mDelegate.onSuccess(getEventsResponse.getEventList());

                } else {

                    mDelegate.onFailure(getEventsResponse.getMessage());
                }


            }else{
                mDelegate.onFailure(EventsConstants.FAIL_MESSAGE);
            }
        }
    }
}
