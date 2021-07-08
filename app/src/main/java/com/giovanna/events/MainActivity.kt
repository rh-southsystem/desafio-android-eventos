package com.giovanna.events

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.giovanna.events.models.Event
import com.giovanna.events.retrofit.Endpoint
import com.giovanna.events.retrofit.NetworkUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create
import java.util.*


class MainActivity : AppCompatActivity() {
    private var items = ArrayList<Event>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getData()
    }

    fun getData() {
        val retrofitClient = NetworkUtils
            .getRetrofitInstance("https://5f5a8f24d44d640016169133.mockapi.io/api/")

        val endpoint = retrofitClient.create<Endpoint>()
        val callback = endpoint.getEvents()

        callback.enqueue(object : Callback<List<Event>> {
            override fun onFailure(call: Call<List<Event>>, t: Throwable) {
                textView.text = t.message
            }

            override fun onResponse(call: Call<List<Event>>, response: Response<List<Event>>) {
                if (response.isSuccessful){

                    for (Event in response.body()!!){
                        items.add(Event)
                    }

                    val layoutManager = LinearLayoutManager(baseContext, LinearLayoutManager.VERTICAL, false)
                    val adapter = EventItemAdapter(items)
                    rvEvents.layoutManager = layoutManager
                    rvEvents.adapter = adapter
                }
            }
        })

    }
}