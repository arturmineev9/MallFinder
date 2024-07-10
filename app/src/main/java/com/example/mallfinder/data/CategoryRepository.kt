package com.example.mallfinder.data

object CategoryRepository {

    private val categories = mutableMapOf<Int, Category>()

    private var currentId = 1

    init {

        categories[currentId++] = Category(icon= "https://images2.imgbox.com/3e/fb/GWU4PlqC_o.png", name = "Одежда", false)
        categories[currentId++] = Category(icon = "https://images2.imgbox.com/fa/94/Xb16cyM0_o.png",name = "Обувь",false)
        categories[currentId++] = Category(icon= "https://images2.imgbox.com/b8/7c/k17UMvyM_o.png",name = "Бытовая техника и электроника", false)
        categories[currentId++] = Category(icon = "https://images2.imgbox.com/0c/a2/hozRerMz_o.png",name = "Красота и здоровье", false)
        categories[currentId++] = Category(icon = "https://images2.imgbox.com/89/ae/STgn3pVp_o.png",name = "Гипермаркет", false)
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