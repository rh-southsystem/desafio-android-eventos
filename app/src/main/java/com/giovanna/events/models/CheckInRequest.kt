package com.giovanna.events.models

data class CheckInRequest (
    var eventId: String,
    var name: String,
    var email: String
){
    constructor(): this("","","")
}
