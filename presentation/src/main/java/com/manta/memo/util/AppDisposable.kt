package com.manta.memo.util

import io.reactivex.disposables.Disposable

interface AppDisposable {
    fun addDisposable(d: Disposable)
    fun dispose()
}