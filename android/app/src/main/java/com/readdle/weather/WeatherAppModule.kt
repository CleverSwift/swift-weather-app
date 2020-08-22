package com.readdle.weather

import android.app.Application
import com.readdle.weather.core.SwiftContainer
import com.readdle.weather.core.WeatherRepository
import com.readdle.weather.core.WeatherRepositoryDelegateAndroid
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object WeatherAppModule {

    fun interface WeatherRepositoryFactory {
        fun createRepository(delegate: WeatherRepositoryDelegateAndroid): WeatherRepository
    }

    @Provides
    @Singleton
    fun weatherRepositoryFactory(application: Application): WeatherRepositoryFactory {
        return WeatherRepositoryFactory {
            SwiftContainer.init(application.dataDir.absolutePath).resolve(it)
        }
    }
}