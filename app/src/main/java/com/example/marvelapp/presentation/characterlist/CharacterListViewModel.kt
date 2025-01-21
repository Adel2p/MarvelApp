package com.example.marvelapp.presentation.characterlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.marvelapp.data.response.MarvelCharacter
import com.example.marvelapp.domain.usecase.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
) : ViewModel() {

    private val _characters = MutableStateFlow<PagingData<MarvelCharacter>>(PagingData.empty())
    val characters: StateFlow<PagingData<MarvelCharacter>> = _characters
    fun loadCharacters(query: String? = null) {
        viewModelScope.launch {
            Pager(
                config = PagingConfig(pageSize = 20),
                pagingSourceFactory = {
                    CharactersPagingSource(getCharactersUseCase, query?.takeIf { it.isNotBlank() })
                }
            ).flow.collectLatest { pagingData ->
                _characters.value = pagingData
            }
        }
    }
}