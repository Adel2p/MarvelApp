package com.example.marvelapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.marvelapp.presentation.characterdetail.CharacterDetailsScreen
import com.example.marvelapp.presentation.characterlist.CharacterListScreen
import com.example.marvelapp.presentation.navigation.Screen
import com.example.marvelapp.ui.theme.MarvelAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MarvelAppTheme {
                val navController = rememberNavController()
                AppNavigation(navController = navController)
            }
        }
    }
}

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.CharacterList.route // Use Screen.CharacterList.route
    ) {
        composable(Screen.CharacterList.route) {
            CharacterListScreen(onCharacterClick = { character ->
                navController.navigate(Screen.CharacterDetails.createRoute(character.id.toString()))
            })
        }

        composable("characterDetails/{characterId}") { backStackEntry ->
            val characterId = backStackEntry.arguments?.getString("characterId")
            if (characterId != null) {
                CharacterDetailsScreen(characterId = characterId)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MarvelAppTheme {
        // Preview for CharacterListScreen
        CharacterListScreen(onCharacterClick = { character ->
            // Handle character click in preview
        })
    }
}