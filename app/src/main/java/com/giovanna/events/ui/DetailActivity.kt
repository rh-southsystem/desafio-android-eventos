package com.giovanna.events.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.giovanna.events.R
import com.giovanna.events.models.Event
import com.giovanna.events.retrofit.ApiInitializer
import kotlinx.android.synthetic.main.activity_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivity: AppCompatActivity() {

    var eventId = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        eventId = intent.getStringExtra("eventId")!!

        getEventData(eventId)
    }

    fun getEventData(id: String) {
        val callback = ApiInitializer().endpoint.getEvent(id)

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