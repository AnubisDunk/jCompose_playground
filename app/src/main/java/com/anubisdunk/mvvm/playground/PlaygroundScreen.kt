package com.anubisdunk.mvvm.playground

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage

@Composable
fun PlaygroundScreen(
    modifier: Modifier = Modifier,
    viewModel: PlaygroundScreenViewModel = viewModel(),
    items: State<List<Item>> = viewModel.items.collectAsState()
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //StoreSelect()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { viewModel.cycleStore(true) }) {
                Text(text = "Next")
            }
            Button(onClick = { viewModel.cycleStore(false) }) {
                Text(text = "Previous")
            }
        }
        Text(text = "Current store: ${viewModel.storeId}")
        if (items.value.isEmpty()) {
            CircularProgressIndicator(
                modifier = Modifier.width(64.dp),
                color = MaterialTheme.colorScheme.secondary,
            )
        } else {
            LazyColumn {
                items(items.value) { item ->
                    SkinItem(
                        text = item.name,
                        author = item.creatorName,
                        revenue = item.revenue,
                        image = item.iconUrl
                    )
                }
            }
        }
    }
}

@Composable
fun SkinItem(
    text: String,
    author: String,
    revenue: String,
    image: String
) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(
                onClick = { expanded = !expanded }
            )
    ) {
        val style = MaterialTheme.typography.bodyLarge
        var resizedTextStyle by remember {
            mutableStateOf(style)
        }
        Column {
            Text(
                text = "$text --> $revenue EUR ",
                style = resizedTextStyle,
                softWrap = false,
                onTextLayout = { result ->
                    if (result.didOverflowWidth) {
                        resizedTextStyle =
                            resizedTextStyle.copy(fontSize = resizedTextStyle.fontSize * 0.95)
                    }
                },
                modifier = Modifier
                    .padding(8.dp)
            )
            AnimatedVisibility(expanded) {
                AsyncImage(
                    model = image,
                    contentDescription = "skin image"
                )
                Text(
                    text = "by $author",
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
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