package com.raj.presentation.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.raj.common.model.PokemonDetails

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun PokemonDetailsScreen(pokemonDetailsViewModel: PokemonDetailsViewModel) {
    val pokemon = pokemonDetailsViewModel.pokemonDetails.collectAsState(initial = null).value

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Box(contentAlignment = Alignment.BottomEnd, modifier = Modifier.fillMaxWidth()) {
                val image = pokemon?.image?.large ?: pokemon?.image?.small ?: Icons.Default.Face
                GlideImage(
                    model = image,
                    contentDescription = "pokemon banner",
                    modifier = Modifier
                        .height(300.dp)
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            pokemon?.name?.let {
                Text(
                    text = it,
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.headlineSmall.copy(
                        color = MaterialTheme.colorScheme.onBackground,
                        fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
                    )
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
        }

        item {
            pokemon?.type?.joinToString(separator = ", ")?.let {
                Text(
                    text = "Type: $it",
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = MaterialTheme.colorScheme.onBackground,
                        fontSize = 18.sp
                    )
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
        }

        item {
            pokemon?.level?.let {
                Text(
                    text = "Level: $it",
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = MaterialTheme.colorScheme.onBackground,
                        fontSize = 18.sp
                    )
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
        }

        item {
            pokemon?.hp?.let {
                Text(
                    text = "HP: $it",
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = MaterialTheme.colorScheme.onBackground,
                        fontSize = 18.sp
                    )
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
        }

        item {
            pokemon?.attack?.joinToString(separator = ", ")?.let {
                Text(
                    text = "Attacks: $it",
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = MaterialTheme.colorScheme.onBackground,
                        fontSize = 18.sp
                    )
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
        }

        item {
            pokemon?.weakness?.joinToString(separator = ", ")?.let {
                Text(
                    text = "Weaknesses: $it",
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = MaterialTheme.colorScheme.onBackground,
                        fontSize = 18.sp
                    )
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
        }

        item {
            pokemon?.ability?.joinToString(separator = ", ")?.let {
                Text(
                    text = "Abilities: $it",
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = MaterialTheme.colorScheme.onBackground,
                        fontSize = 18.sp
                    )
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
        }

        item {
            pokemon?.resistances?.joinToString(separator = ", ")?.let {
                Text(
                    text = "Resistances: $it",
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = MaterialTheme.colorScheme.onBackground,
                        fontSize = 18.sp
                    )
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}