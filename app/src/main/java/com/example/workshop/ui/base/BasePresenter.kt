package com.example.workshop.ui.base

interface BasePresenter<in V : BaseView> {

    fun attachView(view: V)

    fun detachView()
}