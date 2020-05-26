package com.example.todo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val todo = MutableLiveData<String>()

    fun addItem(item: String) {
        todo.value = item
    }
}