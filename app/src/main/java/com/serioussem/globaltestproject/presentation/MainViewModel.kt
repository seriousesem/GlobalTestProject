package com.serioussem.globaltestproject.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.serioussem.globaltestproject.data.model.ApiModel
import com.serioussem.globaltestproject.domain.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private var mutableData: MutableLiveData<String> = MutableLiveData<String>()
    val data: LiveData<String> = mutableData

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch(Dispatchers.IO) {
            mutableData.postValue(repository.loadData())
        }
    }
}