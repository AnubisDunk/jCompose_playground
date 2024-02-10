package com.anubisdunk.mvvm.playground

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun PlaygroundScreen(
    modifier: Modifier = Modifier,
    viewModel: PlaygroundScreenViewModel = viewModel<PlaygroundScreenViewModel>()
) {
    var count by remember{mutableStateOf(0)}
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = count.toString(),
            fontSize = 36.sp
        )
        Spacer(modifier)
        Button(onClick = { count++ }) {
            Text(text = "Click me")
        }
    }
}

@Preview
@Composable
fun PlaygroundScreenPrev(

) {
    PlaygroundScreen()
}