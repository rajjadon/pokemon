package com.raj.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raj.presentation.ui.component.ErrorUi
import com.raj.presentation.ui.component.HomeScreenItem
import com.raj.presentation.ui.component.LoadingUi

@Composable
fun HomeScreen(homeViewModel: HomeViewModel, onClick: (String) -> Unit = {}) {
    val data by homeViewModel.pokemonList.collectAsState(initial = emptyList())
    val isLoading by homeViewModel.loading.collectAsState(initial = true)
    val isError by homeViewModel.pokemonAppError.collectAsState(initial = null)
    val searchQuery = remember { mutableStateOf(TextFieldValue("")) }
    val sortCriterion = remember { mutableStateOf("Name") }
    val sortOptions = listOf("Name", "Hp")

    val filteredItems = if (searchQuery.value.text.isEmpty()) {
        data
    } else {
        data.filter { it.name?.contains(searchQuery.value.text, ignoreCase = true) == true }
    }.let { list ->
        when (sortCriterion.value) {
            "Name" -> list.sortedBy { it.name }
            "Hp" -> list.sortedBy { it.hp }
            else -> list
        }
    }

    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.background)
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.statusBarsPadding())
        OutlinedTextField(
            value = searchQuery.value,
            onValueChange = { query ->
                searchQuery.value = query
            },
            label = { Text("Search") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = MaterialTheme.colorScheme.onBackground,
                focusedContainerColor = MaterialTheme.colorScheme.surface,
                cursorColor = MaterialTheme.colorScheme.onBackground,
                focusedBorderColor = MaterialTheme.colorScheme.onBackground,
                unfocusedBorderColor = MaterialTheme.colorScheme.onBackground,
                focusedLabelColor = MaterialTheme.colorScheme.onBackground,
                unfocusedLabelColor = MaterialTheme.colorScheme.onBackground
            )
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Sort by: ",
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 20.sp,
                modifier = Modifier.padding(end = 8.dp)
            )
            var expanded by remember { mutableStateOf(false) }
            Box {
                TextButton(onClick = { expanded = true }) {
                    Text(text = sortCriterion.value, color = MaterialTheme.colorScheme.onBackground, textAlign = TextAlign.Start)
                }
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    sortOptions.forEach { option ->
                        DropdownMenuItem(
                            text = { Text(text = option) },
                            onClick = {
                                sortCriterion.value = option
                                expanded = false
                            })
                    }
                }
            }
        }

        when {
            isLoading -> LoadingUi()
            isError != null -> isError?.let { ErrorUi(it) }
            else -> LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.padding(top = 10.dp)
            ) {
                items(filteredItems) { pokemon ->
                    HomeScreenItem(pokemon, onClick = {
                        onClick.invoke(pokemon.id)
                    })
                }
            }
        }
    }
}