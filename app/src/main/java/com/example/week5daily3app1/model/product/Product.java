package com.example.week5daily3app1.model.product;

import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable {

    // Everything is a String for convenience
    String name;
    String idNumber;
    String count;
    String description;

    public Product() {
    }

    public Product(String name, String idNumber, String count, String description) {
        this.name = name;
        this.idNumber = idNumber;
        this.count = count;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
