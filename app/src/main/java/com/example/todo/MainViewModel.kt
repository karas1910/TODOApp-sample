package com.example.todo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.data.Todo
import com.example.todo.data.TodoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(private val repository: TodoRepository) : ViewModel() {
    val todoList = repository.allTodoList

    fun insert(todo: Todo) = viewModelScope.launch {
        withContext(Dispatchers.IO){
            repository.insert(todo)
        }
    }
}