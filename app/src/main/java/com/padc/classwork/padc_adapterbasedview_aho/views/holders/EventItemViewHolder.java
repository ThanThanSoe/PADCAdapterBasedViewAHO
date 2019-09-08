package com.padc.classwork.padc_adapterbasedview_aho.views.holders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padc.classwork.padc_adapterbasedview_aho.R;
import com.padc.classwork.padc_adapterbasedview_aho.data.vos.EventVO;
import com.padc.classwork.padc_adapterbasedview_aho.delegates.EventItemDelegates;

import org.mmtextview.components.MMTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventItemViewHolder extends BaseViewHolder<EventVO> {

    private EventItemDelegates mEventItemDelegate;

    @BindView(R.id.img_profile)
    ImageView ivEvent;

    @BindView(R.id.text_name)
    MMTextView textName;

    @BindView(R.id.text_time)
    MMTextView textTime;

    @BindView(R.id.img_gender)
    ImageView ivGender;

    @BindView(R.id.text_shop_name)
    MMTextView textShopName;

    @BindView(R.id.text_address)
    MMTextView textAddress;

    @BindView(R.id.img_profile_2)
    ImageView ivPerson;

    @BindView(R.id.text_name_2)
    MMTextView textNamePerson;

    @BindView(R.id.text_profile_2)
    TextView textProfile;

    @BindView(R.id.tv_age_range)
    TextView tvAgeRange;


    public EventItemViewHolder(@NonNull View itemView, EventItemDelegates delegate) {
        super(itemView);
        ButterKnife.bind(this , itemView);

        mEventItemDelegate = delegate;



        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEventItemDelegate.onTapEventItem(mData.getId());
            }
        });
    }

    @Override
    public void bindData(EventVO data) {
            mData = data;
            Glide.with(itemView)
                .load(data.getEventOrganizer().getOrganizerPhotoUrl())
                .into(ivPerson);

            tvAgeRange.setText(mData.getEventRequirements().getAgeRange());
            textName.setText(mData.getEventName());
            textTime.setText(mData.getEventStartTime() + " - "+ data.getEventEndTime());
            //textShopName.setText(mData.getEvent_location_name());
            textAddress.setText(mData.getEventLocationFullAddress());
            textNamePerson.setText(mData.getEventOrganizer().getOrganizerName());
            textProfile.setText(mData.getEventOrganizer().getOrganizerRole());
    }
}
