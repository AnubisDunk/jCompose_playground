package com.anubisdunk.mvvm.retrofitJokes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun JokesScreen(viewModel: JokesViewModel) {

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = viewModel.jokeState)
        Button(
            onClick = { viewModel.fetchJoke() }
        ) {
            Text(text = "Fetch joke")
        }
    }


}