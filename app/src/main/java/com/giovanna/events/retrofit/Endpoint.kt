package com.giovanna.events.retrofit

import com.giovanna.events.models.Event
import retrofit2.Call
import retrofit2.http.GET

interface Endpoint {

    @GET("events/")
    fun getEvents() : Call<List<Event>>
}
