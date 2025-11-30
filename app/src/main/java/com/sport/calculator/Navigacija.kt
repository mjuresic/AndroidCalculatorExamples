package com.sport.calculator

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

sealed class Screen(val route: String) {
    object Calculator : Screen("calculator")
    object Exercise : Screen("exercise")
    object EkranAnimacija : Screen("ekranAnimacija/{brojac}") {
        fun navigirajSaBrojacem(brojac: Int) = "ekranAnimacija/$brojac"
    }
}

@Composable
fun Navigacija(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Calculator.route
    ) {
        composable(Screen.Calculator.route) {
            val vm: CalculatorViewModel = viewModel()
            CalculatorScreen(
                stanje = vm.uiState,
                onBroj1Change = vm::updateBroj1,
                onBroj2Change = vm::updateBroj2,
                onZbrojClick = vm::zbroj,
                onNavigateToExercise = {
                    navController.navigate(Screen.Exercise.route)
                }
            )
        }

        composable(Screen.Exercise.route) {
            val vm: ExerciseViewModel = viewModel()
            ExerciseScreen(
                stanje = vm.uiState,
                brojac = vm::povecajBrojPonavljanja,
                navigirajNaEkranAnimacija = { brojac ->
                    navController.navigate(Screen.EkranAnimacija.navigirajSaBrojacem(brojac))
                }
            )
        }

        composable(
            Screen.EkranAnimacija.route,
            arguments = listOf(
                navArgument("brojac") {
                    type = NavType.IntType
                }
            )) { backStackEntry ->
            val brojac = backStackEntry.arguments?.getInt("brojac") ?: 0
            EkranAnimacijaScreen(brojac)
        }
    }
}
