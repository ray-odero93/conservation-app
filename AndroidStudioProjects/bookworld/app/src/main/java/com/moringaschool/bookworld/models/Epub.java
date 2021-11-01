
package com.moringaschool.bookworld.models;

import java.io.Serializable;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Epub implements Serializable, Parcelable
{

    @SerializedName("isAvailable")
    @Expose
    private Boolean isAvailable;
    public final static Creator<Epub> CREATOR = new Creator<Epub>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Epub createFromParcel(android.os.Parcel in) {
            return new Epub(in);
        }

        public Epub[] newArray(int size) {
            return (new Epub[size]);
        }

    }
    ;
    private final static long serialVersionUID = 8300460602303418904L;

    protected Epub(android.os.Parcel in) {
        this.isAvailable = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Epub() {
    }

    /**
     * 
     * @param isAvailable
     */
    public Epub(Boolean isAvailable) {
        super();
        this.isAvailable = isAvailable;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(isAvailable);
    }

    public int describeContents() {
        return  0;
    }

}
