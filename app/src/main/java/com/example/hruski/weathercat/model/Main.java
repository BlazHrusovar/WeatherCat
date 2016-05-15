package com.example.hruski.weathercat.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Main implements Parcelable {

    private float temp;

    public Main(float temp){
        this.temp = temp;
    }

    protected Main(Parcel in) {

        temp = in.readFloat();
    }

    public static final Creator<Main> CREATOR = new Creator<Main>() {
        @Override
        public Main createFromParcel(Parcel in) {
            return new Main(in);
        }

        @Override
        public Main[] newArray(int size) {
            return new Main[size];
        }
    };

    public float getTemp(){
        return temp;
    }

    @Override
    public int describeContents() {

        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeFloat(temp);
    }
}
