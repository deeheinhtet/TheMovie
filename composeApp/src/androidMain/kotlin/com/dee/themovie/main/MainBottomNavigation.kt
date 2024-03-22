package com.dee.themovie.main

import android.content.Context
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import com.dee.themovie.R

/**
 * Created by Hein Htet
 */


@Composable
fun MainBottomNavigationBar(
    showBottomBarState: MutableState<Boolean> ,
    navigationSelectedItemIndex: Int,
    onSelectItem: (index: Int, navigationItem: BottomNavigationItem) -> Unit,
) {
    val localContext = LocalContext.current

    AnimatedVisibility(
        visible = showBottomBarState.value,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it }),
    ) {
        NavigationBar(containerColor = MaterialTheme.colorScheme.background) {
            BottomNavigationItem().bottomNavigationItems(localContext)
                .forEachIndexed { index, navigationItem ->
                    NavigationBarItem(
                        selected = index == navigationSelectedItemIndex,
                        label = {
                            Text(navigationItem.label)
                        },
                        icon = {
                            Icon(
                                navigationItem.icon,
                                contentDescription = navigationItem.label
                            )
                        },
                        onClick = {
                            onSelectItem(index, navigationItem)
                        }
                    )
                }
        }
    }
}

data class BottomNavigationItem(
    val label: String = "",
    val icon: ImageVector = Icons.Filled.Home,
    val route: String = "",
) {

    fun bottomNavigationItems(context: Context): List<BottomNavigationItem> {
        return listOf(
            BottomNavigationItem(
                label = context.resources.getString(R.string.LABEL_BEER),
                icon = Icons.Outlined.Home,
                route = Screens.Home.route
            ),
            BottomNavigationItem(
                label = context.resources.getString(R.string.LABEL_SEARCH),
                icon = Icons.Outlined.Search,
                route = Screens.Search.route
            ),
            BottomNavigationItem(
                label = context.resources.getString(R.string.LABEL_FAVORITE),
                icon = Icons.Outlined.Star,
                route = Screens.Profile.route
            ),
        )
    }
}

sealed class Screens(val route: String) {
    data object Home : Screens("home_route")
    data object Search : Screens("search_route")
    data object Profile : Screens("profile_route")
    data object Details : Screens("movie_details_route/")
}
