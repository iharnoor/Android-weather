package com.weather.forecast.clearsky.usecase

import com.weather.forecast.clearsky.model.WeatherModel
import com.weather.forecast.clearsky.repository.WeatherRepository
import com.weather.forecast.clearsky.network.ResultData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WeatherUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository
) {
    fun getWeatherData(city: String): Flow<ResultData<WeatherModel>> {
        return flow {
            emit(ResultData.Loading)

            val weatherModel = weatherRepository.getWeatherData(city)

            val resultData = if (weatherModel == null) {
                ResultData.Failed()
            } else {
                ResultData.Success(weatherModel)
            }
            emit(resultData)
        }.catch {
            emit(ResultData.Failed())
        }
    }
}