package com.hazem.advansysnasatask.data.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hazem.advansysnasatask.data.network.apiresponse.genelab.GenelabBaseResponse
import com.hazem.advansysnasatask.model.GenelabResponseModel
import com.hazem.advansysnasatask.model.GenelabResponseListModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class NetworkDataSourceImpl(
    private val apiService: ApiService
) : NetworkDataSource {
    private val _loading = MutableLiveData<Boolean>()
    override val loading: LiveData<Boolean>
        get() = _loading

    private val _genelabData = MutableLiveData<GenelabResponseListModel>()
    override val genelabData: LiveData<GenelabResponseListModel>
        get() = _genelabData

    override fun getGeneLabData() {
        _loading.postValue(true)
        charactersDisposable?.let { if (!it.isDisposed) it.dispose() }
        charactersDisposable =
            apiService.getGenelabData().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::bindList, this::handleError)
    }

    private var charactersDisposable: Disposable? = null

    private val _errorLoading = MutableLiveData<String>()
    override val errorLoading: LiveData<String>
        get() = _errorLoading


    private fun bindList(response: GenelabBaseResponse) {
        _loading.postValue(false)
        if (response.isSuccess()) {
            val list = ArrayList<GenelabResponseModel>()
            response.hits.hits.forEach {
                list.add(GenelabResponseModel.createCharacter(it))
            }
            _genelabData.postValue(GenelabResponseListModel(list))
        } else {
            _errorLoading.postValue("No Data Available")
        }
    }

    private fun handleError(e: Throwable) {
        _loading.postValue(false)
        _errorLoading.postValue(e.message ?: "Error Loading Data")
    }


}