package com.example.todo.di

import android.content.Context
import androidx.room.Room
import com.example.todo.data.TodoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class DatabaseModule() {

    @Singleton
    @Provides
    fun provideTodoDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context,
            TodoDatabase::class.java,
            "database_name")
            .build()

    @Singleton
    @Provides
    fun provideTodoDao(todoDatabase: TodoDatabase) = todoDatabase.todoDao()
}