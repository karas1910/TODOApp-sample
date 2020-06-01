package com.example.todo.data

import androidx.annotation.WorkerThread

class TodoRepository(private val todoDao: TodoDao) {
    val allTodoList = todoDao.getAll()

    @WorkerThread
    suspend fun insert(todo: Todo) {
        todoDao.insert(todo)
    }
}