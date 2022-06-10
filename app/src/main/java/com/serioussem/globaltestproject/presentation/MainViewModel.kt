package com.serioussem.globaltestproject.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.serioussem.globaltestproject.data.model.MonoModel
import com.serioussem.globaltestproject.data.model.PrivatModel
import com.serioussem.globaltestproject.domain.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainViewModel (private val repository: Repository) : ViewModel() {

    private var mutableData: MutableLiveData<List<MonoModel>> = MutableLiveData<List<MonoModel>>()
    val data: LiveData<List<MonoModel>> = mutableData

    init {
        fetchData()
    }

    fun fetchData() {
        viewModelScope.launch(Dispatchers.IO) {
            mutableData.postValue(repository.fetchData())
        }
    }
}