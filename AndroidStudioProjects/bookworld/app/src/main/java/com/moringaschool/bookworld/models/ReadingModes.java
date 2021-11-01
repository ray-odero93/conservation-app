
package com.moringaschool.bookworld.models;

import java.io.Serializable;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class ReadingModes implements Serializable, Parcelable
{

    @SerializedName("text")
    @Expose
    private Boolean text;
    @SerializedName("image")
    @Expose
    private Boolean image;
    public final static Creator<ReadingModes> CREATOR = new Creator<ReadingModes>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ReadingModes createFromParcel(android.os.Parcel in) {
            return new ReadingModes(in);
        }

        public ReadingModes[] newArray(int size) {
            return (new ReadingModes[size]);
        }

    }
    ;
    private final static long serialVersionUID = 6568055766835661402L;

    protected ReadingModes(android.os.Parcel in) {
        this.text = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.image = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public ReadingModes() {
    }

    /**
     * 
     * @param image
     * @param text
     */
    public ReadingModes(Boolean text, Boolean image) {
        super();
        this.text = text;
        this.image = image;
    }

    public Boolean getText() {
        return text;
    }

    public void setText(Boolean text) {
        this.text = text;
    }

    public Boolean getImage() {
        return image;
    }

    public void setImage(Boolean image) {
        this.image = image;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(text);
        dest.writeValue(image);
    }

    public int describeContents() {
        return  0;
    }

}
