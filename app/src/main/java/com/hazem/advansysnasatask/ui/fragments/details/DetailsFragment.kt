package com.hazem.advansysnasatask.ui.fragments.details

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.hazem.advansysnasatask.R
import com.hazem.advansysnasatask.databinding.DetailsFragmentBinding
import com.hazem.advansysnasatask.extension.BindingFragment

class DetailsFragment : BindingFragment<DetailsFragmentBinding>() {
    override val layoutResId: Int
        get() = R.layout.details_fragment

    private lateinit var viewModel: DetailsViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DetailsViewModel::class.java)
        val safeArgs = arguments?.let { DetailsFragmentArgs.fromBundle(it) }
        safeArgs?.geneLabItem?.let {
            binding.item = it
        }
    }

}
