package com.manta.memo.tools.app

import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

fun <T> Single<T>.subscribeOnBackground()= run {
    subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}


fun Completable.subscribeOnBackground() = run {
    subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}
