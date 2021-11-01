
package com.moringaschool.bookworld.models;

import java.io.Serializable;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class PanelizationSummary implements Serializable, Parcelable
{

    @SerializedName("containsEpubBubbles")
    @Expose
    private Boolean containsEpubBubbles;
    @SerializedName("containsImageBubbles")
    @Expose
    private Boolean containsImageBubbles;
    public final static Creator<PanelizationSummary> CREATOR = new Creator<PanelizationSummary>() {


        @SuppressWarnings({
            "unchecked"
        })
        public PanelizationSummary createFromParcel(android.os.Parcel in) {
            return new PanelizationSummary(in);
        }

        public PanelizationSummary[] newArray(int size) {
            return (new PanelizationSummary[size]);
        }

    }
    ;
    private final static long serialVersionUID = 766182233343487139L;

    protected PanelizationSummary(android.os.Parcel in) {
        this.containsEpubBubbles = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.containsImageBubbles = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public PanelizationSummary() {
    }

    /**
     * 
     * @param containsImageBubbles
     * @param containsEpubBubbles
     */
    public PanelizationSummary(Boolean containsEpubBubbles, Boolean containsImageBubbles) {
        super();
        this.containsEpubBubbles = containsEpubBubbles;
        this.containsImageBubbles = containsImageBubbles;
    }

    public Boolean getContainsEpubBubbles() {
        return containsEpubBubbles;
    }

    public void setContainsEpubBubbles(Boolean containsEpubBubbles) {
        this.containsEpubBubbles = containsEpubBubbles;
    }

    public Boolean getContainsImageBubbles() {
        return containsImageBubbles;
    }

    public void setContainsImageBubbles(Boolean containsImageBubbles) {
        this.containsImageBubbles = containsImageBubbles;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(containsEpubBubbles);
        dest.writeValue(containsImageBubbles);
    }

    public int describeContents() {
        return  0;
    }

}
