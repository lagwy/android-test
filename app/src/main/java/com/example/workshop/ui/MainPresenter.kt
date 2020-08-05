package com.example.workshop.ui

import com.example.workshop.api.Api
import com.example.workshop.api.Manager
import com.example.workshop.ui.base.BasePresenterImpl
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer

class MainPresenter : BasePresenterImpl<mView>(), Presenter {

    private var subscription: CompositeDisposable? = null

    override fun getCharacters() {
        subscription = Manager.call(
            Api.service().getCharacters(),
            onAction = Consumer {
                subscription!!.dispose()
                mvpView!!.setCharacters(it.rows!!)
            },
            onError = Consumer {
                subscription!!.dispose()
                // Error
                mvpView?.showError(it)
            }
        )
    }

}