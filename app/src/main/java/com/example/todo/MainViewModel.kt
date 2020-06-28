package com.example.todo

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.data.Todo
import com.example.todo.data.TodoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel @ViewModelInject constructor(private val repository: TodoRepository) :
    ViewModel() {
    val todoList = repository.allTodoList

    fun insert(todo: Todo) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            repository.insert(todo)
        }
    }

    fun delete(todo: Todo) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            repository.delete(todo)
        }
    }
}