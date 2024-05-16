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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.museomaritmo.Data.AppModel
import com.example.museomaritmo.Data.DashDests
import com.example.museomaritmo.Data.Destinations
import com.example.museomaritmo.Data.Home
import com.example.museomaritmo.ui.theme.MuseoBlue
import com.example.museomaritmo.ui.theme.MuseoMaritmoTheme

class MainActivity : ComponentActivity() {

	private lateinit var viewModel: AppModel

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		viewModel = AppModel()

		setContent {
			MuseoMaritmoTheme {
				Surface(
					modifier = Modifier.fillMaxSize().background(Color.White),
					color = Color.White
				) {
					ApplicationNavigator(viewModel)
				}
			}
		}
	}

	@Composable
	fun ApplicationNavigator(viewModel: AppModel){
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
				NavHost(
					navController = navController,
					startDestination = com.example.museomaritmo.Data.Splash.route
				){
					composable(com.example.museomaritmo.Data.Splash.route){
						Splash(navController)
					}
					composable(Home.route){
						Grid(viewModel)
					}
					composable(com.example.museomaritmo.Data.Events.route){
						Events(viewModel)
					}
					composable(com.example.museomaritmo.Data.Gallery.route){
						Gallery(viewModel)
					}
				}
			}
		}
	}


	@Composable
	fun BottomNav(navController: NavController){
		val destinationList = listOf<DashDests>(
			com.example.museomaritmo.Data.Home,
			com.example.museomaritmo.Data.Events,
			com.example.museomaritmo.Data.Gallery
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
						navController.navigate(item.route){
							popUpTo(com.example.museomaritmo.Data.Splash.route)
							launchSingleTop = true
						}
					},
					icon = {
						Icon(
							item.icon,
							"",
							modifier = Modifier.padding(bottom = 5.dp)
						)
					}
				)
			}
		}
	}
}
