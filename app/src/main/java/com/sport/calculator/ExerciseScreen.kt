package com.sport.calculator

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun ExerciseScreen(
    stanje: ExerciseUiState,
    brojac: () -> Unit,
    navigirajNaEkranAnimacija: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val brojacAnimacija by animateIntAsState(
        targetValue = stanje.brojPonavljanja,
        animationSpec = tween(durationMillis = 300)
    )

    val progress = (brojacAnimacija % 10) / 10f

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Vjezba",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(top = 32.dp)
        )
        Spacer(Modifier.height(16.dp))

        LinearProgressIndicator(
            progress = progress,
            color = MaterialTheme.colorScheme.primary,
            trackColor = MaterialTheme.colorScheme.secondary,
            modifier = Modifier
                .fillMaxWidth()
                .height(16.dp)
                .clip(RoundedCornerShape(16.dp))
        )

        AnimatedContent(
            targetState = brojacAnimacija, transitionSpec = {
                slideInVertically { it } + fadeIn() togetherWith slideOutVertically { -it } + fadeOut()
            }) { brojac ->
            Text(
                text = brojac.toString(), // mozemo pisati i ovo "$brojac"
                style = MaterialTheme.typography.displayLarge,
                color = MaterialTheme.colorScheme.primary
            )
        }

        Button(
            onClick = brojac,
            modifier = Modifier.padding(top = 16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.secondary,
            )
        ) {
            Text(text = "Povecaj brojac")
        }

        Button(
            onClick = { navigirajNaEkranAnimacija(stanje.brojPonavljanja) },
            modifier = Modifier.padding(top = 16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.secondary,
            )
        ) {
            Text("Otvori ekran Animacija")
        }
    }
}