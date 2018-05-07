package com.mindorks.framework.mvp.ui.taxidisplay

import com.mindorks.framework.mvp.ui.taxidisplay.interactor.TaxiDisplayInteractor
import com.mindorks.framework.mvp.ui.taxidisplay.presenter.TaxiDisplayPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by Akki on 5/6/2018.
 */

@Module
class TaxiDisplayModule {

    @Provides
    internal fun provideTaxiDisplayInteractor(taxiDisplayInteractor: TaxiDisplayInteractor): TaxiDisplayContract.Interactor = taxiDisplayInteractor

    @Provides
    internal fun provideTaxiDisplayPresenter(taxiDisplayPresenter: TaxiDisplayPresenter<TaxiDisplayContract.View, TaxiDisplayContract.Interactor>)
            : TaxiDisplayContract.Presenter<TaxiDisplayContract.View, TaxiDisplayContract.Interactor> = taxiDisplayPresenter
}

