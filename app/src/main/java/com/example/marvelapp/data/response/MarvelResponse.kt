package com.example.marvelapp.data.response

data class MarvelResponse(
    val code: Int, // HTTP status code
    val status: String, // HTTP status message
    val data: MarvelData // Contains the actual data
)