package com.example.mallfinder.data

data class Mall(
    val name: String,
    val address: String,
    val description: String,
    val url: String,
    val work_hours: String,
    val shop_list: List<Shop?>,
    val coordinates: Pair<Double, Double>,
    val categories: List<String?>
)