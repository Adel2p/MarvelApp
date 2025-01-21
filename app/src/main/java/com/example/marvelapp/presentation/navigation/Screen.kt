package com.example.marvelapp.presentation.navigation


sealed class Screen(val route: String) {
    data object CharacterList : Screen("characterList")
    data object CharacterDetails : Screen("characterDetails/{characterId}") {
        fun createRoute(characterId: String) = "characterDetails/$characterId"
    }
}