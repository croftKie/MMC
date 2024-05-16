package com.example.museomaritmo

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.museomaritmo.Data.AppModel
import com.example.museomaritmo.Data.Home
import com.example.museomaritmo.ui.theme.MuseoBlue
import com.example.museomaritmo.ui.theme.MuseoSand
import com.example.museomaritmo.ui.theme.OffBlack

@Composable
fun Welcome(){
	Box(modifier = Modifier.height(150.dp)){
		Column(modifier = Modifier
			.fillMaxWidth()
			.fillMaxHeight(),
			verticalArrangement = Arrangement.Bottom){
			Image(
				painter = painterResource(id = R.drawable.waves),
				contentDescription = "",
				modifier = Modifier.fillMaxWidth(),
				contentScale = ContentScale.FillWidth
			)
		}
		Column(modifier = Modifier
			.fillMaxWidth()
			.padding(10.dp)
			.clip(shape = RoundedCornerShape(20.dp))

		) {
			Image(
				painter = painterResource(id = R.drawable.logo),
				contentDescription = "logo",
				modifier = Modifier.height(90.dp)
			)
		}
	}
}

// EVENTS COMP
@Composable
fun Events(viewModel: AppModel){
	val data = viewModel.getEvents()

	Column{
		Welcome()
		Column(
			modifier = Modifier
				.fillMaxHeight()
				.background(MuseoBlue)
				.padding(16.dp)
		) {
			Text(
				text = "Upcoming Events",
				fontSize = 26.sp,
				modifier = Modifier.padding(bottom = 16.dp)
			)
			
			data.forEachIndexed { _, eventData ->
				Card(modifier = Modifier.padding(bottom = 10.dp).shadow(5.dp)) {
					Row(
						modifier = Modifier
							.padding(10.dp)
							.fillMaxWidth(),
						horizontalArrangement = Arrangement.SpaceEvenly) {
						Text(
							text = eventData.date,
							fontWeight = FontWeight.Bold,
							fontSize = 25.sp,
							modifier = Modifier
								.padding(end = 10.dp)

						)
						Text(
							fontSize = 20.sp,
							text = eventData.description
						)
					}
				}
			}
		}
	}
}

// DASH COMP
@Composable
fun Grid(viewModel: AppModel){
	val data = viewModel.getDashboardInfo()

	Column(
		modifier = Modifier
			.fillMaxWidth()
			.fillMaxHeight()
			.verticalScroll(rememberScrollState())
	) {
		Welcome()
		Column(modifier = Modifier
			.height(300.dp)
			.background(MuseoBlue)
			.fillMaxWidth()
			.padding(16.dp)) {
			Text(
				modifier = Modifier.padding(bottom = 16.dp),
				text = "Eventos próximos",
				fontSize = 24.sp,
				fontWeight = FontWeight.Bold
			)
			Card(modifier = Modifier.padding(bottom = 10.dp).shadow(5.dp)) {
				Column(
					modifier = Modifier
						.padding(10.dp)
						.fillMaxWidth(),
					horizontalAlignment = Alignment.Start,
					verticalArrangement = Arrangement.Center) {
					Text(
						text = "18/05/24",
						fontWeight = FontWeight.Bold,
						fontSize = 25.sp,
						modifier = Modifier
							.padding(bottom = 8.dp)
					)
					Text(
						fontSize = 20.sp,
						text = "Mira cómo se alimentan los tiburones."
					)
				}
			}
			Card(modifier = Modifier.padding(bottom = 10.dp).shadow(5.dp)) {
				Column(
					modifier = Modifier
						.padding(10.dp)
						.fillMaxWidth(),
					horizontalAlignment = Alignment.Start,
					verticalArrangement = Arrangement.Center) {
					Text(
						text = "21/05/24",
						fontWeight = FontWeight.Bold,
						fontSize = 25.sp,
						modifier = Modifier
							.padding(bottom = 8.dp)
					)
					Text(
						fontSize = 20.sp,
						text = "Aprende la historia de Maritimo en Santander."
					)
				}
			}
		}
		Text(
			modifier = Modifier
				.background(MuseoBlue)
				.fillMaxWidth()
				.padding(16.dp),
			text = "Recursos del Museo",
			fontSize = 24.sp,
			fontWeight = FontWeight.Bold
		)
		LazyRow(
			modifier = Modifier
				.background(MuseoBlue)
				.padding(16.dp)
		) {
			itemsIndexed(data) {
				index, item ->
				Row(
					modifier = Modifier
						.width(300.dp)
						.height(280.dp)
						.padding(bottom = 20.dp, end = 20.dp),
					horizontalArrangement = Arrangement.SpaceAround
				) {
					Card(
						modifier = Modifier.fillMaxWidth().shadow(5.dp)
					) {
						Box(modifier = Modifier.padding(8.dp)){
							Row(modifier = Modifier
								.fillMaxWidth()
								.fillMaxHeight()) {
								Image(
									painter = painterResource(id = item.imageResource),
									contentDescription = "image",
									modifier = Modifier
										.fillMaxWidth(0.3f)
										.fillMaxHeight(),
									contentScale = ContentScale.FillHeight)
								Column(
									modifier = Modifier
										.padding(8.dp)
										.fillMaxHeight(1f),
									verticalArrangement = Arrangement.SpaceBetween
								) {
									Text(
										modifier = Modifier.padding(10.dp),
										text = item.title,
										fontSize = 20.sp,
										fontWeight = FontWeight.Bold
									)
									Text(
										modifier = Modifier.padding(10.dp),
										text = item.description
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
}

// GALLERY COMP
@Composable
fun Gallery(viewModel: AppModel){
	val galleryImages = viewModel.getGalleryImages()
	Column(
		modifier = Modifier.verticalScroll(rememberScrollState())
	) {
		Welcome()
		Column(
			modifier = Modifier
				.background(MuseoBlue)
				.fillMaxWidth()
				.padding(top = 16.dp),
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			repeat(galleryImages.size){ index ->
				GalleryCard(imageId = galleryImages[index].imageResource)
			}
		}
	}
}
@Composable
fun GalleryCard(imageId: Int){
	Card(modifier = Modifier.padding(8.dp).shadow(5.dp)) {
		Box(
			modifier = Modifier
				.requiredSize(300.dp, 300.dp)
				.padding(8.dp)
		){
			Image(painter = painterResource(id = imageId), contentDescription = "image")
		}
	}
}
