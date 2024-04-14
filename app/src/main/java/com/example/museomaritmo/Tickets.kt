package com.example.museomaritmo

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun Tickets(navController: NavController){
	val context = LocalContext.current
	Column(
		modifier = Modifier
			.fillMaxWidth()
			.fillMaxHeight(),
		verticalArrangement = Arrangement.Center,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		Image(
			modifier = Modifier.fillMaxWidth(0.75f).padding(bottom = 25.dp),
			painter = painterResource(id = R.drawable.ticket_logo),
			contentDescription = "ticket logo"
		)
		Row(modifier = Modifier
				.fillMaxWidth(0.5f)
				.padding(bottom = 20.dp),
			horizontalArrangement = Arrangement.SpaceBetween,
			verticalAlignment = Alignment.CenterVertically,
		) {
			Image(painter = painterResource(id = R.drawable.back), contentDescription = "less")
			Text(
				fontSize = 35.sp,
				text = "${0}"
			)
			Image(painter = painterResource(id = R.drawable.forward), contentDescription = "more")
		}
		Button(onClick = {
			Toast.makeText(context,"Ticket Purchase Currently Unavailable", Toast.LENGTH_LONG).show()
		}) {
			Text(text = "Comprar")
		}
	}
}