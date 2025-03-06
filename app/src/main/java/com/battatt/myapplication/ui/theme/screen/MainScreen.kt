package com.battatt.myapplication.ui.theme.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.battatt.myapplication.R


@Preview
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") { HomeScreen() }
        composable("recipes") { RecipesScreen() }
        composable("profile") { ProfileScreen() }
    }

    Scaffold(
        bottomBar = {
            NavigationBar {
                // Recipes
                NavigationBarItem(
                    icon = {
                        Image(
                            painter = painterResource(id = R.drawable.ic_recipe_page),
                            contentDescription = "Рецепты"
                        )
                    },
                    label = { Text("Рецепты") },
                    selected = currentRoute == "recipes",
                    onClick = {
                        navController.navigate("recipes") {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                    }
                )

                // Home
                NavigationBarItem(
                    icon = {
                        Image(
                            painter = painterResource(id = R.drawable.ic_home_page),
                            contentDescription = "Дом"
                        )
                    },
                    label = { Text("Дом") },
                    selected = currentRoute == "home",
                    onClick = {navController.navigate("home") {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                        }
                    }
                )

                // Profile
                NavigationBarItem(
                    icon = {
                        Image(
                            painter = painterResource(id = R.drawable.ic_profile_page),
                            contentDescription = "Профиль"
                        )
                    },
                    label = { Text("Профиль") },
                    selected = currentRoute == "profile",
                    onClick = {
                        navController.navigate("profile") {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                    }
                )

            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("home") { HomeScreen() }
            composable("recipes") { RecipesScreen() }
            composable("profile") { ProfileScreen() }
        }
    }

}