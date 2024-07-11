package com.example.mallfinder.Fragments.all.mallList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mallfinder.data.Shop

class ShopFilterViewModel : ViewModel() {
    val selectedShops: MutableLiveData<List<Shop>> = MutableLiveData()
}