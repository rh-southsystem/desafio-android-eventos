package com.giovanna.events.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import com.giovanna.events.R
import com.giovanna.events.models.CheckInRequest
import com.giovanna.events.models.CheckInResponse
import com.giovanna.events.models.Event
import com.giovanna.events.retrofit.ApiInitializer
import com.giovanna.events.util.Utils
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

        setTitle("Detalhes do evento " + eventId)

        loading.visibility = View.VISIBLE
        content.visibility = View.GONE

        getEventData(eventId)
    }

    fun getEventData(id: String) {
        val callback = ApiInitializer().endpoint.getEvent(id)

        callback.enqueue(object : Callback<Event> {
            override fun onFailure(call: Call<Event>, t: Throwable) {
                loading.visibility = View.GONE

                showAlertDialog("Erro", t.message.toString())
            }

            override fun onResponse(call: Call<Event>, response: Response<Event>) {
                loading.visibility = View.GONE

                if (response.isSuccessful){
                    content.visibility = View.VISIBLE

                    tvDetailTitle.text = response.body()!!.title
                    tvDetailDate.text = response.body()!!.date.toString()
                    (response.body()!!.latitude.toString() + ", " +  response.body()!!.longitude.toString()).also { tvDetailLocation.text = it }
                    tvDetailPrice.text = response.body()!!.price.toString()
                    tvDetailDescription.text = response.body()!!.description

                    buttonCheckin.setOnClickListener {
                        val checkin = CheckInRequest()
                        checkin.email = "email@gmail.com"
                        checkin.eventId = eventId
                        checkin.name = "Nome"
                        doCheckIn(checkin)
                    }

                    buttonShare.setOnClickListener {
                        share(response.body()!!.title)
                    }
                }
                else
                    showAlertDialog("Erro", response.message())
            }
        })

    }

    fun showAlertDialog(title: String, message: String){
        Utils().showAlert(this, title, message)
    }

    fun doCheckIn(checkInRequest: CheckInRequest){
        val callback = ApiInitializer().endpoint.checkin(checkInRequest)

        callback.enqueue(object : Callback<CheckInResponse> {
            override fun onFailure(call: Call<CheckInResponse>, t: Throwable) {
                showAlertDialog("Erro", t.message.toString())
            }

            override fun onResponse(call: Call<CheckInResponse>, response: Response<CheckInResponse>) {

                if (response.isSuccessful){
                    showAlertDialog("CheckIn", response.body().toString())
                }
                else
                    showAlertDialog("Erro", response.message())
            }
        })
    }

    fun share(content: String){
        val shareIntent = Intent()
        shareIntent.action = Intent.ACTION_SEND
        shareIntent.type="text/plain"
        shareIntent.putExtra(Intent.EXTRA_TEXT, content);
        startActivity(Intent.createChooser(shareIntent, "Share"))
    }


}