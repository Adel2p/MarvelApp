package com.example.marvelapp.di

import com.example.marvelapp.domain.repository.MarvelRepository
import com.example.marvelapp.domain.usecase.GetCharacterDetailsUseCase
import com.example.marvelapp.domain.usecase.GetCharactersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetCharactersUseCase(marvelRepository: MarvelRepository): GetCharactersUseCase {
        return GetCharactersUseCase(marvelRepository)
    }

    @Provides
    @Singleton
    fun provideGetCharacterDetailsUseCase(marvelRepository: MarvelRepository): GetCharacterDetailsUseCase {
        return GetCharacterDetailsUseCase(marvelRepository)
    }


}