package com.anubisdunk.mvvm.skins

class SkinData : ArrayList<SkinData.SkinDataItem>(){
    data class SkinDataItem(
        val game: String,
        val image: String,
        val skin_url: String,
        val title: String
    )
}