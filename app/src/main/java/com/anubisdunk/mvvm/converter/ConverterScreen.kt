package com.anubisdunk.mvvm.converter

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConverterScreen() {
    val viewModel = viewModel<ConvViewModel>()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Convert km to miles",
            fontSize = 32.sp
        )
        Box(
            modifier = Modifier
                .align(Alignment.Start)
        ) {
            Text(
                text = "Mile"
            )
        }

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = viewModel.mileInput,
            onValueChange = {
                viewModel.mileInput = it
                viewModel.convertToKm(it)
                            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            label = { Text(text = "Enter miles") },
            singleLine = true,
        )
        Box(
            modifier = Modifier
                .align(Alignment.Start)
        ) {
            Text(
                text = "KM"
            )
        }
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = viewModel.kmInput,
            onValueChange = {
                viewModel.kmInput = it
                viewModel.convertToMile(it)
                            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            label = { Text(text = "Enter km") },
            singleLine = true,
        )
    }
}