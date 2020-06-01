package com.example.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.todo.data.Todo
import com.example.todo.data.TodoDatabase
import com.example.todo.data.TodoRepository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var adapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(this, TodoDatabase::class.java, "database_name").build()
        val dao = db.todoDao()
        val repository = TodoRepository(dao)
        mainViewModel = MainViewModel(repository)

        adapter = RecyclerAdapter()
        main_recycler_view.layoutManager = LinearLayoutManager(this)
        main_recycler_view.adapter = adapter
        main_recycler_view.setHasFixedSize(true)

        add_item_button.setOnClickListener {
            mainViewModel.insert(Todo(0, submit_text.text.toString()))
        }

        mainViewModel.todoList.observe(this, Observer {
            adapter.setItem(it)
        })

    }
}
