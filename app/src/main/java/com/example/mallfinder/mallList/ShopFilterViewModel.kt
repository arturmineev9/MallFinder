package com.example.mallfinder.mallList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mallfinder.data.Shop

class ShopFilterViewModel : ViewModel() {
    val selectedShops: MutableLiveData<List<Shop>> = MutableLiveData()
}