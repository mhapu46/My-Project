package com.example.weatherappfinal.repository

import android.location.Location
import com.example.weatherappfinal.NetworkService
import com.example.weatherappfinal.models.CurrentModel
import com.example.weatherappfinal.models.ForecastModel
import com.example.weatherappfinal.weather_api_key

class WeatherRepository {
    suspend fun fetchCurrentData(location: Location, status: Boolean): CurrentModel {
        val unit = if (status) "imperial" else "metric"
        val endUrl = "weather?lat=${location.latitude}" +
                "&lon=${location.longitude}" +
                "&units=$unit" +
                "&appid=${weather_api_key}"
        return NetworkService.weatherServiceApi
            .getCurrentWeather(endUrl)
    }
    suspend fun fetchForecastData(location: Location, status: Boolean): ForecastModel {
        val unit = if (status) "imperial" else "metric"
        val endUrl = "forecast?lat=${location.latitude}" +
                "&lon=${location.longitude}" +
                "&units=$unit" +
                "&appid=${weather_api_key}"
        return NetworkService.weatherServiceApi
            .getForecastWeather(endUrl)
    }
}