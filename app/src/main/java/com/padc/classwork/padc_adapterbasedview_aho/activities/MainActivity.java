package com.padc.classwork.padc_adapterbasedview_aho.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.padc.classwork.padc_adapterbasedview_aho.R;
import com.padc.classwork.padc_adapterbasedview_aho.adapters.EventListAdapter;
import com.padc.classwork.padc_adapterbasedview_aho.data.models.EventModel;
import com.padc.classwork.padc_adapterbasedview_aho.data.models.EventModelImpl;
import com.padc.classwork.padc_adapterbasedview_aho.data.vos.EventVO;
import com.padc.classwork.padc_adapterbasedview_aho.delegates.EventItemDelegates;
import com.padc.classwork.padc_adapterbasedview_aho.network.EventsApi;
import com.padc.classwork.padc_adapterbasedview_aho.network.dataagents.EventsDataAgent;
import com.padc.classwork.padc_adapterbasedview_aho.network.dataagents.HttpUrlEventsDataAgentImpl;
import com.padc.classwork.padc_adapterbasedview_aho.utils.EventsConstants;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements EventItemDelegates {

    @BindView(R.id.rvEvents)
    RecyclerView rvEvents;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        final EventListAdapter adapter = new EventListAdapter(this);
        rvEvents.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        rvEvents.setAdapter(adapter);

//        //from data layer
//        EventModelImpl.getObjInstance().getEvents(new EventModel.GetEventsFromDataLayerDelegate() {
//            @Override
//            public void onSuccess(List<EventVO> events) {
//                adapter.setNewData(events);
//            }
//
//            @Override
//            public void onFailure(String errorMessage) {
//
//            }
//        });

        //Load Data onto views
        eventModel.getEvents(new EventModel.GetEventsFromDataLayerDelegate() {
            @Override
            public void onSuccess(List<EventVO> events) {
                adapter.setNewData(events);
            }

            @Override
            public void onFailure(String errorMessage) {
                showInfiniteSnackBar(errorMessage);
            }
        });

    }

    @Override
    public void onTapEventItem(int eventId) {
        /*Intent eventDetailsIntent = new Intent();
        eventDetailsIntent.putExtra(EventDetailActivity.EXTRA_TO_EVENT, eventId);
        startActivity(new Intent(this, EventDetailActivity.class));*/

        Intent intent= EventDetailActivity.newIntent(getApplicationContext(),eventId);
        startActivity(intent);
    }
}
