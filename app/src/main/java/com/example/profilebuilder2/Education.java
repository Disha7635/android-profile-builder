package com.example.profilebuilder2;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Education implements Parcelable {
    private String university_name;
    private String degree;
    private String edu_year;

    public Education(String university_name, String degree, String edu_year) {
        this.university_name = university_name;
        this.degree = degree;
        this.edu_year = edu_year;
    }

    protected Education(Parcel in) {
        university_name = in.readString();
        degree = in.readString();
        edu_year = in.readString();
    }

    public static final Creator<Education> CREATOR = new Creator<Education>() {
        @Override
        public Education createFromParcel(Parcel in) {
            return new Education(in);
        }

        @Override
        public Education[] newArray(int size) {
            return new Education[size];
        }
    };

    public String getUniversity_name() {
        return university_name;
    }

    public void setUniversity_name(String university_name) {
        this.university_name = university_name;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getEdu_year() {
        return edu_year;
    }

    public void setEdu_year(String edu_year) {
        this.edu_year = edu_year;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(university_name);
        parcel.writeString(degree);
        parcel.writeString(edu_year);
    }
}
