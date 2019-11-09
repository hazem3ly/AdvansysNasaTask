package com.hazem.advansysnasatask.ui.fragments.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.hazem.advansysnasatask.R
import com.hazem.advansysnasatask.databinding.ItemLayoutBinding
import com.hazem.advansysnasatask.extension.BindingViewHolder
import com.hazem.advansysnasatask.model.GenelabResponseModel

class ItemViewHolder private constructor(itemView: View) :
    BindingViewHolder<ItemLayoutBinding>(itemView) {
    fun bindData(vm: HomeListViewModel, item: GenelabResponseModel) {
        binding?.vm = vm
        binding?.item = item
        binding?.executePendingBindings()
    }

    companion object {
        fun create(parent: ViewGroup): ItemViewHolder {
            return ItemViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_layout,
                    parent,
                    false
                )
            )
        }
    }

}