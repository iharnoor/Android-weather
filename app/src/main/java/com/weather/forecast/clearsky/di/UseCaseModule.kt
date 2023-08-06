package com.zimmy.sample.weather_compose.di

import com.weather.forecast.clearsky.repository.WeatherRepository
import com.weather.forecast.clearsky.usecase.WeatherUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
object UseCaseModule {

    @Provides
    fun providesDataUseCase(weatherRepository: WeatherRepository): WeatherUseCase {
        return WeatherUseCase(weatherRepository)
    }
}