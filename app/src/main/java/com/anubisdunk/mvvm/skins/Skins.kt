package com.anubisdunk.mvvm.skins

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.gson.Gson
import java.io.BufferedReader

@Composable
fun Skins() {
    var gson = Gson()
    val context = LocalContext.current
    fun readAsset(context: Context, fileName: String): String =
        context
            .assets
            .open(fileName)
            .bufferedReader()
            .use(BufferedReader::readText)

    var inputString = readAsset(context, "skindata.json")
    val skins = gson.fromJson(inputString, SkinData::class.java)

    LazyColumn (
        modifier = Modifier
            .fillMaxHeight()
            .padding(horizontal = 16.dp),
    ) {
        items(skins) { skin ->
            SkinComp(skin = skin)
        }
    }
}

@Composable
fun SkinComp(skin: SkinData.SkinDataItem) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 16.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
        ) {
            Text(
                text = skin.title,
                style = TextStyle(fontSize = 20.sp),
                fontWeight = FontWeight.Light
            )
            Text(
                text = skin.game,

            )
        }
    }
}