package com.example.earthquake.repos

import android.location.Location
import com.example.earthquake.models.EarthquakeModel
import com.example.earthquake.network.NetworkService

class EarthquakeRepository {
    suspend fun fetchCurrentData(): EarthquakeModel {
        val endUrl =
            "fdsnws/event/1/query?format=geojson&starttime=2021-01-20&endtime=2022-01-20&minmagnitude=5"
        return NetworkService.earthquakeApi
            .getEarthquake(endUrl)
    }
}