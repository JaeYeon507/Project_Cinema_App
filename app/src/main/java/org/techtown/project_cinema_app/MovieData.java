package org.techtown.project_cinema_app;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieData implements Parcelable {

    String title,
            releaseDate,
            showTimes,
            ticketSales,
            story,
            director,
            actors;

    int posterResID, totalAttendance;
    float mark = 8.2f;

    public MovieData(String title, String releaseDate, String showTimes, String ticketSales, String story, String director, String actors, int posterResID, int totalAttendance, float mark) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.showTimes = showTimes;
        this.ticketSales = ticketSales;
        this.story = story;
        this.director = director;
        this.actors = actors;
        this.posterResID = posterResID;
        this.totalAttendance = totalAttendance;
        this.mark = mark;
    }

    protected MovieData(Parcel in) {
        title = in.readString();
        releaseDate = in.readString();
        showTimes = in.readString();
        ticketSales = in.readString();
        story = in.readString();
        director = in.readString();
        actors = in.readString();
        posterResID = in.readInt();
        totalAttendance = in.readInt();
        mark = in.readFloat();
    }

    public static final Creator<MovieData> CREATOR = new Creator<MovieData>() {
        @Override
        public MovieData createFromParcel(Parcel in) {
            return new MovieData(in);
        }

        @Override
        public MovieData[] newArray(int size) {
            return new MovieData[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getShowTimes() {
        return showTimes;
    }

    public void setShowTimes(String showTimes) {
        this.showTimes = showTimes;
    }

    public String getTicketSales() {
        return ticketSales;
    }

    public void setTicketSales(String ticketSales) {
        this.ticketSales = ticketSales;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public int getPosterResID() {
        return posterResID;
    }

    public void setPosterResID(int posterResID) {
        this.posterResID = posterResID;
    }

    public int getTotalAttendance() {
        return totalAttendance;
    }

    public void setTotalAttendance(int totalAttendance) {
        this.totalAttendance = totalAttendance;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(releaseDate);
        parcel.writeString(showTimes);
        parcel.writeString(ticketSales);
        parcel.writeString(story);
        parcel.writeString(director);
        parcel.writeString(actors);
        parcel.writeInt(posterResID);
        parcel.writeInt(totalAttendance);
        parcel.writeFloat(mark);
    }
}
