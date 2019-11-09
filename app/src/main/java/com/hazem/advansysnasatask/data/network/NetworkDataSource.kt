package com.hazem.advansysnasatask.data.network

import androidx.lifecycle.LiveData
import com.hazem.advansysnasatask.model.GenelabResponseListModel

interface NetworkDataSource {
    val genelabData: LiveData<GenelabResponseListModel>
    val errorLoading: LiveData<String>
    val loading: LiveData<Boolean>
    fun getGeneLabData()
}