package com.mindorks.framework.mvp.ui.taxidisplay

import com.google.android.gms.maps.model.LatLng
import com.mindorks.framework.mvp.ui.base.interactor.MVPInteractor
import com.mindorks.framework.mvp.ui.base.presenter.MVPPresenter
import com.mindorks.framework.mvp.ui.base.view.MVPView
import com.mindorks.framework.mvp.ui.taxidisplay.model.PoiList
import com.mindorks.framework.mvp.ui.taxidisplay.model.TaxiDisplayResponse
import io.reactivex.Observable

/**
 * Created by Akki on 5/6/2018.
 */
class TaxiDisplayContract {

    interface View : MVPView {
        fun displayTaxiList(list:List<PoiList>?)
        fun getCurrentLatitude():Double
        fun getCurrentLongitude():Double
    }

    interface Presenter<V : View, I : Interactor> : MVPPresenter<V, I> {
        fun prepareTaxiList()
    }

    interface Interactor : MVPInteractor {
        fun getTaxiInArea(): Observable<TaxiDisplayResponse>
    }

}