package com.anubisdunk.mvvm.states

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.anubisdunk.mvvm.R
import kotlin.random.Random

@Composable
fun StatesScreen(
    names: List<String> = List(1000) { "$it" }
) {
    LazyColumn(
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        items(items = names) { id ->
            ItemCard(text = id, textCount = Random.nextInt(5, 25))

        }
    }
}

@Composable
fun ItemCard(
    text: String,
    textCount: Int
) {
    var extended by rememberSaveable { mutableStateOf(false) }
    val extText = getLorem(textCount)
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 24.dp,
                vertical = 8.dp
            )
            .clickable { extended = !extended }
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp),
            //horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = text,
                    style = MaterialTheme.typography.displayLarge,
                    textAlign = TextAlign.Left
                )
                Icon(
                    imageVector = if (extended) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                    contentDescription = null,

                    )
            }

            AnimatedVisibility(extended) {
                Text(
                    text = extText,
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun getLorem(
    wordCount: Int,
): String {
    val lorem: String = stringResource(R.string.lorem)
    return lorem.split(" ").joinToString(" ", limit = wordCount, truncated = "")
}

@Preview
@Composable
fun StatePrew() {
    StatesScreen()
}