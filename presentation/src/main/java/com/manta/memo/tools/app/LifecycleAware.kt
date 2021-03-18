package com.manta.memo.tools.app

import androidx.lifecycle.LifecycleOwner

interface LifecycleAware : AppLifecycleObserver {
    fun addLifecyclerOwner(lifecyclerOwner : LifecycleOwner)

}