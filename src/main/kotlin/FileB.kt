import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.io.File

@Composable
fun fileB() {
    var currentScreen by remember { mutableStateOf<Navi>(Navi.SettingFontSize) }

    var fontSized by remember { mutableStateOf(loadFontSizeV1A().sp) }

    val fontSizeMap = mapOf(
        "Font A" to 25.sp,
        "Font B" to 30.sp,
        "Font C" to 35.sp
    )
    when (currentScreen) {
        is Navi.SettingFontSize -> {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                TopAppBar(
                    backgroundColor = Color.Black,
                    modifier = Modifier.fillMaxWidth().clickable(onClick = { currentScreen = Navi.Main }),
                ) {
                    Text(
                        "Title",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        style = TextStyle(fontSize = 20.sp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentSize(Alignment.Center)
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 30.dp, bottom = 100.dp, start = 16.dp, end = 16.dp)
                        .background(Color.Black, shape = AbsoluteRoundedCornerShape(8.dp))
                        .padding(5.dp)
                        .background(Color.DarkGray, shape = AbsoluteRoundedCornerShape(5.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    val itemsList = listOf("Font A", "Font B", "Font C")
                    LazyColumn(
                        modifier = Modifier.fillMaxHeight(),
                        state = rememberLazyListState(),
                        verticalArrangement = Arrangement.Center
                    ) {
                        items(itemsList) { item ->
                            Text(
                                text = item,
                                color = Color.White,
                                modifier = Modifier
                                    .clickable {
                                        fontSized =
                                            fontSizeMap[item]
                                                ?: 20.sp // Default to 20 sp if item is not found in the map
                                        saveFontSizeV1A(fontSized.value)
                                    }
                                    .padding(16.dp)
                                    .fillMaxWidth(),
                                textAlign = TextAlign.Center,
                                style = TextStyle(fontSize = 30.sp)
                            )
                        }
                    }
                }
            }
        }
        Navi.Main -> fileA()
    }
}

fun saveFontSizeV1A(fontSize: Float) {
    val file = File("fontSizeA.txt")
    file.writeText(fontSize.toString())
}

fun loadFontSizeV1A(): Float {
    val file = File("fontSizeA.txt")
    return if (file.exists()) {
        file.readText().toFloat()
    } else {
        20.0f
    }
}