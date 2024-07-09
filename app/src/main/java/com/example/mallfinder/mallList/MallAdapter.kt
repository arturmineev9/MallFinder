package com.example.mallfinder.mallList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.mallfinder.data.Category
import com.example.mallfinder.data.Mall
import com.example.mallfinder.data.Shop
import com.example.mallfinder.databinding.ItemMallBinding


class MallAdapter(
    private var list: List<Mall>,
    private val glide: RequestManager,
    private val onClick: (Mall) -> Unit,
) : RecyclerView.Adapter<MallHolder>() {

    fun filterList(filteredMalls: List<Mall>) {
        this.list = filteredMalls
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MallHolder {
        return MallHolder(
            ItemMallBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            glide = glide,
            onClick = onClick,
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: MallHolder, position: Int) {
        list[position]?.let { holder.onBind(it) }
    }


    fun filterByCategories(list: List<Category>) {
        val allMalls = this.list.toList()
        val selectedCategoryNames = list.map { it.name }
        val filteredMalls = allMalls.filter { mall ->
            mall?.categories!!.containsAll(selectedCategoryNames)
        }
        this.list = filteredMalls
        notifyDataSetChanged()
    }

    fun filterByShops(list: List<Shop>) {
        val allMalls = this.list.toList()
        val filteredMalls = allMalls.filter { mall ->
            mall?.shop_list!!.containsAll(list)
        }
        this.list = filteredMalls
        notifyDataSetChanged()
    }

}
