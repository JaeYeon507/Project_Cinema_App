package org.techtown.project_cinema_app;

import android.os.Parcel;
import android.os.Parcelable;

public class Item implements Parcelable {

    String userId, time, comment;
    int resId;
    float star_num;

    public Item(String userId, String time, String comment, int resId, float star_num) {
        this.userId = userId;
        this.time = time;
        this.comment = comment;
        this.resId = resId;
        this.star_num = star_num;
    }

    protected Item(Parcel in) {
        userId = in.readString();
        time = in.readString();
        comment = in.readString();
        resId = in.readInt();
        star_num = in.readFloat();
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String useId) {
        this.userId = userId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public float getStar_num() {
        return star_num;
    }

    public void setStar_num(float star_num) {
        this.star_num = star_num;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(userId);
        parcel.writeString(time);
        parcel.writeString(comment);
        parcel.writeInt(resId);
        parcel.writeFloat(star_num);
    }
}
