package com.zzh133.trivia  // 确保你的包名正确

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zzh133.trivia.ui.theme.TriviaTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TriviaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomePage(
                        viewModel = Trivia(),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}



@Composable
fun HomePage(viewModel: Trivia, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "The lead actor in",
//            modifier = Modifier.padding(18.dp),
            fontSize = 18.sp,
            style = MaterialTheme.typography.headlineLarge
        )

        // Movie title
        Text(viewModel.currentMovie, fontSize = 18.sp)

        Text(
            text = "is?",
//            modifier = Modifier.padding(18.dp),
            fontSize = 18.sp,
            style = MaterialTheme.typography.headlineLarge
        )

        Spacer(Modifier.height(200.dp))

        // Actor name
        Text(viewModel.displayLead, fontSize = 28.sp, fontWeight = FontWeight.Bold)

        Spacer(Modifier.height(100.dp))

        if (viewModel.responseText.isNotEmpty()) {
            Text(
                text = viewModel.responseText,
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center
            )
        }

        Spacer(Modifier.height(200.dp))


        if (!viewModel.showNewQuiz) {
            Row {
                Button(onClick = {
                    viewModel.checkAnswer()
                }) {
                    Text("Pick")
                }

                Spacer(modifier = Modifier.padding(24.dp))

                Button(onClick = {
                    viewModel.nextAnswer()
                }) {
                    Text("Next")
                }
            }
        }

        if (viewModel.showNewQuiz) {
            Spacer(Modifier.height(20.dp))
            Button(onClick = { viewModel.newQuiz() }) { Text("New Quiz") }
        }
    }

}
@Preview(showBackground = true)
@Composable
fun PreviewHomePage() {
    TriviaTheme {
        HomePage(Trivia())
    }
}