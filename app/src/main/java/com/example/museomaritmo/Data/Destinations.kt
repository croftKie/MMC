package com.example.museomaritmo.Data

import android.graphics.drawable.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.museomaritmo.R

interface Destinations {
	val route: String
	val icon: Int
	val title: String
}

object Splash : Destinations {
	override val icon: Int
		get() = R.drawable.ic_launcher_foreground
	override val route: String
		get() = "Splash"
	override val title: String
		get() = "Splash"
}
object Tickets : Destinations {
	override val route: String = "Tickets"
	override val icon: Int = R.drawable.ticket
	override val title: String = "Comprar"
}
object Dashboard : Destinations {
	override val route: String = "Dashboard"
	override val icon: Int = R.drawable.dashboard
	override val title: String = "Dashboard"
}
object Settings : Destinations {
	override val route: String = "Settings"
	override val icon: Int = R.drawable.settings
	override val title: String = "Opciones"
}


interface DashDests {
	val route: String
	val icon: ImageVector
}

object Home : DashDests {
	override val route: String
		get() = "Home"
	override val icon: ImageVector
		get() = Icons.Default.Home
}
object Events : DashDests {
	override val route: String
		get() = "Events"
	override val icon: ImageVector
		get() = Icons.Default.DateRange
}
object Gallery : DashDests {
	override val route: String
		get() = "Gallery"
	override val icon: ImageVector
		get() = Icons.Default.List
}