package com.giovanna.events.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.giovanna.events.adapters.EventItemAdapter
import com.giovanna.events.R
import com.giovanna.events.models.Event
import com.giovanna.events.retrofit.ApiInitializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*


class MainActivity : AppCompatActivity() {
    private var items = ArrayList<Event>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getData()
    }

    fun getData() {
        val callback = ApiInitializer().endpoint.getEventsList()

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
                    rvEvents.layoutManager = layoutManager
                    rvEvents.adapter = EventItemAdapter(items) {
                        id -> openDetail(id)
                    }
                }
            }
        })

    }

    fun openDetail(id: String){
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("eventId", id)
        this.startActivity(intent)
    }
}