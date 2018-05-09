package com.mindorks.framework.mvp.ui.taxibook

import com.mindorks.framework.mvp.ui.taxibook.interactor.TaxiBookInteractor
import com.mindorks.framework.mvp.ui.taxibook.presenter.TaxiBookPresenter
import com.mindorks.framework.mvp.ui.taxidisplay.TaxiDisplayContract
import dagger.Module
import dagger.Provides

/**
 * Created by Akki on 5/8/2018.
 */
@Module
class TaxiBookModule {

    @Provides
    internal fun provideTaxiBookInteractor(taxiBookInteractor: TaxiBookInteractor): TaxiBookContract.Interactor = taxiBookInteractor

    @Provides
    internal fun provideTaxiBookPresenter(taxiBookPresenter: TaxiBookPresenter<TaxiBookContract.View, TaxiBookContract.Interactor>)
            : TaxiBookContract.Presenter<TaxiBookContract.View, TaxiBookContract.Interactor> = taxiBookPresenter
}