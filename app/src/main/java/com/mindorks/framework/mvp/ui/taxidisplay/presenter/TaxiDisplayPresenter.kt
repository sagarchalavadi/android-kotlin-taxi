package com.mindorks.framework.mvp.ui.taxidisplay.presenter

import com.mindorks.framework.mvp.ui.base.presenter.BasePresenter
import com.mindorks.framework.mvp.ui.taxidisplay.TaxiDisplayContract
import com.mindorks.framework.mvp.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by Akki on 5/6/2018.
 */
class TaxiDisplayPresenter<V:TaxiDisplayContract.View, I:TaxiDisplayContract.Interactor> @Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable), TaxiDisplayContract.Presenter<V, I> {

    override fun prepareTaxiList() {

         getView()?.showProgress()
        interactor?.let {
            compositeDisposable.add(it.getTaxiInArea()
                    .compose(schedulerProvider.ioToMainObservableScheduler())
                    .subscribe { taxiListResponse ->
                        getView()?.let {
                            it.hideProgress()
                            it.displayTaxiList(taxiListResponse?.poiList)
                        }
                    })
        }

    }

}