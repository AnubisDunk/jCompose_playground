package com.anubisdunk.mvvm.playground

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlaygroundScreen(
    modifier: Modifier = Modifier,
    viewModel: PlaygroundScreenViewModel = viewModel(),
    onUserItemChanged : (String) -> Unit = {viewModel.updateUserItem(it)},
    addItem : (String) -> Unit = {viewModel.addItem(it)},
    item : String = viewModel.item,
    items : List<String> = viewModel.items
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(
                modifier = Modifier.weight(1f),
                value = item,
                onValueChange = {onUserItemChanged(it)}
            )
            Button(onClick = {
                addItem(item)
            }) {
                Text(text = "Click me")
            }
        }
        LazyColumn {
            items(items) { item ->
                Text(text = item)
            }
        }
    }
}

@Preview
@Composable
fun PlaygroundScreenPrev(

) {
    PlaygroundScreen()
}