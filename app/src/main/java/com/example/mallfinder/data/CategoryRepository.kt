package com.example.mallfinder.data

object CategoryRepository {

    private val categories = mutableMapOf<Int, Category>()

    private var currentId = 1

    init {

        categories[currentId++] = Category(icon= "<https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200/>", name = "Одежда", false)
        categories[currentId++] = Category(icon = "https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200/>",name = "Обувь",false)
        categories[currentId++] = Category(icon= "ic_household.xml",name = "Бытовая техника и электроника", false)
        categories[currentId++] = Category(icon = "ic_beauty.xml",name = "Красота и здоровье", false)
        categories[currentId++] = Category(icon = "ic_supermarket.xml",name = "Гипермаркет", false)
    }

    fun addCategory(category: Category): Int {
        val id = currentId++
        categories[id] = category
        return id
    }

    fun getCategoryNameById(id: Int): String? {
        return categories[id]?.name
    }

    fun getAllCategories(): Map<Int, Category> {
        return categories
    }
}