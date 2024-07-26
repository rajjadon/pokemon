package com.raj.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.raj.common.model.PokemonDetails
import com.raj.presentation.ui.component.ErrorUi
import com.raj.presentation.ui.component.HomeScreenItem
import com.raj.presentation.ui.component.LoadingUi

@Composable
fun HomeScreen(homeViewModel: HomeViewModel, onClick: () -> Unit = {}) {

    val data by homeViewModel.pokemonList.collectAsState(initial = emptyList())
    val isLoading by homeViewModel.loading.collectAsState(initial = true)
    val isError by homeViewModel.pokemonAppError.collectAsState(initial = null)
    val searchQuery = remember { mutableStateOf(TextFieldValue("")) }

    val filteredItems = if (searchQuery.value.text.isEmpty()) {
        data
    } else {
        data.filter { it.name?.contains(searchQuery.value.text, ignoreCase = true) == true }
    }

    Column(Modifier.background(color = Color.Gray)) {
        Spacer(modifier = Modifier.statusBarsPadding())
        OutlinedTextField(
            value = searchQuery.value,
            onValueChange = { query ->
                searchQuery.value = query
            },
            label = { Text("Search") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        when {
            isLoading -> LoadingUi()
            isError != null -> isError?.let { ErrorUi(pokemonAppError = it) }
            else -> LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                modifier = Modifier.padding(top = 10.dp)
            ) {
                items(filteredItems) { pokemon ->
                    HomeScreenItem(pokemon, onClick = onClick)
                }
            }
        }
    }
}