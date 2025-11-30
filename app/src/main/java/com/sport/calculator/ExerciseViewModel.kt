package com.sport.calculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

data class ExerciseUiState(
    val brojPonavljanja : Int = 0
)

class ExerciseViewModel : ViewModel() {

    var uiState by mutableStateOf(ExerciseUiState())
        private set

    fun povecajBrojPonavljanja() {
        uiState = uiState.copy(brojPonavljanja = uiState.brojPonavljanja + 1)
    }
}