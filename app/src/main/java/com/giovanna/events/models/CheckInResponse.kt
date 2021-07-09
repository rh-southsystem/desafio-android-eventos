package com.giovanna.events.models

data class CheckInResponse (
    var eventId: String,
    var name: String,
    var email: String
){
    constructor(): this("","","")
}
