package com.example.mallfinder.mallList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mallfinder.data.Category

class CategoryFilterViewModel : ViewModel() {
    val selectedCategories: MutableLiveData<List<Category>> = MutableLiveData()
}
