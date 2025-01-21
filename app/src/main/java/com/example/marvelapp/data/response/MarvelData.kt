package com.example.marvelapp.data.response

data class MarvelData(
    val offset: Int, // Offset of the results
    val limit: Int, // Maximum number of results returned
    val total: Int, // Total number of results available
    val count: Int, // Number of results returned in this response
    val results: List<MarvelCharacter> // List of characters
)
