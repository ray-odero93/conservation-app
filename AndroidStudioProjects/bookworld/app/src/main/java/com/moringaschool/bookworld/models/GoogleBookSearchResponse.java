
package com.moringaschool.bookworld.models;

import java.io.Serializable;
import java.util.List;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.moringaschool.bookworld.models.Item;

import org.parceler.Parcel;

@Parcel
public class GoogleBookSearchResponse implements Serializable, Parcelable
{

    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("totalItems")
    @Expose
    private Integer totalItems;
    @SerializedName("items")
    @Expose
    private List<com.moringaschool.bookworld.models.Item> items = null;
    public final static Creator<GoogleBookSearchResponse> CREATOR = new Creator<GoogleBookSearchResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public GoogleBookSearchResponse createFromParcel(android.os.Parcel in) {
            return new GoogleBookSearchResponse(in);
        }

        public GoogleBookSearchResponse[] newArray(int size) {
            return (new GoogleBookSearchResponse[size]);
        }

    }
    ;
    private final static long serialVersionUID = 2481514257002855693L;

    protected GoogleBookSearchResponse(android.os.Parcel in) {
        this.kind = ((String) in.readValue((String.class.getClassLoader())));
        this.totalItems = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.items, (com.moringaschool.bookworld.models.Item.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public GoogleBookSearchResponse() {
    }

    /**
     * 
     * @param totalItems
     * @param kind
     * @param items
     */
    public GoogleBookSearchResponse(String kind, Integer totalItems, List<com.moringaschool.bookworld.models.Item> items) {
        super();
        this.kind = kind;
        this.totalItems = totalItems;
        this.items = items;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Integer getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

    public List<com.moringaschool.bookworld.models.Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(kind);
        dest.writeValue(totalItems);
        dest.writeList(items);
    }

    public int describeContents() {
        return  0;
    }

}
