import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.trashdating.repository.PhotoRepository

@Composable
fun BottomBarWithDivider(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    photoRepository: PhotoRepository
) {
    Column {
        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 2.dp,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f) // Настройка цвета
        )

        BottomBar(
            navController = navController,
            modifier = modifier,
            photoRepository = photoRepository
        )
    }
}
