package com.example.taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanager.ui.theme.TaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskManagerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                )
                {
                    TaskImage(
                        message = stringResource(R.string.task_complete),
                        support = stringResource(R.string.nice_work),
                        modifier = Modifier
                    )
                }
            }
        }
    }
}

@Composable
fun TaskImage(message: String, support: String, modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.ic_task_completed)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
        )
        TaskComplete(
            message = message,
            support = support,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun TaskComplete(message: String, support: String, modifier: Modifier = Modifier) {
    Column{
        Text(
            text = message,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(
                    top = 24.dp,
                    bottom = 8.dp
                    )
        )
        Text(
            text = support,
            fontSize = 16.sp,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TaskManagerTheme {
        TaskImage(stringResource(R.string.task_complete), stringResource(R.string.nice_work))
    }
}