package com.weather.forecast.clearsky.di

import com.weather.forecast.clearsky.network.WeatherApiService
import com.weather.forecast.clearsky.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
object DataRepositoryModule {

    @Provides
    fun provideDataRepository(weatherApiService: WeatherApiService): WeatherRepository {
        return WeatherRepository(weatherApiService)
    }
}