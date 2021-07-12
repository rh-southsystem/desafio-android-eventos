package com.giovanna.events.retrofit

import com.giovanna.events.Settings
import retrofit2.create

class ApiInitializer {

    val retrofitClient = NetworkUtils
        .getRetrofitInstance(Settings().API_BASE_URL)

    val endpoint = retrofitClient.create<ApiFunctions>()
}