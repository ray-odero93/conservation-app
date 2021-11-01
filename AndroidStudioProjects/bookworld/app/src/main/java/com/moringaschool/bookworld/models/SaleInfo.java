
package com.moringaschool.bookworld.models;

import java.io.Serializable;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class SaleInfo implements Serializable, Parcelable
{

    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("saleability")
    @Expose
    private String saleability;
    @SerializedName("isEbook")
    @Expose
    private Boolean isEbook;
    public final static Creator<SaleInfo> CREATOR = new Creator<SaleInfo>() {


        @SuppressWarnings({
            "unchecked"
        })
        public SaleInfo createFromParcel(android.os.Parcel in) {
            return new SaleInfo(in);
        }

        public SaleInfo[] newArray(int size) {
            return (new SaleInfo[size]);
        }

    }
    ;
    private final static long serialVersionUID = -4167388198086295534L;

    protected SaleInfo(android.os.Parcel in) {
        this.country = ((String) in.readValue((String.class.getClassLoader())));
        this.saleability = ((String) in.readValue((String.class.getClassLoader())));
        this.isEbook = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public SaleInfo() {
    }

    /**
     * 
     * @param country
     * @param isEbook
     * @param saleability
     */
    public SaleInfo(String country, String saleability, Boolean isEbook) {
        super();
        this.country = country;
        this.saleability = saleability;
        this.isEbook = isEbook;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSaleability() {
        return saleability;
    }

    public void setSaleability(String saleability) {
        this.saleability = saleability;
    }

    public Boolean getIsEbook() {
        return isEbook;
    }

    public void setIsEbook(Boolean isEbook) {
        this.isEbook = isEbook;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(country);
        dest.writeValue(saleability);
        dest.writeValue(isEbook);
    }

    public int describeContents() {
        return  0;
    }

}
