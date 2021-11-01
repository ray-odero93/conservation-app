
package com.moringaschool.bookworld.models;

import java.io.Serializable;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class IndustryIdentifier implements Serializable, Parcelable
{

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("identifier")
    @Expose
    private String identifier;
    public final static Creator<IndustryIdentifier> CREATOR = new Creator<IndustryIdentifier>() {


        @SuppressWarnings({
            "unchecked"
        })
        public IndustryIdentifier createFromParcel(android.os.Parcel in) {
            return new IndustryIdentifier(in);
        }

        public IndustryIdentifier[] newArray(int size) {
            return (new IndustryIdentifier[size]);
        }

    }
    ;
    private final static long serialVersionUID = -6913607389579263378L;

    protected IndustryIdentifier(android.os.Parcel in) {
        this.type = ((String) in.readValue((String.class.getClassLoader())));
        this.identifier = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public IndustryIdentifier() {
    }

    /**
     * 
     * @param identifier
     * @param type
     */
    public IndustryIdentifier(String type, String identifier) {
        super();
        this.type = type;
        this.identifier = identifier;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(type);
        dest.writeValue(identifier);
    }

    public int describeContents() {
        return  0;
    }

}
