package com.example.mallfinder.data

data class Shop (
    val name: String,
    val category: String?,
    val description: String,
    val url: String,
    val website: String,
    var isSelected : Boolean,
)