package com.hobbyloop.feature.reservation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation

const val RESERVATION_GRAPH_ROUTE = "reservation-graph"

fun NavGraphBuilder.reservationGraph(navController: NavController) {
    navigation(
        startDestination = RESERVATION_ROUTE,
        route = RESERVATION_GRAPH_ROUTE,
    ) {
        reservationScreen(navController)
    }
}