package com.mindorks.framework.mvp.ui.taxidisplay.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by Akki on 5/6/2018.
 */
class Coordinate(
        @SerializedName("latitude")
        @Expose
        var latitude: Double? = null,
        @SerializedName("longitude")
        @Expose
        var longitude: Double? = null

) : Parcelable {
    constructor(source: Parcel) : this(
            source.readValue(Double::class.java.classLoader) as Double?,
            source.readValue(Double::class.java.classLoader) as Double?
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeValue(latitude)
        writeValue(longitude)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Coordinate> = object : Parcelable.Creator<Coordinate> {
            override fun createFromParcel(source: Parcel): Coordinate = Coordinate(source)
            override fun newArray(size: Int): Array<Coordinate?> = arrayOfNulls(size)
        }
    }
}