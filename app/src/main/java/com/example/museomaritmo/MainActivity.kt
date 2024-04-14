package com.example.museomaritmo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.museomaritmo.Data.Destinations
import com.example.museomaritmo.ui.theme.MuseoBlue
import com.example.museomaritmo.ui.theme.MuseoMaritmoTheme
import com.example.museomaritmo.ui.theme.bgGrey

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			MuseoMaritmoTheme {
				Surface(
					modifier = Modifier.fillMaxSize().background(Color.White),
					color = Color.White
				) {
					MyNav()
				}
			}
		}
	}

	@Composable
	fun MyNav(){
		val navController = rememberNavController()
		val navBackStackEntry by navController.currentBackStackEntryAsState()
		var showBottomBar by rememberSaveable {
			mutableStateOf(true)
		}

		showBottomBar = when(navBackStackEntry?.destination?.route){
			"Splash" -> false
				else -> true
		}


		Scaffold(
			bottomBar = {
				if(showBottomBar){
					BottomNav(navController = navController)
				}
			}
		) {
			Box(modifier = Modifier.padding(it)){
				NavHost(navController = navController, startDestination = com.example.museomaritmo.Data.Splash.route){
					composable(com.example.museomaritmo.Data.Splash.route){
						Splash(navController)
					}
					composable(com.example.museomaritmo.Data.Tickets.route){
						Tickets(navController)
					}
					composable(com.example.museomaritmo.Data.Dashboard.route){
						Dashboard()
					}
					composable(com.example.museomaritmo.Data.Settings.route){
						Settings(navController)
					}
				}
			}
		}
	}


	@Composable
	fun BottomNav(navController: NavController){
		val destinationList = listOf<Destinations>(
			com.example.museomaritmo.Data.Tickets,
			com.example.museomaritmo.Data.Dashboard,
			com.example.museomaritmo.Data.Settings
		)
		var selectedIndex = rememberSaveable{
			mutableIntStateOf(0)
		}
		BottomNavigation(backgroundColor = MuseoBlue) {
			destinationList.forEachIndexed{index, item ->
				BottomNavigationItem(
					selected = index == selectedIndex.intValue,
					onClick = {
						selectedIndex.intValue = index
						navController.navigate(destinationList[index].route){
							popUpTo(com.example.museomaritmo.Data.Splash.route)
							launchSingleTop = true
						}
					},
					icon = {
						Icon(
							painter = painterResource(id = item.icon),
							contentDescription = item.title,
							modifier = Modifier.padding(bottom = 5.dp)
						)
					},
					label = {
						Text(
							text = item.title
						)
					}
				)
			}
		}
	}
}
