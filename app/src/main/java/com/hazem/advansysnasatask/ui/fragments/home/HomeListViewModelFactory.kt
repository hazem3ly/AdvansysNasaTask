package com.hazem.advansysnasatask.ui.fragments.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hazem.advansysnasatask.data.repo.RepositoryApi

class HomeListViewModelFactory(
    private val repository: RepositoryApi
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeListViewModel(repository) as T
    }
}