package com.anubisdunk.mvvm.retrofitJokes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.anubisdunk.mvvm.retrofitJokes.api.RetrofitInstance
import com.anubisdunk.mvvm.retrofitJokes.repo.JokesRepo


@Composable
fun JokesScreen() {
    val jokeApi = RetrofitInstance
        .provideApi(RetrofitInstance.provideRetrofit())
    val jokeRepo = JokesRepo(jokeApi)
    val jokesViewModel = JokesViewModel(jokeRepo)
    val jokes by jokesViewModel.jokes.collectAsState()
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn {
            items(
                items = jokes,
                key = { it.id }
            ) { item ->
                Joke(item.joke)
            }
        }
    }
    Box(modifier = Modifier.fillMaxSize()) {
        FloatingActionButton(
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.BottomEnd),

            onClick = { jokesViewModel.fetchJoke() },
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(Icons.Filled.Add, "Floating action button.")
                Text(text = jokes.size.toString())
            }

        }
    }


}

@Composable
fun Joke(joke: String) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .fillMaxWidth()
            .clickable {},
        elevation = CardDefaults.cardElevation(16.dp)
    ) {
        Text(
            modifier = Modifier
                .padding(8.dp),
            text = joke,
            textAlign = TextAlign.Center
        )
    }
}
