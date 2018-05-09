package com.mindorks.framework.mvp.ui.base

import android.Manifest
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import android.os.Bundle
import android.content.DialogInterface
import android.support.v4.content.ContextCompat.startActivity
import android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS
import android.location.LocationManager
import android.content.Context.LOCATION_SERVICE
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.support.v4.content.ContextCompat.checkSelfPermission
import android.util.Log


/**
 * Created by Akki on 5/9/2018.
 */
class GPSTrackerService(mmContext: Context) : LocationListener {

    internal var isGPSEnabled = false
    internal var isNetworkEnabled = false
    internal var canGetLocation = false
    internal var location: Location? = null
    internal var latitude: Double = 0.toDouble()
    internal var longitude: Double = 0.toDouble()


    protected var locationManager: LocationManager? = null


    private var mContext:Context=mmContext

    init {
        val m_Location: Location?=getLocation()

    }

    fun getLocation(): Location? {

        try {
            locationManager = mContext
                    .getSystemService(Context.LOCATION_SERVICE) as LocationManager

            isGPSEnabled = locationManager!!
                    .isProviderEnabled(LocationManager.GPS_PROVIDER)

            println("******isGPSEnabled********" + isGPSEnabled)

            isNetworkEnabled = locationManager!!
                    .isProviderEnabled(LocationManager.NETWORK_PROVIDER)

            println("******isNetworkEnabled********" + isNetworkEnabled)

            if (!isGPSEnabled && !isNetworkEnabled) {
                // no network provider is enabled
            } else {
                this.canGetLocation = true
                if (isGPSEnabled) {
                    if (location == null) {
                        if (checkSelfPermission(mContext, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                                || checkSelfPermission(mContext, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED)
                        locationManager!!.requestLocationUpdates(
                                LocationManager.GPS_PROVIDER,
                                MIN_TIME_BW_UPDATES,
                                MIN_DISTANCE_CHANGE_FOR_UPDATES.toFloat(), this)
                        Log.d("GPS", "GPS Enabled")
                        if (locationManager != null) {
                            location = locationManager!!
                                    .getLastKnownLocation(LocationManager.GPS_PROVIDER)

                            Log.d("location", location!!.toString() + "")
                            if (location != null) {
                                latitude = location!!.latitude
                                longitude = location!!.longitude
                            } else if (isNetworkEnabled) {
                                locationManager!!.requestLocationUpdates(
                                        LocationManager.NETWORK_PROVIDER,
                                        MIN_TIME_BW_UPDATES,
                                        MIN_DISTANCE_CHANGE_FOR_UPDATES.toFloat(), this)
                                Log.d("Network", "Network Enabled")
                                if (locationManager != null) {
                                    location = locationManager!!
                                            .getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
                                    Log.d("location", location!!.toString() + "")
                                    if (location != null) {
                                        latitude = location!!.latitude
                                        longitude = location!!.longitude
                                    }
                                }
                            }
                        }
                    }
                } else if (isNetworkEnabled) {
                    locationManager!!.requestLocationUpdates(
                            LocationManager.NETWORK_PROVIDER,
                            MIN_TIME_BW_UPDATES,
                            MIN_DISTANCE_CHANGE_FOR_UPDATES.toFloat(), this)
                    Log.d("Network", "Network Enabled")
                    if (locationManager != null) {
                        location = locationManager!!
                                .getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
                        Log.d("location", location!!.toString() + "")
                        if (location != null) {
                            latitude = location!!.latitude
                            longitude = location!!.longitude

                        }
                    }
                }
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }


        return location
    }

    fun stopUsingGPS() {
        if (locationManager != null) {
            locationManager!!.removeUpdates(this@GPSTrackerService)
        }
    }

    fun getLatitude(): Double {
        if (location != null) {
            latitude = location!!.latitude
        }

        return latitude
    }

    fun getLongitude(): Double {
        if (location != null) {
            longitude = location!!.longitude
        }

        return longitude
    }

    fun canGetLocation(): Boolean {
        return this.canGetLocation
    }

    override fun onLocationChanged(arg0: Location) {
        // TODO Auto-generated method stub

    }

    override fun onProviderDisabled(arg0: String) {
        // TODO Auto-generated method stub

    }

    override fun onProviderEnabled(arg0: String) {
        // TODO Auto-generated method stub

    }

    override fun onStatusChanged(arg0: String, arg1: Int, arg2: Bundle) {
        // TODO Auto-generated method stub

    }

    companion object {

        private val MIN_DISTANCE_CHANGE_FOR_UPDATES: Long = 10 // 10 meters
        private val MIN_TIME_BW_UPDATES = (1000 * 10 * 1).toLong() // 10 seconds
    }


}