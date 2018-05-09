package com.mindorks.framework.mvp.ui.taxibook

import com.mindorks.framework.mvp.ui.base.interactor.MVPInteractor
import com.mindorks.framework.mvp.ui.base.presenter.MVPPresenter
import com.mindorks.framework.mvp.ui.base.view.MVPView

/**
 * Created by Akki on 5/8/2018.
 */
class TaxiBookContract {
    interface View : MVPView {
    }

    interface Presenter<V : View, I : Interactor> : MVPPresenter<V, I> {
    }

    interface Interactor : MVPInteractor {
    }
}