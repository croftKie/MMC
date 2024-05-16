package com.example.museomaritmo.Data

import com.example.museomaritmo.R

class AppModel {
	fun getEvents(): List<EventData>{
		return listOf(
			EventData("11/05/24", "Mira cómo se alimentan los tiburones."),
			EventData("14/05/24", "Aprende la historia de Maritimo en Santander"),
			EventData("16/05/24", "acceder a la biblioteca del Museo"),
			EventData("18/05/24", "Mira cómo se alimentan los tiburones."),
			EventData("21/05/24", "Aprende la historia de Maritimo en Santander"),
			EventData("23/05/24", "acceder a la biblioteca del Museo"),
		)
	}

	fun getDashboardInfo(): List<DashboardData>{
		return listOf(
			DashboardData(
				"El Museo",
				"La historia, edificio y las plantas del Museo Maritimo.",
				R.drawable.museo_tall),
			DashboardData(
				"Las Colecciones",
				"Las colecciones emociante del Museo Maritimo.",
				R.drawable.collec_tall),
			DashboardData(
				"Visita Virtual",
				"Toma una visita virtual a las colecciones del Museo Maritimo.",
				R.drawable.virtual_tall),
			DashboardData(
				"Visitar El Museo",
				"El horario, tarifa y informacion para contactar el museo.",
				R.drawable.ticket_tall),
		)
	}

	fun getGalleryImages(): List<GalleryData>{
		return listOf(
			GalleryData(R.drawable.gal_1),
			GalleryData(R.drawable.gal_2),
			GalleryData(R.drawable.gal_3),
			GalleryData(R.drawable.gal_4),
			GalleryData(R.drawable.gal_5),
			GalleryData(R.drawable.gal_6),
			GalleryData(R.drawable.gal_7),
			GalleryData(R.drawable.gal_8),
			GalleryData(R.drawable.gal_9),
			GalleryData(R.drawable.gal_10)
		)
	}
}
