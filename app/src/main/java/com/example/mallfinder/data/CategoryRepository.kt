package com.example.mallfinder.data

object CategoryRepository {

    private val categories = mutableMapOf<Int, Category>()

    private var currentId = 1

    init {

        categories[currentId++] = Category(name = "Одежда", false)
        categories[currentId++] = Category(name = "Обувь",false)
        categories[currentId++] = Category(name = "Бытовая техника и электроника", false)
        categories[currentId++] = Category(name = "Красота и здоровье", false)
        categories[currentId++] = Category(name = "Гипермаркет", false)
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