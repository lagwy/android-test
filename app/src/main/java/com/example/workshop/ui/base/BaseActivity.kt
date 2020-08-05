package com.example.workshop.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

@Suppress("UNCHECKED_CAST")
abstract class BaseActivity<in V: BaseView, T: BasePresenter<V>> : AppCompatActivity(), BaseView {

    protected abstract var presenter: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.attachView(this as V)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

    override fun logError(error: String) {

    }

    override fun logError(stringResId: Int) {

    }

    override fun logMessage(stringResId: Int) {

    }

    override fun logMessage(message: String) {

    }

}