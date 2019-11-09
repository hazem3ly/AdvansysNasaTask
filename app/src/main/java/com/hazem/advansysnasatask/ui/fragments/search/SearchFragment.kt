package com.hazem.advansysnasatask.ui.fragments.search

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment

import com.hazem.advansysnasatask.R
import com.hazem.advansysnasatask.databinding.SearchFragmentBinding
import com.hazem.advansysnasatask.extension.BindingFragment
import com.hazem.advansysnasatask.extension.ThemeHelper
import androidx.databinding.adapters.SearchViewBindingAdapter.setOnQueryTextListener
import androidx.core.view.MenuItemCompat.getActionView
import android.content.Context.SEARCH_SERVICE
import androidx.core.content.ContextCompat.getSystemService
import android.app.SearchManager
import android.content.Context
import android.widget.SearchView
import android.widget.Toast
import com.hazem.advansysnasatask.ui.fragments.home.HomeListViewModel
import com.hazem.advansysnasatask.ui.fragments.home.HomeListViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance


class SearchFragment : BindingFragment<SearchFragmentBinding>(), KodeinAware {
    override val kodein: Kodein by closestKodein()
    private val viewModelFactory: HomeListViewModelFactory by instance()
    override val layoutResId: Int
        get() = R.layout.search_fragment

    private lateinit var viewModel: HomeListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.search_menu, menu)
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)

        val searchView = menu.findItem(R.id.app_bar_search).actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.search(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.search(newText)
                return true
            }


        })

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(HomeListViewModel::class.java)
        binding.vm = viewModel
        view?.setOnClickListener {
            ThemeHelper.applyTheme(ThemeHelper.darkMode)
        }
    }

}
