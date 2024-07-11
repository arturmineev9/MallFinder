package com.example.mallfinder.Fragments.all.mallList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mallfinder.data.Category

class CategoryFilterViewModel : ViewModel() {
    val selectedCategories: MutableLiveData<List<Category>> = MutableLiveData()
}
