package com.giovanna.events.models

data class Event(
        var people: List<Person>?,
        var date: Int,
        var description: String,
        var image: String,
        var longitude: Double,
        var latitude: Double,
        var price: Double,
        var title: String,
        var id: String,
        var cupons: List<Any>?
){
    constructor() : this(null, 0, "", "", 0.0, 0.0, 0.0, "", "", null)
}