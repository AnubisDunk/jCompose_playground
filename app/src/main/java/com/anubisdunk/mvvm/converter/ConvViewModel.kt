package com.anubisdunk.mvvm.converter

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ConvViewModel : ViewModel() {

    var mileInput by mutableStateOf("0")
    var kmInput by mutableStateOf("0")

    fun convertToKm(mile: String) {
        try {
            kmInput = (mile.toFloat() * 1.609f).toString()
        } catch (e: NumberFormatException) {
            kmInput = ""
        }

    }

    fun convertToMile(km: String) {
        try {
            mileInput = (km.toFloat() / 1.609f).toString()
        } catch (e: NumberFormatException) {

            mileInput = ""
        }
    }
}