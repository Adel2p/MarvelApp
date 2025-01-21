package com.example.marvelapp.data.remote

import com.example.marvelapp.data.remote.Constants.MARVEL_PUBLIC_KEY
import com.example.marvelapp.data.response.MarvelCharacter
import com.example.marvelapp.data.response.MarvelResponse
import com.example.marvelapp.utils.MarvelAppUtils.generateHash
import com.example.marvelapp.utils.MarvelAppUtils.getTimestamp
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("v1/public/characters")
    suspend fun getCharacters(
        @Query("apikey") apiKey: String,
        @Query("ts") timestamp: String=getTimestamp(),
        @Query("hash") hash: String=generateHash(),
        @Query("offset") offset: Int,
        @Query("limit") limit: Int,
        @Query("nameStartsWith") nameStartsWith: String? = null
    ): MarvelResponse

    @GET("v1/public/characters/{characterId}")
    suspend fun getCharacterDetails(
        @Path("characterId") characterId: String,
        @Query("apikey") apiKey: String = MARVEL_PUBLIC_KEY,
        @Query("ts") timestamp: String = getTimestamp(),
        @Query("hash") hash: String = generateHash()
    ): MarvelCharacter
}