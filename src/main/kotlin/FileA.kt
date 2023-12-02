import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun fileA() {
    var currentScreen by remember { mutableStateOf<Navi>(Navi.Main) }

    when (currentScreen) {
        is Navi.Main -> {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .background(color = Color.Black, shape = AbsoluteRoundedCornerShape(8.dp))
                        .padding(5.dp)
                        .fillMaxSize()
                        .clickable (onClick = { currentScreen = Navi.SettingFontSize })
                        .background(
                            (Color.DarkGray),
                            shape = AbsoluteRoundedCornerShape(5.dp)
                        ), // color based on ping result
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Title",
                            color = Color.White,
                            fontSize = 30.sp
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "On",
                            color = Color.White,
                            fontSize = 22.sp,
                        )
                    }
                }
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
        Navi.SettingFontSize -> fileB()
    }
}
