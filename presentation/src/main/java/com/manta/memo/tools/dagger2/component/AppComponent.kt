package com.manta.memo.tools.dagger2.component

import android.app.Application
import com.manta.memo.App
import com.manta.memo.tools.dagger2.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component( modules = [
    AndroidInjectionModule::class,
    AppModule::class
])
interface AppComponent : AndroidInjector<App> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }

}