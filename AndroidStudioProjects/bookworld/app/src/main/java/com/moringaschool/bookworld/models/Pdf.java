
package com.moringaschool.bookworld.models;

import java.io.Serializable;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Pdf implements Serializable, Parcelable
{

    @SerializedName("isAvailable")
    @Expose
    private Boolean isAvailable;
    public final static Creator<Pdf> CREATOR = new Creator<Pdf>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Pdf createFromParcel(android.os.Parcel in) {
            return new Pdf(in);
        }

        public Pdf[] newArray(int size) {
            return (new Pdf[size]);
        }

    }
    ;
    private final static long serialVersionUID = -4190749293485261534L;

    protected Pdf(android.os.Parcel in) {
        this.isAvailable = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Pdf() {
    }

    /**
     * 
     * @param isAvailable
     */
    public Pdf(Boolean isAvailable) {
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
