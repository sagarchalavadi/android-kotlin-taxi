package com.mindorks.framework.mvp.ui.taxidisplay.presenter

import android.location.Location
import com.mindorks.framework.mvp.ui.base.presenter.BasePresenter
import com.mindorks.framework.mvp.ui.taxidisplay.TaxiDisplayContract
import com.mindorks.framework.mvp.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


/**
 * Created by Akki on 5/6/2018.
 */
class TaxiDisplayPresenter<V : TaxiDisplayContract.View, I : TaxiDisplayContract.Interactor> @Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable), TaxiDisplayContract.Presenter<V, I> {

    override fun prepareTaxiList() {

        getView()?.showProgress()
        interactor?.let {
            compositeDisposable.add(it.getTaxiInArea()
                    .compose(schedulerProvider.ioToMainObservableScheduler())
                    .subscribe { taxiListResponse ->
                        getView()?.let {
                            it.hideProgress()
                            val currentlat = getView()?.getCurrentLatitude()
                            val currentLong = getView()?.getCurrentLongitude()
                            for (i in taxiListResponse?.poiList.orEmpty()) {
                                val startPoint = Location("Current Location")
                                startPoint.setLatitude(currentlat ?: 53.55)
                                startPoint.setLongitude(currentLong ?: 9.99)

                                val endPoint = Location("Taxi Location")
                                endPoint.setLatitude(i?.coordinate?.latitude ?: 0.0)
                                endPoint.setLongitude(i?.coordinate?.longitude ?: 0.0)

                                val distanceBetween = startPoint.distanceTo(endPoint) / 1000
                                i.distance = "%.2f".format(distanceBetween)
                            }
                            it.displayTaxiList(taxiListResponse?.poiList)
                        }
                    })
        }

    }

}