package com.sport.calculator

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CalculatorScreen(
    stanje: CalculatorUiState,
    onBroj1Change: (String) -> Unit,
    onBroj2Change: (String) -> Unit,
    onZbrojClick: () -> Unit,
    onNavigateToExercise: () -> Unit,
    modifier: Modifier = Modifier
) {

    Column() {
        Text(
            text = "Calculator", modifier = modifier.padding(24.dp)
        )

        OutlinedTextField(
            value = stanje.broj1,
            label = { Text(text = "Unesite prvi broj") },
            onValueChange = onBroj1Change,
        )

        OutlinedTextField(
            value = stanje.broj2,
            label = { Text(text = "Unesite drugi broj") },
            onValueChange = onBroj2Change,
        )

        Text(
            text = stanje.rez, modifier = modifier.padding(24.dp)
        )

        Button(
            onClick = onZbrojClick, modifier = modifier.padding(24.dp)
        ) {
            Text(text = "Zbroj")
        }

        Button(
            onClick = onNavigateToExercise,
            modifier = modifier.padding(24.dp)
        ){
          Text ("Idi na Exercise ekran")
        }
    }
}