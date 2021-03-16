package com.manta.memo.tools.dagger2.component

import android.app.Application
import com.manta.memo.App
import com.manta.memo.tools.dagger2.module.ActivityBinder
import com.manta.memo.tools.dagger2.module.AppModule
import com.manta.memo.tools.dagger2.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

/**
 * 앱 의존성 주입을 위한 컴포넌트
 */
@Singleton
@Component( modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    ActivityBinder::class,
    ViewModelModule::class
])
interface AppComponent : AndroidInjector<App> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }

}