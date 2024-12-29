import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.trashdating.repo.PhotoRepository
import com.example.trashdating.ui.navigation_bar.IconNavItem
import com.example.trashdating.ui.navigation_bar.ImageNavItem
import com.example.trashdating.ui.navigation_bar.NavigationConstants

@Composable
fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    photoRepository: PhotoRepository
) {
    val screens = NavigationConstants.BottomNavItems

    NavigationBar(
        modifier = modifier.height(60.dp),
        containerColor = MaterialTheme.colorScheme.surface,
        tonalElevation = 1.dp
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        screens.forEach { screen ->
            when (screen) {
                is IconNavItem -> {
                    NavigationBarItem(
                        icon = {
                            Icon(
                                painter = painterResource(screen.icon),
                                contentDescription = ""
                            )
                        },
                        modifier = Modifier.size(36.dp),
                        selected = currentRoute == screen.route,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = MaterialTheme.colorScheme.surface,
                            unselectedIconColor = Color(0xFFFF9401),
                            indicatorColor = Color(0xFFFF9401),
                        )
                    )
                }

                is ImageNavItem -> {
                    NavigationBarItem(
                        icon = {
                            Image(
                                painter = photoRepository.getPhoto(screen.imageUrl),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(46.dp)
                                    .clip(CircleShape)
                            )
                        },
                        selected = currentRoute == screen.route,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = MaterialTheme.colorScheme.surface,
                            unselectedIconColor = Color(0xFFFF9401),
                            indicatorColor = Color(0xFFFF9401),
                        )

                    )
                }
            }
        }
    }
}
