
package com.moringaschool.bookworld.models;

import java.io.Serializable;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.moringaschool.bookworld.models.Epub;
import com.moringaschool.bookworld.models.Pdf;

import org.parceler.Parcel;

@Parcel
public class AccessInfo implements Serializable, Parcelable
{

    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("viewability")
    @Expose
    private String viewability;
    @SerializedName("embeddable")
    @Expose
    private Boolean embeddable;
    @SerializedName("publicDomain")
    @Expose
    private Boolean publicDomain;
    @SerializedName("textToSpeechPermission")
    @Expose
    private String textToSpeechPermission;
    @SerializedName("epub")
    @Expose
    private com.moringaschool.bookworld.models.Epub epub;
    @SerializedName("pdf")
    @Expose
    private com.moringaschool.bookworld.models.Pdf pdf;
    @SerializedName("webReaderLink")
    @Expose
    private String webReaderLink;
    @SerializedName("accessViewStatus")
    @Expose
    private String accessViewStatus;
    @SerializedName("quoteSharingAllowed")
    @Expose
    private Boolean quoteSharingAllowed;
    public final static Creator<AccessInfo> CREATOR = new Creator<AccessInfo>() {


        @SuppressWarnings({
            "unchecked"
        })
        public AccessInfo createFromParcel(android.os.Parcel in) {
            return new AccessInfo(in);
        }

        public AccessInfo[] newArray(int size) {
            return (new AccessInfo[size]);
        }

    }
    ;
    private final static long serialVersionUID = -537321794775401448L;

    protected AccessInfo(android.os.Parcel in) {
        this.country = ((String) in.readValue((String.class.getClassLoader())));
        this.viewability = ((String) in.readValue((String.class.getClassLoader())));
        this.embeddable = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.publicDomain = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.textToSpeechPermission = ((String) in.readValue((String.class.getClassLoader())));
        this.epub = ((com.moringaschool.bookworld.models.Epub) in.readValue((com.moringaschool.bookworld.models.Epub.class.getClassLoader())));
        this.pdf = ((com.moringaschool.bookworld.models.Pdf) in.readValue((com.moringaschool.bookworld.models.Pdf.class.getClassLoader())));
        this.webReaderLink = ((String) in.readValue((String.class.getClassLoader())));
        this.accessViewStatus = ((String) in.readValue((String.class.getClassLoader())));
        this.quoteSharingAllowed = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public AccessInfo() {
    }

    /**
     * 
     * @param accessViewStatus
     * @param country
     * @param viewability
     * @param pdf
     * @param webReaderLink
     * @param epub
     * @param publicDomain
     * @param quoteSharingAllowed
     * @param embeddable
     * @param textToSpeechPermission
     */
    public AccessInfo(String country, String viewability, Boolean embeddable, Boolean publicDomain, String textToSpeechPermission, com.moringaschool.bookworld.models.Epub epub, com.moringaschool.bookworld.models.Pdf pdf, String webReaderLink, String accessViewStatus, Boolean quoteSharingAllowed) {
        super();
        this.country = country;
        this.viewability = viewability;
        this.embeddable = embeddable;
        this.publicDomain = publicDomain;
        this.textToSpeechPermission = textToSpeechPermission;
        this.epub = epub;
        this.pdf = pdf;
        this.webReaderLink = webReaderLink;
        this.accessViewStatus = accessViewStatus;
        this.quoteSharingAllowed = quoteSharingAllowed;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getViewability() {
        return viewability;
    }

    public void setViewability(String viewability) {
        this.viewability = viewability;
    }

    public Boolean getEmbeddable() {
        return embeddable;
    }

    public void setEmbeddable(Boolean embeddable) {
        this.embeddable = embeddable;
    }

    public Boolean getPublicDomain() {
        return publicDomain;
    }

    public void setPublicDomain(Boolean publicDomain) {
        this.publicDomain = publicDomain;
    }

    public String getTextToSpeechPermission() {
        return textToSpeechPermission;
    }

    public void setTextToSpeechPermission(String textToSpeechPermission) {
        this.textToSpeechPermission = textToSpeechPermission;
    }

    public com.moringaschool.bookworld.models.Epub getEpub() {
        return epub;
    }

    public void setEpub(Epub epub) {
        this.epub = epub;
    }

    public com.moringaschool.bookworld.models.Pdf getPdf() {
        return pdf;
    }

    public void setPdf(Pdf pdf) {
        this.pdf = pdf;
    }

    public String getWebReaderLink() {
        return webReaderLink;
    }

    public void setWebReaderLink(String webReaderLink) {
        this.webReaderLink = webReaderLink;
    }

    public String getAccessViewStatus() {
        return accessViewStatus;
    }

    public void setAccessViewStatus(String accessViewStatus) {
        this.accessViewStatus = accessViewStatus;
    }

    public Boolean getQuoteSharingAllowed() {
        return quoteSharingAllowed;
    }

    public void setQuoteSharingAllowed(Boolean quoteSharingAllowed) {
        this.quoteSharingAllowed = quoteSharingAllowed;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(country);
        dest.writeValue(viewability);
        dest.writeValue(embeddable);
        dest.writeValue(publicDomain);
        dest.writeValue(textToSpeechPermission);
        dest.writeValue(epub);
        dest.writeValue(pdf);
        dest.writeValue(webReaderLink);
        dest.writeValue(accessViewStatus);
        dest.writeValue(quoteSharingAllowed);
    }

    public int describeContents() {
        return  0;
    }

}
