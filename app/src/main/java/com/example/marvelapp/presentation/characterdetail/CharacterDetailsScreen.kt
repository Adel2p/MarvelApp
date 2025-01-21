package com.example.marvelapp.presentation.characterdetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.marvelapp.R
import com.example.marvelapp.data.response.MarvelCharacter

@Composable
fun CharacterDetailsScreen(
    characterId: String,
    viewModel: CharacterDetailsViewModel = hiltViewModel()
) {
    LaunchedEffect(characterId) {
        viewModel.loadCharacterDetails(characterId)
    }

    val character by viewModel.characterDetails.collectAsState()

    if (character == null) {
        CircularProgressIndicator(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
        )
    } else {
        // Display character details
        CharacterDetailsContent(character = character!!)
    }
}

@Composable
fun CharacterDetailsContent(character: MarvelCharacter) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        character.thumbnail?.let { thumbnail ->
            AsyncImage(
                model = "${thumbnail.path}.${thumbnail.extension}",
                contentDescription = character.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                placeholder = painterResource(id = R.drawable.placeholder_image), // Placeholder
                error = painterResource(id = R.drawable.placeholder_image) // Error image
            )
        } ?: run {
            Image(
                painter = painterResource(id = R.drawable.placeholder_image),
                contentDescription = "Placeholder",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            )
        }

        if (!character.name.isNullOrEmpty()) {
            Text(
                text = character.name,
                style = MaterialTheme.typography.bodyLarge
            )
        } else {
            Text(
                text = "No name available.",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
            )
        }

        if (!character.description.isNullOrEmpty()) {
            Text(
                text = character.description,
                style = MaterialTheme.typography.bodyLarge
            )
        } else {
            Text(
                text = "No description available.",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
            )
        }

        if ((character.comics?.available ?: 0) > 0) {
            Text(
                text = "Comics: ${character.comics!!.available}",
                style = MaterialTheme.typography.bodyMedium
            )
        }
        if ((character.series?.available ?: 0) > 0) {
            Text(
                text = "Series: ${character.series!!.available}",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}