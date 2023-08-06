package com.weather.forecast.clearsky.repository

import com.weather.forecast.clearsky.model.WeatherModel
import com.weather.forecast.clearsky.network.WeatherApiService
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val weatherApiService: WeatherApiService) {
    suspend fun getWeatherData(city:String): WeatherModel? {
        return weatherApiService.getWeatherData(city)
    }
}