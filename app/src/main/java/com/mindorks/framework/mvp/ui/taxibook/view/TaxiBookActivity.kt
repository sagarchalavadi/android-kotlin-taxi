package com.mindorks.framework.mvp.ui.taxibook.view

import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.mindorks.framework.mvp.R
import com.mindorks.framework.mvp.ui.base.view.BaseActivity
import com.mindorks.framework.mvp.ui.taxibook.TaxiBookContract
import javax.inject.Inject

/**
 * Created by Akki on 5/8/2018.
 */
class TaxiBookActivity : BaseActivity(), TaxiBookContract.View, OnMapReadyCallback {


    @Inject
    internal lateinit var presenter: TaxiBookContract.Presenter<TaxiBookContract.View, TaxiBookContract.Interactor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_taxi_book)
        presenter.onAttach(this)
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }

    override fun onMapReady(googleMap: GoogleMap?) {
        val sydney = LatLng(53.692736863132225, 10.004888375873337)
        val sydney1 = LatLng(53.6638, 10.0032)
        val sydney2 = LatLng(53.687600764102086, 9.929525260061004)

        val cameraPosition = CameraPosition.Builder()
                .target(sydney1)
                .zoom(10f
                ).build()

        googleMap?.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        googleMap?.addMarker(MarkerOptions().position(sydney1).title("hmmmm"))
        googleMap?.addMarker(MarkerOptions().position(sydney2).title("Loda"))
        googleMap?.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))
    }






    override fun onFragmentAttached() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFragmentDetached(tag: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}