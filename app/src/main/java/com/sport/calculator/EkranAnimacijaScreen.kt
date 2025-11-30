package com.sport.calculator

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun EkranAnimacijaScreen(brojac: Int) {
    Text(
        text = "Brojac koji je primljen je $brojac",
        modifier = Modifier.padding(all = 120.dp)
    )
}
