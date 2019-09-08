package com.padc.classwork.padc_adapterbasedview_aho.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.classwork.padc_adapterbasedview_aho.R;
import com.padc.classwork.padc_adapterbasedview_aho.data.vos.EventVO;
import com.padc.classwork.padc_adapterbasedview_aho.delegates.EventItemDelegates;
import com.padc.classwork.padc_adapterbasedview_aho.views.holders.EventItemViewHolder;

public class EventListAdapter extends BaseRecyclerAdapter<EventItemViewHolder, EventVO>{

    private EventItemDelegates mEventItemDelegates;

    public EventListAdapter(EventItemDelegates mEventItemDelegates) {
        this.mEventItemDelegates = mEventItemDelegates;
    }

    @NonNull
    @Override
    public EventItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item_event, parent,false);
        return new EventItemViewHolder(itemView, mEventItemDelegates);
    }

}
