package com.hobbyloop.member.navigationbar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hobbyloop.feature.center.centerGraph
import com.hobbyloop.feature.home.HOME_GRAPH_ROUTE
import com.hobbyloop.feature.home.homeGraph
import com.hobbyloop.feature.mypage.myPageGraph
import com.hobbyloop.feature.reservation.reservationGraph
import com.hobbyloop.feature.schedule.scheduleGraph

const val NAVIGATION_BAR_HOST_ROUTE = "navigation_bar_host"

fun NavController.navigateToNavigationBarHost() {
    navigate(NAVIGATION_BAR_HOST_ROUTE) {
        popUpTo(0) {
            inclusive = true
        }
        launchSingleTop = true
        restoreState = true
    }
}

fun NavGraphBuilder.navigationBarHost(navController: NavHostController) {
    composable(NAVIGATION_BAR_HOST_ROUTE) {
        Scaffold { padding ->
            Box(modifier = Modifier) {
                NavHost(
                    modifier = Modifier.padding(padding),
                    navController = navController,
                    startDestination = HOME_GRAPH_ROUTE,
                    route = NAVIGATION_BAR_HOST_ROUTE,
                ) {
                    homeGraph(
                        navController = navController,
                    )
                    centerGraph()
                    reservationGraph(
                        navController = navController,
                        onCloseClick = {
                            navController.popBackStack()
                        },
                    )
                    scheduleGraph()
                    myPageGraph(
                        navController = navController,
                    )
                }
                Box(
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .align(Alignment.BottomCenter),
                ) {
                    BottomBar(
                        navController = navController,
                    )
                }
            }
        }
    }
}
