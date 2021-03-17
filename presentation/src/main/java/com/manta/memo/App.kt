package com.manta.memo

import com.manta.memo.tools.dagger2.component.DaggerAppComponent
import com.manta.memo.util.AppContext
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class App : DaggerApplication() {

    val applicationInjector by lazy{
        DaggerAppComponent.factory().create(this)
    }
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return applicationInjector
    }

    override fun onCreate() {
        super.onCreate()
        AppContext.context = applicationContext
    }



}