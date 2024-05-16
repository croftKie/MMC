package com.example.museomaritmo.Data

data class EventData(
	val date: String,
	val description: String,
)

data class DashboardData(
	val title: String,
	val description: String,
	val imageResource: Int,
)

data class GalleryData(
	val imageResource: Int
)