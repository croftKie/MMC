package com.example.museomaritmo

import android.service.autofill.OnClickAction
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.museomaritmo.ui.theme.MuseoBlue
import com.example.museomaritmo.ui.theme.MuseoSand
import com.example.museomaritmo.ui.theme.OffBlack

@Composable
fun Clickable(
	text: String = "Click Me",
	onClick: () -> Unit = {}
){
	Button(
		colors = ButtonDefaults.buttonColors(MuseoBlue),
		shape = RoundedCornerShape(5.dp),
		modifier = Modifier.padding(5.dp),
		onClick = onClick
	) {
		Text(
			color = OffBlack,
			text = text
		)
	}
}

fun ImageCard(){

}

@Composable
fun Tab(
	text: String = "Click Me",
	onClick: () -> Unit = {}
){
	Button(
		colors = ButtonDefaults.buttonColors(Color.White),
		shape = RoundedCornerShape(0),
		modifier = Modifier.padding(end = 10.dp).border(1.dp, MuseoBlue).width(100.dp),
		onClick = onClick
	) {
		Text(
			color = OffBlack,
			fontSize = 8.sp,
			text = text
		)
	}
}
fun EventCard(){

}


@Preview(showBackground = true)
@Composable
fun ButtonPrev(){
	Clickable()
}

@Preview(showBackground = true)
@Composable
fun TabPrev(){
	Tab()
}