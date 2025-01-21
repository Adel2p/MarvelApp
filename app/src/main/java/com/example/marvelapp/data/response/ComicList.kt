package com.example.marvelapp.data.response

data class ComicList(
    val available: Int, // Number of available comics
    val collectionURI: String, // URI to the list of comics
    val items: List<Comic> // List of comics
)

data class SeriesList(
    val available: Int, // Number of available series
    val collectionURI: String, // URI to the list of series
    val items: List<Series> // List of series
)

data class StoryList(
    val available: Int, // Number of available stories
    val collectionURI: String, // URI to the list of stories
    val items: List<Story> // List of stories
)

data class EventList(
    val available: Int, // Number of available events
    val collectionURI: String, // URI to the list of events
    val items: List<Event> // List of events
)
