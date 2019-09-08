package com.padc.classwork.padc_adapterbasedview_aho.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.padc.classwork.padc_adapterbasedview_aho.R;
import com.padc.classwork.padc_adapterbasedview_aho.data.models.EventModel;
import com.padc.classwork.padc_adapterbasedview_aho.data.models.EventModelImpl;

public abstract class BaseActivity extends AppCompatActivity {

    protected EventModel eventModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        eventModel = EventModelImpl.getObjInstance();
    }

    protected void showInfiniteSnackBar(String message){
        final Snackbar snackbar = Snackbar.make(getWindow().getDecorView(), message, Snackbar.LENGTH_INDEFINITE);
        snackbar.setAction(getResources().getString(R.string.lbl_snack_bar_ok), new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackbar.dismiss();
            }
        });
    }
}
