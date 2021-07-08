package com.giovanna.events.retrofit

import com.giovanna.events.models.Event
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Endpoint {

    @GET("events/")
    fun getEventsList() : Call<List<Event>>

    @GET("events/{id}")
    fun getEvent(
        @Path("id") id: String
    ) : Call<Event>
}
