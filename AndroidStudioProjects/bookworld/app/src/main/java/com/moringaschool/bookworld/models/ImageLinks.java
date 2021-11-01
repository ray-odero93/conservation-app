
package com.moringaschool.bookworld.models;

import java.io.Serializable;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class ImageLinks implements Serializable, Parcelable
{

    @SerializedName("smallThumbnail")
    @Expose
    private String smallThumbnail;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    public final static Creator<ImageLinks> CREATOR = new Creator<ImageLinks>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ImageLinks createFromParcel(android.os.Parcel in) {
            return new ImageLinks(in);
        }

        public ImageLinks[] newArray(int size) {
            return (new ImageLinks[size]);
        }

    }
    ;
    private final static long serialVersionUID = -7720066223885111609L;

    protected ImageLinks(android.os.Parcel in) {
        this.smallThumbnail = ((String) in.readValue((String.class.getClassLoader())));
        this.thumbnail = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public ImageLinks() {
    }

    /**
     * 
     * @param thumbnail
     * @param smallThumbnail
     */
    public ImageLinks(String smallThumbnail, String thumbnail) {
        super();
        this.smallThumbnail = smallThumbnail;
        this.thumbnail = thumbnail;
    }

    public String getSmallThumbnail() {
        return smallThumbnail;
    }

    public void setSmallThumbnail(String smallThumbnail) {
        this.smallThumbnail = smallThumbnail;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(smallThumbnail);
        dest.writeValue(thumbnail);
    }

    public int describeContents() {
        return  0;
    }

}
