package com.padc.classwork.padc_adapterbasedview_aho.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.padc.classwork.padc_adapterbasedview_aho.views.holders.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

//T(view_holder) -> W -> W(data)
public abstract class BaseRecyclerAdapter<T extends BaseViewHolder<W>, W> extends RecyclerView.Adapter<T> {

    private List<W> mData = new ArrayList<>();

    @Override
    public void onBindViewHolder(@NonNull T viewHolder, int position) {
        viewHolder.bindData(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setNewData(List<W> data){
            mData = data;
            notifyDataSetChanged(); //call onBindViewHolder() again and data will be refreshed.
    }

}
