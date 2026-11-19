package com.example.roomdata.uicontroller

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

import com.example.roomdata.uicontroller.route.DestinasiDetailSiswa
import com.example.roomdata.uicontroller.route.DestinasiEditSiswa
import com.example.roomdata.uicontroller.route.DestinasiEntry
import com.example.roomdata.uicontroller.route.DestinasiHome

import com.example.roomdata.view.DetailSiswaScreen
import com.example.roomdata.view.EditSiswaScreen
import com.example.roomdata.view.EntrySiswaScreen
import com.example.roomdata.view.HomeScreen

@Composable
fun SiswaApp(navController: NavHostController = rememberNavController()) {
    HostNavigasi(navController = navController)
}

@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = modifier
    ) {
        // 1. Halaman Home
        composable(DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = { navController.navigate(DestinasiEntry.route) },
                navigateToItemUpdate = { idSiswa ->
                    navController.navigate("${DestinasiDetailSiswa.route}/$idSiswa")
                }
            )
        }

        // 2. Halaman Entry (Tambah)
        composable(DestinasiEntry.route) {
            EntrySiswaScreen(navigateBack = { navController.popBackStack() })
        }

        // 3. Halaman Detail
        composable(
            route = DestinasiDetailSiswa.routeWithArgs,
            arguments = listOf(navArgument(DestinasiDetailSiswa.itemIdArg) {
                type = NavType.IntType
            })
        ) {
            DetailSiswaScreen(
                navigateToEditItem = { idSiswa ->
                    navController.navigate("${DestinasiEditSiswa.route}/$idSiswa")
                },
                navigateBack = { navController.navigateUp() }
            )
        }

        // 4. Halaman Edit
        composable(
            route = DestinasiEditSiswa.routeWithArgs,
            arguments = listOf(navArgument(DestinasiEditSiswa.itemIdArg) {
                type = NavType.IntType
            })
        ) {
            EditSiswaScreen(
                navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() }
            )
        }
    }
}