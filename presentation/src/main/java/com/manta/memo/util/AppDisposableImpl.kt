package com.manta.memo.util

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class AppDisposableImpl : AppDisposable {
    private val disposables: CompositeDisposable = CompositeDisposable()
    override fun addDisposable(d: Disposable) {
        disposables.add(d)
    }

    override fun dispose() {
        disposables.dispose()
    }
}