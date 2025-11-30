package com.sport.calculator

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

data class CalculatorUiState(
    val broj1: String = "",
    val broj2: String = "",
    val rez: String = ""
)

class CalculatorViewModel : ViewModel() {
    var uiState by mutableStateOf(CalculatorUiState())
        private set

    fun updateBroj1(br1: String) {
        uiState = uiState.copy(broj1 = br1)
    }

    fun updateBroj2(br2: String) {
        uiState = uiState.copy(broj2 = br2)
    }

    fun zbroj() {
        val a = uiState.broj1.toDoubleOrNull()
        val b = uiState.broj2.toDoubleOrNull()
        if (a != null && b != null) {
            val rezultat = a + b
            uiState = uiState.copy(rez = rezultat.toString())
        } else {
            uiState = uiState.copy(rez = "Greska")
        }
    }
}