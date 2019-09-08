package com.padc.classwork.padc_adapterbasedview_aho.data.vos;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;
@Entity(tableName = "event_requirement", indices = {@Index(value = "id",unique = true)})
public class EventRequirementsVO {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "event_id_pk")
    private int eventRequiermentIdPK;

    @SerializedName("gender")
    @ColumnInfo(name = "gender")
    private int gender;

    @SerializedName("age_range")
    @ColumnInfo(name = "age_range")
    private String ageRange;

    @SerializedName("privacy")
    @ColumnInfo(name = "privacy")
    private String privacy;

    @SerializedName("max_people_available")
    @ColumnInfo(name = "max_people_available")
    private int maxPeopleAvailable;

    public int getEventRequiermentIdPK() {
        return eventRequiermentIdPK;
    }

    public void setEventRequiermentIdPK(int eventRequiermentIdPK) {
        this.eventRequiermentIdPK = eventRequiermentIdPK;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(String ageRange) {
        this.ageRange = ageRange;
    }

    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    public int getMaxPeopleAvailable() {
        return maxPeopleAvailable;
    }

    public void setMaxPeopleAvailable(int maxPeopleAvailable) {
        this.maxPeopleAvailable = maxPeopleAvailable;
    }
}
