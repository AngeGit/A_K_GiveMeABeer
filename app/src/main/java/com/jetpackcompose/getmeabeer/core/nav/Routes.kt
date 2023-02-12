package com.jetpackcompose.getmeabeer.core.nav

sealed class Routes(val route: String){
    object SearcherScreen: Routes(SEARCHER_SCREEN_ROUTE)
    object DetailScreen: Routes("$DETAIL_SCREEN_ROUTE_ROOT{$BEER_ID_PARAM}") {//Param obligatorio para pantalla de detalle: Id de la cerveza.
        fun createDetailScreen(beerId:Int)="$DETAIL_SCREEN_ROUTE_ROOT$beerId"
    }
    companion object{
        private const val SEARCHER_SCREEN_ROUTE="searcherScreen"
        private const val DETAIL_SCREEN_ROUTE_ROOT="detailScreen/"
        const val BEER_ID_PARAM="beerId"
    }
}
