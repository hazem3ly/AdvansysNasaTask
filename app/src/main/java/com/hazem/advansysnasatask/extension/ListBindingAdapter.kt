package com.hazem.advansysnasatask.extension

import android.widget.ImageView

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

import com.hazem.advansysnasatask.R
import com.hazem.advansysnasatask.data.network.apiresponse.genelab.StudyPerson
import com.hazem.advansysnasatask.model.GenelabResponseListModel
import com.hazem.advansysnasatask.ui.fragments.details.StudyPersonAdapter
import com.hazem.advansysnasatask.ui.fragments.home.GeneLabAdapter
import com.hazem.advansysnasatask.ui.fragments.home.HomeListViewModel
import com.squareup.picasso.Picasso

@BindingAdapter(value = ["list", "viewModel"])
fun setList(view: RecyclerView, listModel: GenelabResponseListModel?, vm: HomeListViewModel) {
    if (listModel == null) return
    if (view.adapter != null) {
        if (view.adapter is GeneLabAdapter) {
            val adapter = view.adapter as GeneLabAdapter
            adapter.setItems(listModel.list)
            adapter.notifyDataSetChanged()
        }
    } else {
        val adapter = GeneLabAdapter(listModel.list.toMutableList(), vm)
        view.adapter = adapter
    }
}

@BindingAdapter(value = ["persons"])
fun setPersons(view: RecyclerView, list: List<StudyPerson>?) {
    if (list == null) return
    if (view.adapter != null) {
        if (view.adapter is GeneLabAdapter) {
            val adapter = view.adapter as StudyPersonAdapter
            adapter.setItems(list)
            adapter.notifyDataSetChanged()
        }
    } else {
        val adapter = StudyPersonAdapter(list.toMutableList())
        view.adapter = adapter
    }
}

@BindingAdapter("loadImage")
fun loadImage(view: ImageView, imageUrl: String) {
    if (imageUrl.isEmpty()) return
    Picasso.get()
        .load(imageUrl)
        .placeholder(R.drawable.ic_launcher_background)
        .error(R.drawable.error)
        .resize(0, 150)
        .into(view)

}
