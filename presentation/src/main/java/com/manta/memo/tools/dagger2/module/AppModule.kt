package com.manta.memo.tools.dagger2.module

import android.app.Application
import com.manta.data.repository.MainRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideRepository(context : Application) = MainRepository(context)
}