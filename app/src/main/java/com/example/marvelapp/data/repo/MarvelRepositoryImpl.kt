package com.example.marvelapp.data.repo

import com.example.marvelapp.data.remote.ApiService
import com.example.marvelapp.data.remote.Constants.MARVEL_PUBLIC_KEY
import com.example.marvelapp.data.response.MarvelCharacter
import com.example.marvelapp.data.response.MarvelResponse
import com.example.marvelapp.domain.repository.MarvelRepository
import javax.inject.Inject

class MarvelRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : MarvelRepository {

    override suspend fun getCharacters(offset: Int, limit: Int, query: String?): MarvelResponse {
        return apiService.getCharacters(
            apiKey = MARVEL_PUBLIC_KEY,
            offset = offset,
            limit = limit,
            nameStartsWith = query
        )
    }
    override suspend fun getCharactersDetails(characterId: String): MarvelCharacter {
        return apiService.getCharacterDetails(
          characterId
        )
    }
}
