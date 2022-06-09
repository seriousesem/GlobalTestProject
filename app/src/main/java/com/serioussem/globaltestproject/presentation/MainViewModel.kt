package com.serioussem.globaltestproject.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.serioussem.globaltestproject.data.model.ApiModel
import com.serioussem.globaltestproject.domain.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewScoped
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    private var mutableData: MutableLiveData<ApiModel> = MutableLiveData<ApiModel>()
    val data: LiveData<ApiModel> = mutableData

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            mutableData.postValue(repository.fetchData()) 
        }
    }
}