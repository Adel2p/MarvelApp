package com.example.marvelapp.presentation.characterlist

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.marvelapp.data.response.MarvelCharacter
import com.example.marvelapp.domain.usecase.GetCharactersUseCase

class CharactersPagingSource(
    private val getCharactersUseCase: GetCharactersUseCase,
    private val query: String?
) : PagingSource<Int, MarvelCharacter>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MarvelCharacter> {
        return try {
            val page = params.key ?: 0
            val response = getCharactersUseCase(
                offset = page * params.loadSize,
                limit = params.loadSize,
                query = query
            )
            LoadResult.Page(
                data = response.data.results,
                prevKey = if (page > 0) page - 1 else null,
                nextKey = if (response.data.results.isNotEmpty()) page + 1 else null
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, MarvelCharacter>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}