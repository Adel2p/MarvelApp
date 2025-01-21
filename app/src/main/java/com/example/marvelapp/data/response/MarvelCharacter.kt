package com.example.marvelapp.data.response

data class MarvelCharacter(
    val id: Int,
    val name: String?,
    val description: String?,
    val thumbnail: Thumbnail?,
    val comics: ComicList?,
    val series: SeriesList?,
    val stories: StoryList?,
    val events: EventList?
)