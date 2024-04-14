package com.example.museomaritmo

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController

@Composable
fun Splash(navController: NavController){
	Column(
		modifier = Modifier.fillMaxWidth().fillMaxHeight(),
		verticalArrangement = Arrangement.Center,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		Image(painter = painterResource(id = R.drawable.logo), contentDescription = "logo")
		Button(
			onClick = { navController.navigate(com.example.museomaritmo.Data.Dashboard.route) }
		) {
			Text(text = "Bienvenidos")
		}
	}
}
