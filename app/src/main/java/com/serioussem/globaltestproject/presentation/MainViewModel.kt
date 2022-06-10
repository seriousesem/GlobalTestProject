package com.serioussem.globaltestproject.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.serioussem.globaltestproject.data.model.ApiModel
import com.serioussem.globaltestproject.data.model.MonoModel
import com.serioussem.globaltestproject.domain.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private var mutableData: MutableLiveData<MonoModel?> = MutableLiveData<MonoModel?>()
    val data: LiveData<MonoModel?> = mutableData

    init {
        fetchData()
    }

    fun fetchData() {
        viewModelScope.launch(Dispatchers.Main) {
            mutableData.value = (repository.fetchData())
        }
    }
}