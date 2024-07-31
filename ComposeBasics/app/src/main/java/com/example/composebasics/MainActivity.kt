package com.example.composebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composebasics.ui.theme.ComposeBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeBasicsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                ComposeImage(
                        title = stringResource(R.string.compose_title),
                        body = stringResource(R.string.compose_body),
                        second = stringResource(R.string.compose_second),
                    )
                }
            }
        }
    }
}

@Composable
fun ComposeImage(title: String, body: String, second: String, modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.bg_compose_background)
    Column {
        Image(
            painter = image,
            contentDescription = null
        )
        Information(
            title = title,
            body = body,
            second = second
        )
    }
}

@Composable
fun Information(title: String, body: String, second: String, modifier: Modifier = Modifier) {
    Text(
        text = title,
        fontSize = 24.sp,
        modifier = modifier
            .padding(16.dp)
    )
    Text(
        text = body,
        textAlign = TextAlign.Justify,
        modifier = modifier
            .padding(
                start = 16.dp,
                end = 16.dp
            )
    )
    Text(
        text = second,
        textAlign = TextAlign.Justify,
        modifier = modifier
            .padding(16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeBasicsTheme {
        ComposeImage(
            stringResource(R.string.compose_title),
            stringResource(R.string.compose_body),
            stringResource(R.string.compose_second)
        )
    }
}