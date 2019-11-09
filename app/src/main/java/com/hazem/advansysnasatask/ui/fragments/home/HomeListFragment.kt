package com.hazem.advansysnasatask.ui.fragments.home

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.navigation.findNavController

import com.hazem.advansysnasatask.R
import com.hazem.advansysnasatask.databinding.HomeListFragmentBinding
import com.hazem.advansysnasatask.extension.BindingFragment
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance

class HomeListFragment : BindingFragment<HomeListFragmentBinding>(), KodeinAware {
    override val kodein: Kodein by closestKodein()
    private val viewModelFactory: HomeListViewModelFactory by instance()

    private lateinit var viewModel: HomeListViewModel

    override val layoutResId: Int
        get() = R.layout.home_list_fragment

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(HomeListViewModel::class.java)
        binding.vm = viewModel
        registerObserver()
    }

    private fun registerObserver() {
        viewModel.itemDetailsCallback.observe(this.viewLifecycleOwner, Observer {
            it?.let {
                val action = HomeListFragmentDirections.actionHomeListFragmentToDetailsFragment(it)
                view?.findNavController()?.navigate(action)
            }
        })
    }

}
