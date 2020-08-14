package org.techtown.project_cinema_app;

import android.os.Parcel;
import android.os.Parcelable;

public class RatedItem implements Parcelable {

    float num;
    String et;

    public RatedItem(float num, String et) {
        this.num = num;
        this.et = et;
    }

    public RatedItem(Parcel in){
        this.num = in.readFloat();
        this.et = in.readString();
    }

    public float getNum() {
        return num;
    }

    public void setNum(float num) {
        this.num = num;
    }

    public String getEt() {
        return et;
    }

    public void setEt(String et) {
        this.et = et;
    }

    public static final Creator<RatedItem> CREATOR = new Creator<RatedItem>() {
        @Override
        public RatedItem createFromParcel(Parcel in) {
            return new RatedItem(in);
        }

        @Override
        public RatedItem[] newArray(int size) {
            return new RatedItem[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(num);
        parcel.writeString(et);
    }
}
