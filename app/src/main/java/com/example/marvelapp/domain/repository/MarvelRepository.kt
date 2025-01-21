package com.example.marvelapp.domain.repository

import com.example.marvelapp.data.response.MarvelCharacter
import com.example.marvelapp.data.response.MarvelResponse

interface MarvelRepository {
    suspend fun getCharacters(offset: Int, limit: Int, query: String? = null): MarvelResponse
    suspend fun getCharactersDetails(characterId: String): MarvelCharacter

}