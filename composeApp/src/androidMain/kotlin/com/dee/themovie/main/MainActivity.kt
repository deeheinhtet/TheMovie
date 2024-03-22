package com.dee.themovie.main

import App
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.dee.themovie.R
import com.dee.themovie.component.AppBar
import com.dee.themovie.screens.details.MovieDetailsScreen
import com.dee.themovie.screens.favorite.FavoritePage
import com.dee.themovie.screens.home.HomePage
import com.dee.themovie.screens.search.SearchPage
import com.dee.themovie.theme.AppTheme

val LocalNavController = compositionLocalOf<NavHostController> {
    error("No LocalNavController provided")
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidApp()
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComponentActivity.AndroidApp() {
    AppTheme {
        val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
        var navigationSelectedItem by remember {
            mutableIntStateOf(0)
        }
        val navController = rememberNavController()
        val bottomBarState = rememberSaveable { (mutableStateOf(true)) }
        val topBarState = rememberSaveable { (mutableStateOf(false)) }
        val topBarTitle = rememberSaveable { mutableStateOf("Movie Star") }

        DisposableEffect(key1 = Unit) {
            navController.addOnDestinationChangedListener { controller, destination, arguments ->
                when {
                    controller.currentDestination?.route.orEmpty()
                        .contains(Screens.Details.route) -> {
                        val name = arguments?.getString("movieName")
                        topBarTitle.value = name.orEmpty()
                        println("NAME ${name}")
                        bottomBarState.value = false
                        topBarState.value = true
                    }

                    else -> {
                        bottomBarState.value = true
                        topBarState.value = false
                        topBarTitle.value = getString(R.string.app_name)
                    }
                }
            }
            onDispose { }
        }

        val barColor = MaterialTheme.colorScheme.surfaceColorAtElevation(3.dp)
        enableEdgeToEdge(
            navigationBarStyle = SystemBarStyle.light(
                barColor.toArgb(), barColor.toArgb()
            ),
        )
        Scaffold(
            modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                AppBar(
                    topBarTitle.value,
                    topBarState,
                    scrollBehavior = scrollBehavior,
                    backgroundColor = barColor,
                    onNavigationIconClick = {
                        navController.popBackStack()
                    }
                )
            },
            bottomBar = {
                MainBottomNavigationBar(
                    bottomBarState,
                    navigationSelectedItem,
                    onSelectItem = { index, navigationItem ->
                        navigationSelectedItem = index
                        navController.navigate(navigationItem.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }) { paddingValues ->
            CompositionLocalProvider(LocalNavController provides navController) {
                SetupNavGraph(navController, paddingValues)
            }
        }
    }
}

@Composable
fun SetupNavGraph(navController: NavHostController, paddingValues: PaddingValues) {
    NavHost(
        navController,
        Screens.Home.route,
        modifier = Modifier.padding(paddingValues),
    ) {
        composable(Screens.Home.route) {
            HomePage()
        }
        composable(Screens.Search.route) {
            SearchPage()
        }
        composable(Screens.Profile.route) {
            FavoritePage()
        }
        composable(
            Screens.Details.route.plus("{movieId}/{movieName}"),
            arguments = listOf(
                navArgument("movieId") { type = NavType.StringType },
                navArgument("movieName") { type = NavType.StringType },
            )
        ) { backStackEntry ->
            MovieDetailsScreen(backStackEntry.arguments?.getString("movieId"))
        }
    }
}


@Preview
@Composable
fun AppAndroidPreview() {
    App()
}