package com.raj.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.raj.presentation.ui.component.HomeScreenItem
import com.raj.presentation.ui.component.LoadingUi

@Composable
fun HomeScreen(homeViewModel: HomeViewModel) {

    val data =
        homeViewModel.pokemonList.collectAsState(initial = emptyList()).value

    val isLoading = homeViewModel.loading.collectAsState(initial = false)

    Column(Modifier.background(color = Color.Gray)) {
        Spacer(modifier = Modifier.statusBarsPadding())
        var text by remember { mutableStateOf("") }
        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Search") },
            modifier = Modifier
                .fillMaxWidth()
        )

        if (isLoading.value)
            LoadingUi()
        else
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                modifier = Modifier.padding(top = 10.dp)
            ) {
                items(data.size) { position ->
                    val pokemon = data[position]
                    HomeScreenItem(pokemon)
                }
            }
    }
}