package com.mindorks.framework.mvp.ui.taxibook.interactor

import com.mindorks.framework.mvp.data.network.ApiHelper
import com.mindorks.framework.mvp.data.preferences.PreferenceHelper
import com.mindorks.framework.mvp.ui.base.interactor.BaseInteractor
import com.mindorks.framework.mvp.ui.taxibook.TaxiBookContract
import javax.inject.Inject

/**
 * Created by Akki on 5/8/2018.
 */
class TaxiBookInteractor @Inject internal constructor(preferenceHelper: PreferenceHelper, apiHelper: ApiHelper): BaseInteractor(preferenceHelper = preferenceHelper,apiHelper = apiHelper), TaxiBookContract.Interactor {
}