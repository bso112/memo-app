package com.manta.memo.tools.app

import com.manta.memo.util.AppDisposable
import com.manta.memo.util.AppDisposableImpl
import com.manta.memo.util.AppDisposableOwner
import dagger.android.support.DaggerAppCompatActivity

open class AppActivity : DaggerAppCompatActivity(), AppDisposableOwner {

    override val disposable: AppDisposable = AppDisposableImpl()

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }
}