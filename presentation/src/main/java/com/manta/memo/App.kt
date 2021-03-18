package com.manta.memo

import android.app.Application
import com.manta.memo.tools.dagger2.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class App : DaggerApplication() {

    companion object{
        lateinit var context : Application
            private set
    }
    val applicationInjector by lazy{
        DaggerAppComponent.factory().create(this)
    }
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return applicationInjector
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }



}