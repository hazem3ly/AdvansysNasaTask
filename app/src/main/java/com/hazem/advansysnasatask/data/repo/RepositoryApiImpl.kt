package com.hazem.advansysnasatask.data.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hazem.advansysnasatask.data.network.NetworkDataSource
import com.hazem.advansysnasatask.model.GenelabResponseListModel

class RepositoryApiImpl(
    private val networkDataSource: NetworkDataSource
) : RepositoryApi {

    private val _errorLiveData = MutableLiveData<String>()
    override val errorLiveData: LiveData<String>
        get() = _errorLiveData

    private val _loading = MutableLiveData<Boolean>()
    override val loading: LiveData<Boolean>
        get() = _loading

    private val _geneLabLiveData = MutableLiveData<GenelabResponseListModel>()
    override val geneLabLiveData: LiveData<GenelabResponseListModel>
        get() = _geneLabLiveData

    init {

        networkDataSource.errorLoading.observeForever {
            _errorLiveData.postValue(it)
        }

        networkDataSource.loading.observeForever {
            _loading.postValue(it)
        }

        networkDataSource.genelabData.observeForever {

            if (it.list.isEmpty()) {
                _errorLiveData.postValue("No Data Available")
            } else
                _geneLabLiveData.postValue(it)
        }
    }


    override fun getGeneLabData(): LiveData<GenelabResponseListModel> {
        networkDataSource.getGeneLabData()
        return networkDataSource.genelabData
    }

}