package com.anubisdunk.mvvm.playground

data class Store(
    val id : String
)

data class DataItems(
    val items: List<Skin>
)
data class Skin (
    val name : String,
    val itemType : String,
    val creatorName : String,
    val subscriptions : Int = 0, //supplyTotalEstimated
    val storePrice : Float
)

data class Item (
    val name : String,
    val revenue : String,
    val itemType : String,
    val creatorName : String,
)