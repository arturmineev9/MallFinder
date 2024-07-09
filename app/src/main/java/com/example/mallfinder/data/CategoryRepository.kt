package com.example.mallfinder.data

object CategoryRepository {

    private val categories = mutableMapOf<Int, Category>()

    private var currentId = 1

    init {

        categories[currentId++] = Category(name = "Одежда")
        categories[currentId++] = Category(name = "Обувь")
        categories[currentId++] = Category(name = "Бытовая техника и электроника")
        categories[currentId++] = Category(name = "Красота и здоровье")
        categories[currentId++] = Category(name = "Гипермаркет")
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