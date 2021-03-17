package com.manta.memo.tools.app

import androidx.lifecycle.ViewModel
import com.manta.memo.util.AppDisposable
import com.manta.memo.util.AppDisposableImpl
import com.manta.memo.util.AppDisposableOwner

open class AppViewModel : ViewModel(), AppDisposableOwner{
    override val disposable: AppDisposable
        get() = AppDisposableImpl()

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }
}