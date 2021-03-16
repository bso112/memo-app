package com.manta.memo.tools.dagger2.module

import com.manta.memo.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Activity 의존성 주입을 위한 모듈
 */
@Module
abstract class ActivityBinder {

    @ContributesAndroidInjector(modules = [ViewModelFactoryModule::class])
    /**
     * 리턴타입을 통해 AndroidInjector를 생성한다. 이때 의존성주입에 ViewModelFactoryModule를 이용한다.
     *  @Subcomponent(modules = ViewModelFactoryModule.class)
        public interface MainActivitySubcomponent extends AndroidInjector<MainActivity> {
        @Subcomponent.Factory
        interface Factory extends AndroidInjector.Factory<MainActivity> {}
    }
     이런 코드가 생성된다.

     */
    abstract fun mainActivity() : MainActivity
}