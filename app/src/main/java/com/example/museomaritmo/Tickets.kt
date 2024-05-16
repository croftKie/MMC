package com.example.museomaritmo

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun Tickets(){
	val uriHandler = LocalUriHandler.current
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
		Button(onClick = {
			uriHandler.openUri("https://www.museosdecantabria.es/reservas")
		}) {
			Text(text = "Comprar Entrada")
		}
	}
}