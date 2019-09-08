package com.padc.classwork.padc_adapterbasedview_aho.data.vos;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "user", indices = {@Index(value = "id",unique = true)})
public class UserVO {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id_pk")
    private int userIdPK;

    @SerializedName("user_name")
    @ColumnInfo(name = "user_name")
    private String userName;

    @SerializedName("email")
    @ColumnInfo(name = "email")
    private String email;

    @SerializedName("phone_number")
    @ColumnInfo(name = "phone_number")
    private String phoneNumber;

    @SerializedName("photo_url")
    @ColumnInfo(name = "photo_url")
    private String photoUrl;

    @SerializedName("cover_photo_url")
    @ColumnInfo(name = "cover_photo_url")
    private String coverPhotoUrl;

    @SerializedName("address")
    @ColumnInfo(name = "address")
    private String address;

    public int getUserIdPK() {
        return userIdPK;
    }

    public void setUserIdPK(int userIdPK) {
        this.userIdPK = userIdPK;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getCoverPhotoUrl() {
        return coverPhotoUrl;
    }

    public void setCoverPhotoUrl(String coverPhotoUrl) {
        this.coverPhotoUrl = coverPhotoUrl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
