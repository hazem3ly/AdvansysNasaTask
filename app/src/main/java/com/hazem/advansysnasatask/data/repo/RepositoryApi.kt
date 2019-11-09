package com.hazem.advansysnasatask.data.repo

import androidx.lifecycle.LiveData
import com.hazem.advansysnasatask.model.GenelabResponseListModel

interface RepositoryApi {
    val errorLiveData: LiveData<String>
    val loading: LiveData<Boolean>
    val geneLabLiveData: LiveData<GenelabResponseListModel>
    fun getGeneLabData(): LiveData<GenelabResponseListModel>
}