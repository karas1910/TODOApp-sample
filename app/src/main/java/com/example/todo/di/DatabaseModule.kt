package com.example.todo.di

import android.content.Context
import androidx.room.Room
import com.example.todo.data.TodoDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule() {

    @Singleton
    @Provides
    fun provideTodoDatabase(context: Context) =
        Room.databaseBuilder(context,
            TodoDatabase::class.java,
            "database_name")
            .build()

    @Singleton
    @Provides
    fun provideTodoDao(todoDatabase: TodoDatabase) = todoDatabase.todoDao()
}