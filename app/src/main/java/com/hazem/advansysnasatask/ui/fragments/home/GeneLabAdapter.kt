package com.hazem.advansysnasatask.ui.fragments.home

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hazem.advansysnasatask.model.GenelabResponseModel

class GeneLabAdapter(
    private val items: MutableList<GenelabResponseModel>,
    private val vm: HomeListViewModel
) : RecyclerView.Adapter<ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bindData(vm, items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setItems(items: List<GenelabResponseModel>) {
        this.items.clear()
        this.items.addAll(items)
    }

}
