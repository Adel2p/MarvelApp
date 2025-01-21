package com.example.marvelapp.di

import com.example.marvelapp.data.remote.ApiService
import com.example.marvelapp.data.repo.MarvelRepositoryImpl
import com.example.marvelapp.domain.repository.MarvelRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideMarvelRepository(apiService: ApiService): MarvelRepository {
        return MarvelRepositoryImpl(apiService)
    }
}