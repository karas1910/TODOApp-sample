package com.example.todo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todo.data.Todo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by lazy {
        TodoApplication.component.mainViewModel()
    }
    private lateinit var adapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = RecyclerAdapter()
        main_recycler_view.let {
            it.layoutManager = LinearLayoutManager(this)
            it.adapter = adapter
            it.setHasFixedSize(true)
        }

        add_item_button.setOnClickListener {
            mainViewModel.insert(Todo(0, submit_text.text.toString()))
        }

        mainViewModel.todoList.observe(this, Observer {
            adapter.setItem(it)
        })

    }
}
