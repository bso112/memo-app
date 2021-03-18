package com.manta.memo.tools.app

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

interface AppLifecycleObserver : LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onOwnerResume()

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onOwnerPause()

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onOwnerDestroy()
}