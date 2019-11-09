package com.hazem.advansysnasatask.ui.fragments.details

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.hazem.advansysnasatask.R
import com.hazem.advansysnasatask.data.network.apiresponse.genelab.StudyPerson
import com.hazem.advansysnasatask.databinding.ItemLayoutBinding
import com.hazem.advansysnasatask.databinding.StudyPersonLayoutBinding
import com.hazem.advansysnasatask.extension.BindingViewHolder
import com.hazem.advansysnasatask.model.GenelabResponseModel

class PersonViewHolder private constructor(itemView: View) :
    BindingViewHolder<StudyPersonLayoutBinding>(itemView) {
    fun bindData(item: StudyPerson) {
        binding?.person = item
        binding?.executePendingBindings()
    }

    companion object {
        fun create(parent: ViewGroup): PersonViewHolder {
            return PersonViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.study_person_layout,
                    parent,
                    false
                )
            )
        }
    }

}