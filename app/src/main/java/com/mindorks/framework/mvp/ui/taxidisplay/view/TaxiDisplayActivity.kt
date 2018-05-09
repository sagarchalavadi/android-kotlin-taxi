package com.mindorks.framework.mvp.ui.taxidisplay.view
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.google.android.gms.maps.model.LatLng
import com.mindorks.framework.mvp.R
import com.mindorks.framework.mvp.ui.base.GPSTrackerService
import com.mindorks.framework.mvp.ui.base.view.BaseActivity
import com.mindorks.framework.mvp.ui.taxibook.view.TaxiBookActivity
import com.mindorks.framework.mvp.ui.taxidisplay.OnTaxiSelect
import com.mindorks.framework.mvp.ui.taxidisplay.TaxiDisplayAdapter
import com.mindorks.framework.mvp.ui.taxidisplay.TaxiDisplayContract
import com.mindorks.framework.mvp.ui.taxidisplay.model.PoiList
import javax.inject.Inject
import kotlinx.android.synthetic.main.activity_taxi_display.*


/**
 * Created by Akki on 5/6/2018.
 */
class TaxiDisplayActivity : BaseActivity(), TaxiDisplayContract.View,OnTaxiSelect{


    override fun getCurrentLatitude(): Double {
        var lat= service.getLatitude()
        return lat
    }

    override fun getCurrentLongitude(): Double {
        var long = service.getLongitude()
        return long
    }



    protected lateinit var service:GPSTrackerService

    @Inject
    internal lateinit var presenter: TaxiDisplayContract.Presenter<TaxiDisplayContract.View, TaxiDisplayContract.Interactor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_taxi_display)
        service= GPSTrackerService(this)
        presenter.onAttach(this)
        presenter.prepareTaxiList()
        recycler_view.layoutManager = LinearLayoutManager(this)
    }

    override fun displayTaxiList(list: List<PoiList>?) {
        var listener:OnTaxiSelect
        recycler_view.adapter = TaxiDisplayAdapter(list,this)
    }



    override fun onFragmentAttached() {
    }

    override fun onFragmentDetached(tag: String) {
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

    override fun onCallback(position:Int){
        val intent = Intent(this, TaxiBookActivity::class.java)
        startActivity(intent)
    }

}