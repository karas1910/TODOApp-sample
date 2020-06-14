package com.example.todo.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TodoDao {

    @Insert
    suspend fun insert(todo: Todo)

    @Query("SELECT * FROM Todo")
    fun getAll(): LiveData<List<Todo>>

    @Delete
    suspend fun delete(todo: Todo)
}