package com.example.cont2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cont2.ui.theme.Cont2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Cont2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainWindow()
                }
            }
        }
    }
}

@Preview(name = "main", showBackground = true)
@Composable
fun MainWindowPreview(){
    Cont2Theme {
        MainWindow()
    }
}

@Composable
fun MainWindow(modifier: Modifier = Modifier) {
    var currentState by remember { mutableStateOf(1)    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        ImageInfo()
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp), // Додайте відступи з обох боків для кнопок
            horizontalArrangement = Arrangement.SpaceBetween, // Змінено на SpaceBetween для рівномірного розподілу кнопок
        ) {
            Button(onClick = {

            }) {
                Text(text = "Previous")
            }

            Button(onClick = {

            }) {
                Text(text = "Next")
            }
        }
    }
}

@Composable
fun ImageInfo(
    @DrawableRes image: Int,
    @StringRes textInfo: Int,
    @StringRes textTile: Int,
)
{
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    )  {
        Image(
            painter = painterResource(image),

            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .size(height = 500.dp, width = 500.dp)
        )
        Text(
            text = stringResource(textInfo),
            fontSize = 36.sp,
            modifier =  Modifier
        )
        Text(
            text = stringResource(textTile),
            fontSize = 16.sp,
            modifier =  Modifier
        )
    }
}