package com.ucb.ucbtest.sendSIMUI

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SendSimViewModel : ViewModel() {
    private val _referencePhone = mutableStateOf("")
    val referencePhone: State<String> = _referencePhone

    private val _latitude = mutableStateOf("")
    val latitude: State<String> = _latitude

    private val _longitude = mutableStateOf("")
    val longitude: State<String> = _longitude

    fun updatePhone(value: String) {
        _referencePhone.value = value
    }

    fun updateCoordinates(
        lat: Double,
        lon: Double,
    ) {
        _latitude.value = lat.toString()
        _longitude.value = lon.toString()
    }
}
