package com.example.marvelapp.presentation.characterdetail


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelapp.data.response.MarvelCharacter
import com.example.marvelapp.domain.usecase.GetCharacterDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailsViewModel @Inject constructor(
    private val getCharacterDetailsUseCase: GetCharacterDetailsUseCase
) : ViewModel() {

    private val _characterDetails = MutableStateFlow<MarvelCharacter?>(null)
    val characterDetails: StateFlow<MarvelCharacter?> get() = _characterDetails


    fun loadCharacterDetails(characterId: String) {
        viewModelScope.launch {
            val character = getCharacterDetailsUseCase(characterId)
            _characterDetails.value = character
        }
    }
}