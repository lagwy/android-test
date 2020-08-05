package com.example.workshop.ui.base

open class BasePresenterImpl<V : BaseView> : BasePresenter<V> {
    protected var mvpView: V? = null

    override fun attachView(view: V) {
        mvpView = view
    }

    override fun detachView() {
        mvpView = null
    }
}