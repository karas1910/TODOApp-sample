package com.example.todo.data

import androidx.annotation.WorkerThread
import javax.inject.Inject

class TodoRepository @Inject constructor(private val todoDao: TodoDao) {
    val allTodoList = todoDao.getAll()

    @WorkerThread
    suspend fun insert(todo: Todo) {
        todoDao.insert(todo)
    }
}