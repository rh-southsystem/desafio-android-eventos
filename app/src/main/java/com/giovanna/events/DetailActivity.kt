package com.giovanna.events

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.giovanna.events.models.Event
import com.giovanna.events.retrofit.Endpoint
import com.giovanna.events.retrofit.NetworkUtils
import kotlinx.android.synthetic.main.activity_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class DetailActivity: AppCompatActivity() {

    var eventId = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        eventId = intent.getStringExtra("eventId")!!

        getEventData(eventId)
    }

    fun getEventData(id: String) {
        val retrofitClient = NetworkUtils
            .getRetrofitInstance("https://5f5a8f24d44d640016169133.mockapi.io/api/")

        val endpoint = retrofitClient.create<Endpoint>()
        val callback = endpoint.getEvent(id)

        callback.enqueue(object : Callback<Event> {
            override fun onFailure(call: Call<Event>, t: Throwable) {
                tvDetailTitle.text = t.message
            }

            override fun onResponse(call: Call<Event>, response: Response<Event>) {
                if (response.isSuccessful){
                    tvDetailTitle.text = response.body()!!.description
                }
            }
        })

    }


}