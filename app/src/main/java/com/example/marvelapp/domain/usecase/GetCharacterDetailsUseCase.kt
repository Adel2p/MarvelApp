package com.example.marvelapp.domain.usecase

import com.example.marvelapp.data.response.MarvelCharacter
import com.example.marvelapp.domain.repository.MarvelRepository
import javax.inject.Inject


class GetCharacterDetailsUseCase @Inject constructor(
    private val marvelRepository: MarvelRepository
) {
    suspend operator fun invoke(id: String): MarvelCharacter {
        return marvelRepository.getCharactersDetails(id)
    }
}