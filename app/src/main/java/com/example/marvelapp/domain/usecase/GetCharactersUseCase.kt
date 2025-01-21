package com.example.marvelapp.domain.usecase

import com.example.marvelapp.data.response.MarvelResponse
import com.example.marvelapp.domain.repository.MarvelRepository
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val marvelRepository: MarvelRepository
) {
    suspend operator fun invoke(offset: Int, limit: Int, query: String? = null): MarvelResponse {
        return marvelRepository.getCharacters(offset, limit, query)
    }
}