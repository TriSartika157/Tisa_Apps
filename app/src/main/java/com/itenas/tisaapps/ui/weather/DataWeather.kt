package com.itenas.tisaapps.ui.weather

data class CuacaResponse(
    val lokasi: Lokasi,
    val data: List<DataCuaca>
)

data class Lokasi(
    val provinsi: String,
    val kotkab: String,
    val kecamatan: String,
    val desa: String,
    val lat: Double,
    val lon: Double
)

data class DataCuaca(
    val lokasi: Lokasi,
    val cuaca: List<List<CuacaDetail>>
)

data class CuacaDetail(
    val local_datetime: String,
    val t: Int,
    val weather_desc: String,
    val image: String
)
