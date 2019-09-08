package com.padc.classwork.padc_adapterbasedview_aho.data.vos;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;
@Entity(tableName = "event_organizer", indices = {@Index(value = "id",unique = true)})
public class EventOrganizerVO {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "event_organizer_id_pk")
    private int eventOrganizerIdPK;

    @SerializedName("organizer_name")
    @ColumnInfo(name = "organizer_name")
    private String organizerName;

    @SerializedName("organizer_photo_url")
    @ColumnInfo(name = "organizer_photo_url")
    private String organizerPhotoUrl;

    @SerializedName("organizer_role")
    @ColumnInfo(name = "organizer_role")
    private String organizerRole;

    public int getEventOrganizerIdPK() {
        return eventOrganizerIdPK;
    }

    public void setEventOrganizerIdPK(int eventOrganizerIdPK) {
        this.eventOrganizerIdPK = eventOrganizerIdPK;
    }

    public String getOrganizerName() {
        return organizerName;
    }

    public void setOrganizerName(String organizerName) {
        this.organizerName = organizerName;
    }

    public String getOrganizerPhotoUrl() {
        return organizerPhotoUrl;
    }

    public void setOrganizerPhotoUrl(String organizerPhotoUrl) {
        this.organizerPhotoUrl = organizerPhotoUrl;
    }

    public String getOrganizerRole() {
        return organizerRole;
    }

    public void setOrganizerRole(String organizerRole) {
        this.organizerRole = organizerRole;
    }
}
