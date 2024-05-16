package com.example.museomaritmo

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.museomaritmo.Data.Home
import com.example.museomaritmo.ui.theme.MuseoBlue
import com.example.museomaritmo.ui.theme.SplashBG
import com.example.museomaritmo.ui.theme.bgGrey

@Composable
fun Splash(navController: NavController){
	Column(
		modifier = Modifier
			.fillMaxWidth()
			.fillMaxHeight()
			.background(SplashBG),
		horizontalAlignment = Alignment.CenterHorizontally,
	) {
		Column(
			modifier = Modifier.fillMaxHeight(0.5F),
			verticalArrangement = Arrangement.Center,
			horizontalAlignment = Alignment.CenterHorizontally
			) {
			Column(
				modifier = Modifier
					.clip(shape = RoundedCornerShape(30)),
				verticalArrangement = Arrangement.Center,
				horizontalAlignment = Alignment.CenterHorizontally
			){
				Image(painter = painterResource(id = R.drawable.logo), contentDescription = "logo")
				Clickable(
					text = "Bienvenidos",
					onClick = { navController.navigate(Home.route) }
				)
			}
		}
		Image(painter = painterResource(id = R.drawable.waves), contentDescription = "", modifier = Modifier.fillMaxWidth(), contentScale = ContentScale.FillWidth)
		Column(modifier = Modifier
			.background(MuseoBlue)
			.fillMaxHeight()
			.fillMaxWidth()) {

		}
	}
}

@Preview
@Composable
fun SplashPrev(){
	val navController = rememberNavController()

	Splash(navController)
}
