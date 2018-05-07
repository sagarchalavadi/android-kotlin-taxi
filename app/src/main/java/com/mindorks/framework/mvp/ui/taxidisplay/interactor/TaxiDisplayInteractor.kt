package com.mindorks.framework.mvp.ui.taxidisplay.interactor

import com.mindorks.framework.mvp.data.network.ApiHelper
import com.mindorks.framework.mvp.data.preferences.PreferenceHelper
import com.mindorks.framework.mvp.ui.base.interactor.BaseInteractor
import com.mindorks.framework.mvp.ui.taxidisplay.TaxiDisplayContract
import com.mindorks.framework.mvp.ui.taxidisplay.model.TaxiDisplayResponse
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Akki on 5/6/2018.
 */
class TaxiDisplayInteractor @Inject internal constructor(preferenceHelper: PreferenceHelper, apiHelper: ApiHelper): BaseInteractor(preferenceHelper = preferenceHelper,apiHelper = apiHelper), TaxiDisplayContract.Interactor {
    override fun getTaxiInArea(): Observable<TaxiDisplayResponse> {
        return apiHelper.getTaxiListApt()
    }
}
