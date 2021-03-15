package com.manta.memo.tools.dagger2

import android.app.Application
import com.manta.data.repository.MainRepository
import dagger.Provides
import javax.inject.Singleton

class AppModule {

    @Provides
    @Singleton
    fun provideRepository(context : Application) = MainRepository(context)
}