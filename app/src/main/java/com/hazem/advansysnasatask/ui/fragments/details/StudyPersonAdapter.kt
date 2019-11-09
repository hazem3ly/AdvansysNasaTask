package com.hazem.advansysnasatask.ui.fragments.details

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hazem.advansysnasatask.data.network.apiresponse.genelab.StudyPerson
import com.hazem.advansysnasatask.model.GenelabResponseModel

class StudyPersonAdapter(
    private val items: MutableList<StudyPerson>
) : RecyclerView.Adapter<PersonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        return PersonViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.bindData(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setItems(items: List<StudyPerson>) {
        this.items.clear()
        this.items.addAll(items)
    }

}
