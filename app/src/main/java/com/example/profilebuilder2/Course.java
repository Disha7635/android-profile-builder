package com.example.profilebuilder2;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Course implements Parcelable {
    private String course;
    private String organisation_name;
    private String course_year;

    public Course(String course, String organisation_name, String course_year) {
        this.course = course;
        this.organisation_name = organisation_name;
        this.course_year = course_year;
    }

    protected Course(Parcel in) {
        course = in.readString();
        organisation_name = in.readString();
        course_year = in.readString();
    }

    public static final Creator<Course> CREATOR = new Creator<Course>() {
        @Override
        public Course createFromParcel(Parcel in) {
            return new Course(in);
        }

        @Override
        public Course[] newArray(int size) {
            return new Course[size];
        }
    };

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getOrganisation_name() {
        return organisation_name;
    }

    public void setOrganisation_name(String organisation_name) {
        this.organisation_name = organisation_name;
    }

    public String getCourse_year() {
        return course_year;
    }

    public void setCourse_year(String course_year) {
        this.course_year = course_year;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(course);
        parcel.writeString(organisation_name);
        parcel.writeString(course_year);
    }
}
