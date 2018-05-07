package com.mindorks.framework.mvp.ui.taxidisplay.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by Akki on 5/6/2018.
 */

data class PoiList(

        @SerializedName("id")
        @Expose
        var id: Int? = null,
        @SerializedName("coordinate")
        @Expose
        var coordinate: Coordinate? = null,
        @SerializedName("fleetType")
        @Expose
        var fleetType: String? = null,
        @SerializedName("heading")
        @Expose
        var heading: Double? = null) : Parcelable {
    constructor(source: Parcel) : this(
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readParcelable<Coordinate>(Coordinate::class.java.classLoader),
            source.readString(),
            source.readValue(Double::class.java.classLoader) as Double?
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeValue(id)
        writeParcelable(coordinate, 0)
        writeString(fleetType)
        writeValue(heading)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<PoiList> = object : Parcelable.Creator<PoiList> {
            override fun createFromParcel(source: Parcel): PoiList = PoiList(source)
            override fun newArray(size: Int): Array<PoiList?> = arrayOfNulls(size)
        }
    }
}

