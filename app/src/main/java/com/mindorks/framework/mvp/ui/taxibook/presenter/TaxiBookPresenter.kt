package com.mindorks.framework.mvp.ui.taxibook.presenter

import com.mindorks.framework.mvp.ui.base.presenter.BasePresenter
import com.mindorks.framework.mvp.ui.taxibook.TaxiBookContract
import com.mindorks.framework.mvp.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by Akki on 5/8/2018.
 */
class TaxiBookPresenter<V: TaxiBookContract.View, I:TaxiBookContract.Interactor> @Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable), TaxiBookContract.Presenter<V, I> {
}