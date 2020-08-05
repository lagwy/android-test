package com.example.workshop.api

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class Manager {

    companion object {

        fun <T> call(observable: Observable<T>,
                     onAction: Consumer<in T>,
                     onError: Consumer<Throwable>
                     ): CompositeDisposable {
            val compositeDisposable = CompositeDisposable()
            compositeDisposable.add(observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onAction, onError))
            return compositeDisposable
        }

    }

}