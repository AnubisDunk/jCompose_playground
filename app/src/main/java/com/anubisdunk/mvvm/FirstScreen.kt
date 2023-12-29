package com.anubisdunk.mvvm

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.anubisdunk.mvvm.ui.GameViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstScreen(
    viewModel : GameViewModel,
) {
    var text = viewModel.userInput
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = text,
        singleLine = true,
        placeholder = { Text(text = "Enter smith...") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = null
            )
        },
        onValueChange = { viewModel.userInput = it },
        label = { Text("Label") }
    )

}