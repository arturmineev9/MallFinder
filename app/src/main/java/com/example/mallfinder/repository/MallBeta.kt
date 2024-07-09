package com.example.mallfinder.repository

import com.example.mallfinder.data.Shop

data class MallBeta(
    val id: Int,
    val name: String,
    val address: String,
    val workHours: String,
    val description: String,
    val url: String,
    val shopList: List<Shop?>,
    val coordinates: String,
    val categories: List<String?>
)
