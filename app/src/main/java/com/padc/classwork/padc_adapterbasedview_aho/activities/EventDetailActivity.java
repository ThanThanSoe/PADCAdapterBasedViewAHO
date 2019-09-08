package com.padc.classwork.padc_adapterbasedview_aho.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padc.classwork.padc_adapterbasedview_aho.R;
import com.padc.classwork.padc_adapterbasedview_aho.adapters.EventDetailImageAdapter;
import com.padc.classwork.padc_adapterbasedview_aho.data.vos.EventVO;
import com.padc.classwork.padc_adapterbasedview_aho.network.dataagents.HttpUrlEventsDataAgentImpl;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventDetailActivity extends BaseActivity {

    public static final String EXTRA_TO_EVENT ="eventIdExtra";

    public static Intent newIntent(Context context, int eventIdExtra){
        Intent intent= new Intent(context, EventDetailActivity.class);
        intent.putExtra(EXTRA_TO_EVENT, eventIdExtra);
        return intent;
    }

    @BindView(R.id.tvEventTitle)
    TextView tvEventTitle;

    @BindView(R.id.iv_tag_image)
    AppCompatImageView ivTagImage;

    @BindView(R.id.tvDescription)
    TextView tvDescription;

    @BindView(R.id.tvDate)
    TextView tvData;

    @BindView(R.id.tvCategory)
    TextView tvCategory;

   /* @BindView(R.id.tv_age_range)
    TextView tvAgeRange;*/



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);

        ButterKnife.bind(this);
        ViewPager vpEventDetailItems = findViewById(R.id.vp_event_detail_img);

        EventDetailImageAdapter adapter = new EventDetailImageAdapter();
        vpEventDetailItems.setAdapter(adapter);

        int eventId = getIntent().getIntExtra(EXTRA_TO_EVENT, 0);


        eventModel.findEventById(eventId);

        EventVO event = eventModel.findEventById(eventId);

        bindData(event);
    }


    private void bindData(EventVO event){
        /*tvEventTitle.setText(event.getEvent);*/
        Glide.with(ivTagImage.getContext())
                .load(event.getEventOrganizer().getOrganizerPhotoUrl())
                .into(ivTagImage);
        tvData.setText(event.getEventStartTime());
        tvCategory.setText(String.valueOf(event.getEventType()));
//        tvAgeRange.setText(event.getEventRequirements().getAgeRange());
    }

}
