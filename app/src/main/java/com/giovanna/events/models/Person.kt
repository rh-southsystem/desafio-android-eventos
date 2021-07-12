package com.giovanna.events.models

data class Person (
    var id: String,
    var eventId: String,
    var name: String,
    var picture: String
){
    constructor() : this("", "", "", "")
}