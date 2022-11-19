package com.codelab.basics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codelab.basics.ui.theme.BasicsCodelabTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			BasicsCodelabTheme {
				// A surface container using the 'background' color from the theme
				val names = listOf("World", "Compose")
				MyApp(Modifier.fillMaxSize(), names)
			}
		}
	}
}

@Composable
private fun MyApp(modifier: Modifier = Modifier, names: List<String>) {
	Surface(modifier = modifier, color = MaterialTheme.colorScheme.background) {
		names.forEach { name ->
			Greeting(name)
		}
	}
}

@Composable
fun Greeting(name: String) {
	val expand = remember { mutableStateOf(false) }
	val extraPadding = if (expand.value) 48.dp else 0.dp

	Surface(
		color = MaterialTheme.colorScheme.primary,
		modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
	) {
		Row(modifier = Modifier.padding(24.dp)) {
			Column(
				modifier = Modifier
					.weight(1f)
					.padding(bottom = extraPadding)) {
				Text("Hello")
				Text("$name!")
			}

			ElevatedButton(
				onClick = { expand.value = !expand.value }
			) {
				val text = if (expand.value) "Show less" else "Show more"
				Text(text = text)
			}
		}
	}
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
	BasicsCodelabTheme {
		Greeting("Android")
	}
}