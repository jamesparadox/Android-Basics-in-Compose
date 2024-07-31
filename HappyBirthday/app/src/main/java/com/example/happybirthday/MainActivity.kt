package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Call the GreetingImage() function
                    GreetingImage(
                        // Pass the message and from parameters with reference to string.xml
                        message = stringResource(R.string.happy_birthday_text),
                        from = stringResource(R.string.signature_text),
                        // Pass the modifier parameter as a 8dp padding
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}

// Composable function to generate the Happy Birthday text (without image)
// Receives parameters: message, from and modifier
@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier){
    // Column places items beneath one another.
    Column(
        // Center the text
        verticalArrangement = Arrangement.Center,
        // Apply the passed modifiers
        modifier = modifier
    ) {
        // Create a Text instance
        Text(
            // Set the message to the text parameter
            text = message,
            // Set the font size
            fontSize = 72.sp,
            // Set the height position of the text
            lineHeight = 116.sp,
            // Center align the text
            textAlign = TextAlign.Center
        )
        // Create a separate Text instance
        Text(
            // Set the from to the text parameter
            text = from,
            // Set the font size
            fontSize = 36.sp,
            // Set the modifier parameter (separately)
            modifier = Modifier
                // Pad by 16dp of the screen the from message
                .padding(16.dp)
                // Right align the text
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}

// Composable function to generate the Happy Birthday text and image
// Receives parameters: message, from and modifier
@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier){
    // Set the image val to the painter resource of directory res/drawable/androidparty.png
    val image = painterResource(R.drawable.androidparty)
    // Box overlays different elements on top of each other
    Box(modifier) {
        // Create an image instance
        Image(
            // Set the painter to the painterResource of the png
            painter = image,
            // For accessibility reasons, don't TalkBack the image
            contentDescription = null,
            // Scale the image to fill the screen
            contentScale = ContentScale.Crop,
            // Make image more transparent
            alpha = 0.5F
        )
        // Create a GreetingText instance from the function
        GreetingText(
            // Pass message and from parameters
            message = message,
            from = from,
            // Set the modifier parameters
            modifier = Modifier
                // Fill the greeting size
                .fillMaxSize()
                // Pad by 8 dp from the edge of the screen
                .padding(8.dp)
        )
    }
}

// Preview tags can take different parameters
@Preview(
    showBackground = true,
    showSystemUi = false,
    name = "My Preview")
@Composable
// The preview allows us to see live renders prior to building the app
fun BirthdayCardPreview() {
    HappyBirthdayTheme {
        // Call the function at hand and pass parameters
        GreetingImage(
            message = "Happy Birthday Antoinette!",
            from = "From James"
        )
    }
}