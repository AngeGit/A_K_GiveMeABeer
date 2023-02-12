package com.jetpackcompose.getmeabeer.core.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.jetpackcompose.getmeabeer.beerdetail.ui.screen.BeerDetailScreen
import com.jetpackcompose.getmeabeer.beerdetail.ui.screen.BeerDetailViewModel
import com.jetpackcompose.getmeabeer.beersearcher.ui.BeerSearcherViewModel
import com.jetpackcompose.getmeabeer.beersearcher.ui.screen.BeerSearcherScreen

@Composable
fun BeersNavHost(searcherVM: BeerSearcherViewModel, detailVM: BeerDetailViewModel) {
    val navigationController = rememberNavController()

    //Esto es un poco como el grafo, donde se definen las keys o rutas y el composable que muestra la activity:
    NavHost(navController = navigationController, startDestination = Routes.SearcherScreen.route) { //Empezamos con la screen de buscador
        composable(Routes.SearcherScreen.route) {
            searcherVM.setNavigationController(navigationController) //seteamos el navController en el VM
            BeerSearcherScreen(searcherVM) //Mostramos composable del buscador
        }
        composable(
            Routes.DetailScreen.route,
            arguments = listOf(
                navArgument(Routes.BEER_ID_PARAM) {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            detailVM.setNavigationController(navigationController)//seteamos el navController en el VM
                BeerDetailScreen(detailVM,backStackEntry.arguments?.getInt(Routes.BEER_ID_PARAM) ?: 0) //Mostramos el composable de la cerveza seleccionada
        }
    }
}