package com.padc.classwork.padc_adapterbasedview_aho.adapters;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.classwork.padc_adapterbasedview_aho.R;

public class EventDetailImageAdapter extends PagerAdapter {

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return (view == o);
    }

    //inflate view-item
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        //create inflater
        LayoutInflater inflater = LayoutInflater.from(container.getContext());

        //get view from inflater
        View view = inflater.inflate(R.layout.item_event_detail_image, container,false);

        //add view to root container
        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}



































