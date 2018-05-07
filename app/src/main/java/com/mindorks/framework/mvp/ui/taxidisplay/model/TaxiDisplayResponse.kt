package com.mindorks.framework.mvp.ui.taxidisplay.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by Akki on 5/6/2018.
 */
data class TaxiDisplayResponse(
        @SerializedName("poiList")
        @Expose
        var poiList: List<PoiList>? = null) : Parcelable {
    constructor(source: Parcel) : this(
            ArrayList<PoiList>().apply { source.readList(this, PoiList::class.java.classLoader) }
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeList(poiList)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<TaxiDisplayResponse> = object : Parcelable.Creator<TaxiDisplayResponse> {
            override fun createFromParcel(source: Parcel): TaxiDisplayResponse = TaxiDisplayResponse(source)
            override fun newArray(size: Int): Array<TaxiDisplayResponse?> = arrayOfNulls(size)
        }
    }
}

