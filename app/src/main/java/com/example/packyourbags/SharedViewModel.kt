package com.example.packyourbags

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    val searchQueryLiveData = MutableLiveData<String>()

    fun setSearchQuery(query: String) {
        searchQueryLiveData.value = query
    }
}