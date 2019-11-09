package com.hazem.advansysnasatask.ui.fragments.home

import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.hazem.advansysnasatask.data.repo.RepositoryApi
import com.hazem.advansysnasatask.extension.SingleLiveEvent
import com.hazem.advansysnasatask.model.GenelabResponseListModel
import com.hazem.advansysnasatask.model.GenelabResponseModel

class HomeListViewModel(private val repository: RepositoryApi) : ViewModel() {

    val loading = repository.loading
    val errorMsg = repository.errorLiveData
    val list = repository.geneLabLiveData

    val searchList = MutableLiveData<GenelabResponseListModel>()

    val error = MutableLiveData<Boolean>(false)

    val itemDetailsCallback = SingleLiveEvent<GenelabResponseModel?>()

    init {
        error.postValue(false)
        repository.getGeneLabData()
        errorMsg.observeForever {
            error.postValue(true)
        }

        searchList.observeForever {
            Log.d("", "")
        }
    }

    fun retry() {
        error.postValue(false)
        repository.getGeneLabData()
    }

    fun itemClicked(item: GenelabResponseModel) {
        itemDetailsCallback.postValue(item)
    }

    fun search(query: String?) {
        if (!checkQuery(query)) return
        val items = list.value
        if (items != null && items.list.isNotEmpty()) {
            val filtered = items.list.filter {
                it.StudyTitle.contains(query!!, true)
            }
            searchList.postValue(GenelabResponseListModel(filtered))
        }
    }

    private fun checkQuery(query: String?): Boolean {
        if (query == null) return false
        if (query.isEmpty()) {
            searchList.postValue(list.value)
            return false
        }

        if (checkQuakyRedundancy(query)) return false

        return true
    }

    private fun checkQuakyRedundancy(query: String): Boolean {
        val chars = query.toCharArray()
        chars.forEachIndexed { index, c ->
            if (chars.size < index + 2) {
                val nextChar = chars[index + 1]
                val nextNextChar = chars[index + 2]
                if (c == nextChar && nextChar == nextNextChar) return true
            }
        }
        return false
    }

}
