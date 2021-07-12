package com.giovanna.events.retrofit

import com.giovanna.events.models.CheckInRequest
import com.giovanna.events.models.CheckInResponse
import com.giovanna.events.models.Event
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiFunctions {

    @GET("events/")
    fun getEventsList() : Call<List<Event>>

    @GET("events/{id}")
    fun getEvent(
        @Path("id") id: String
    ) : Call<Event>

    @POST("checkin/")
    fun checkin(
        @Body model: CheckInRequest
    ): Call<CheckInResponse>
}
