package com.example.museomaritmo

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.museomaritmo.Data.Home

@Composable
fun Dashboard(){
	val dashNavController = rememberNavController()
	Column(
		modifier = Modifier
			.fillMaxWidth()) {
		Welcome()
		Options(dashNavController)
		DashNav(dashNavController)
	}
}



@Composable
fun DashNav(dashNavController: NavHostController) {
	Scaffold {
		Box(modifier = Modifier.padding(it)){
			NavHost(navController = dashNavController, startDestination = Home.route){
				composable(Home.route){
					Grid()
				}
				composable(com.example.museomaritmo.Data.Events.route){
					Events()
				}
				composable(com.example.museomaritmo.Data.Gallery.route){
					Gallery()
				}
			}
		}
	}
}
@Composable
fun Welcome(){
	Column(modifier = Modifier
		.fillMaxWidth()
		.padding(15.dp)) {
		Text(
			text = "Museo Maritimo de Cantabria",
			color = Color.Black,
			fontSize = 15.sp
		)
		Text(
			text = "Dashboard",
			color = Color.Black,
			fontSize = 40.sp,
		)
	}
}
@Composable
fun Options(dashNavController: NavHostController) {
	val options = listOf(
		"Home",
		"Events",
		"Gallery"
	)
	val destOptions = listOf(
		Home.route,
		com.example.museomaritmo.Data.Events.route,
		com.example.museomaritmo.Data.Gallery.route
	)

	Row(
		modifier = Modifier.fillMaxWidth(),
		horizontalArrangement = Arrangement.SpaceEvenly) {
		options.forEachIndexed { index, s ->
			OptionCell(item = s, destOptions[index], dashNavController)
		}
	}

}
@Composable
fun OptionCell(item : String, dest: String, dashNavController: NavHostController){
	Button(
		modifier = Modifier.padding(8.dp),
		onClick = {
			dashNavController.navigate(dest)
		}
	) {
		Text(text = item)
	}
}


// EVENTS COMP
@Composable
fun Events(){
	val data = arrayOf(
		arrayOf("14/04/24", "Swim with the fish"),
		arrayOf("14/04/24", "Swim with the fish"),
		arrayOf("14/04/24", "Swim with the fish"),
		arrayOf("14/04/24", "Swim with the fish"),
		arrayOf("14/04/24", "Swim with the fish"),
	)

	Column(modifier = Modifier.padding(10.dp)) {
		Text(
			text = "Upcoming Events",
			fontSize = 26.sp,
			modifier = Modifier.padding(bottom = 5.dp)
		)
		data.forEachIndexed { _, strings ->
			Card(modifier = Modifier.padding(bottom = 10.dp)) {
				Row(
					modifier = Modifier
						.padding(10.dp)
						.fillMaxWidth(),
					horizontalArrangement = Arrangement.SpaceEvenly) {
					Text(
						text = strings[0],
						fontWeight = FontWeight.Bold,
						fontSize = 25.sp,
						modifier = Modifier
							.padding(end = 10.dp)

					)
					Text(
						fontSize = 20.sp,
						text = strings[1]
					)
				}
			}
		}
	}
}

// DASH COMP
@Composable
fun Grid(){

	val data = arrayOf(
		arrayOf(
			"El Museo",
			"La historia, edificio y las plantas del Museo Maritimo."),
		arrayOf(
			"Las Colecciones",
			"Las colecciones emociante del Museo Maritimo."),
		arrayOf(
			"Visita Virtual",
			"Toma una visita virtual a las colecciones del Museo Maritimo."),
		arrayOf(
			"Visitar El Museo",
			"El horario, tarifa y informacion para contactar el museo."),
	)

	val dataImages = arrayOf(
		painterResource(
			id = R.drawable.museo_tall
		),
		painterResource(
			id = R.drawable.collec_tall
		),
		painterResource(
			id = R.drawable.virtual_tall
		),
		painterResource(
			id = R.drawable.ticket_tall
		)
	)



	Column(
		modifier = Modifier
			.fillMaxWidth()
			.padding(15.dp)
			.verticalScroll(rememberScrollState())
	) {


		data.forEachIndexed { index: Int, _ ->
			Row(
				modifier = Modifier
					.fillMaxWidth()
					.padding(bottom = 20.dp),
				horizontalArrangement = Arrangement.SpaceAround
			) {
				Card(
					modifier = Modifier.fillMaxWidth()
				) {
					Box(modifier = Modifier.padding(8.dp)){
						Row(modifier = Modifier
							.fillMaxWidth()
							.fillMaxHeight()) {
							Image(
								painter = dataImages[index],
								contentDescription = "image",
								modifier = Modifier.fillMaxWidth(0.3f))
							Column(
								modifier = Modifier
									.padding(8.dp)
									.fillMaxHeight(1f),
								verticalArrangement = Arrangement.SpaceBetween
							) {
								Text(
									modifier = Modifier.padding(10.dp),
									text = data[index][0],
									fontSize = 20.sp,
									fontWeight = FontWeight.Bold
								)
								Text(
									modifier = Modifier.padding(10.dp),
									text = data[index][1]
								)
								Button(
									modifier = Modifier.align(Alignment.End),
									onClick = { }
								) {
									Text(text = "Pulsar")
								}
							}
						}
					}
				}
			}
		}
	}
}

//
@Composable
fun Gallery(){
	val galleryImages = listOf(
		arrayOf(
			painterResource(id = R.drawable.gal_1),
			painterResource(id = R.drawable.gal_2),
		),
		arrayOf(
			painterResource(id = R.drawable.gal_3),
			painterResource(id = R.drawable.gal_4),
		),
		arrayOf(
			painterResource(id = R.drawable.gal_5),
			painterResource(id = R.drawable.gal_6),
		),
		arrayOf(
			painterResource(id = R.drawable.gal_7),
			painterResource(id = R.drawable.gal_8),
		),
		arrayOf(
			painterResource(id = R.drawable.gal_9),
			painterResource(id = R.drawable.gal_10),
		)
	)
	Column(
		modifier = Modifier.verticalScroll(rememberScrollState())
	) {
		repeat(galleryImages.size){ index ->
			Row(
				modifier = Modifier
					.fillMaxWidth()
					.padding(bottom = 8.dp),
				horizontalArrangement = Arrangement.SpaceEvenly) {
				repeat(2){
					GalleryCard(imageId = galleryImages[index][it])
				}
			}
		}
	}
}
@Composable
fun GalleryCard(imageId: Painter){
	Card {
		Box(
			modifier = Modifier
				.requiredSize(180.dp, 180.dp)
				.padding(8.dp)
		){
			Image(painter = imageId, contentDescription = "image")
		}
	}
}


//
//
// PREVIEWS
@Preview(showBackground = true)
@Composable
fun GridPreview(){
	Gallery()
}