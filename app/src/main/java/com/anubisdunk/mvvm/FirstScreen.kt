package com.anubisdunk.mvvm

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FirstScreen() {
    Box(
        modifier = Modifier.padding(8.dp)
    ) {
        Text("Welcome to my jetpack compose playground app")
    }
}

@Preview
@Composable
fun Prev() {
    FirstScreen()
    
}