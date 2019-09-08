package com.padc.classwork.padc_adapterbasedview_aho.network.dataagents;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.padc.classwork.padc_adapterbasedview_aho.network.responses.GetEventsResponse;
import com.padc.classwork.padc_adapterbasedview_aho.utils.EventsConstants;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;

public class HttpUrlEventsDataAgentImpl implements EventsDataAgent{

    private static HttpUrlEventsDataAgentImpl objInstance;



    GetEventsFromNetworkDelegate eventsResponseDelegate;




    private HttpUrlEventsDataAgentImpl(){ }

    public static HttpUrlEventsDataAgentImpl getObjInstance(){
        if(objInstance == null){
            objInstance = new HttpUrlEventsDataAgentImpl();
        }
        return objInstance;
    }

    @Override
    public void getEvents(String accessToken , GetEventsFromNetworkDelegate delegate) {
        new GetEventsTask(accessToken , delegate).execute();
    }

    public class GetEventsTask extends AsyncTask<Void,Void, GetEventsResponse>{

        private String accessToken;

        private GetEventsFromNetworkDelegate eventsResponseDelegate;


        public GetEventsTask(String accessToken , GetEventsFromNetworkDelegate eventsResponseDelegate) {
            this.accessToken = accessToken;
            this.eventsResponseDelegate = eventsResponseDelegate;
        }

        @Override
        protected GetEventsResponse doInBackground(Void... voids) {

            URL url;
            BufferedReader reader = null;
            StringBuffer stringBuffer;

            try {

                url = new URL(EventsConstants.BASE_URL+EventsConstants.GET_EVENTS);

                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.setReadTimeout(15 * 1000);
                connection.setDoInput(true);
                connection.setDoOutput(true);

                //put the request parameters into NameValuePair list.
                List<NameValuePair> params = new ArrayList<>();
                params.add(new BasicNameValuePair(EventsConstants.PARAM_ACCESS_TOKEN, accessToken));

                //write the parameters from NameValuePair list into connections obj.
                OutputStream outputStream = connection.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                writer.write(getQuery(params));
                writer.flush();
                writer.close();
                outputStream.close();

                connection.connect();

                //read the output from the server
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                stringBuffer = new StringBuffer();

                String line = null;
                while ((line = reader.readLine()) != null){
                    stringBuffer.append(line+"\n");
                }

                String responseString = stringBuffer.toString();

                GetEventsResponse response = new Gson()
                        .fromJson(responseString, GetEventsResponse.class);

                return response;

            } catch (Exception e) {

            } finally {
                //close the reader; this can throw an exception too, so
                //wrap it in another try/catch block.
                if(reader != null){
                    try{
                        reader.close();
                    } catch (IOException ioe){
                        ioe.printStackTrace();
                    }
                }
            }

            return null;
        }


        private String getQuery(List<NameValuePair> params) throws UnsupportedEncodingException {

            StringBuffer result = new StringBuffer();
            boolean first = true;

            for (NameValuePair pair : params) {

                if(first) first = false;
                 else result.append("&");

                result.append(URLEncoder.encode(pair.getName(), "UTF-8"));
                result.append("=");
                result.append(URLEncoder.encode(pair.getValue(), "UTF-8"));
            }

            return result.toString();
        }

        @Override
        protected void onPostExecute(GetEventsResponse getEventsResponse) {
            super.onPostExecute(getEventsResponse);

            if(getEventsResponse != null)
            {
                //The process is success if the code is 200 and data is not null
                if(getEventsResponse.isResponseOk()) {

                    eventsResponseDelegate.onSuccess(getEventsResponse.getEventList());

                } else {

                    eventsResponseDelegate.onFailure(getEventsResponse.getMessage());
                }


            }else{
                eventsResponseDelegate.onFailure(EventsConstants.FAIL_MESSAGE);
            }
        }
    }
}
