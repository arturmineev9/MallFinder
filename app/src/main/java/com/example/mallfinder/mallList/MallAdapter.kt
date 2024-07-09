package com.example.mallfinder.mallList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.mallfinder.data.Mall
import com.example.mallfinder.databinding.ItemMallBinding


class MallAdapter(
    private val list: List<Mall?>,
    private val glide: RequestManager,
    private val onClick: (Mall) -> Unit,
) : RecyclerView.Adapter<MallHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MallHolder {
        return MallHolder(
            ItemMallBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            glide= glide,
            onClick = onClick,
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: MallHolder, position: Int) {
        list[position]?.let { holder.onBind(it) }
    }
}