
package com.moringaschool.bookworld.models;

import java.io.Serializable;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class SearchInfo implements Serializable, Parcelable
{

    @SerializedName("textSnippet")
    @Expose
    private String textSnippet;
    public final static Creator<SearchInfo> CREATOR = new Creator<SearchInfo>() {


        @SuppressWarnings({
            "unchecked"
        })
        public SearchInfo createFromParcel(android.os.Parcel in) {
            return new SearchInfo(in);
        }

        public SearchInfo[] newArray(int size) {
            return (new SearchInfo[size]);
        }

    }
    ;
    private final static long serialVersionUID = 761767921862123560L;

    protected SearchInfo(android.os.Parcel in) {
        this.textSnippet = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public SearchInfo() {
    }

    /**
     * 
     * @param textSnippet
     */
    public SearchInfo(String textSnippet) {
        super();
        this.textSnippet = textSnippet;
    }

    public String getTextSnippet() {
        return textSnippet;
    }

    public void setTextSnippet(String textSnippet) {
        this.textSnippet = textSnippet;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(textSnippet);
    }

    public int describeContents() {
        return  0;
    }

}
