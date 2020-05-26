package com.example.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mainViewModel = MainViewModel()
    lateinit var adapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = RecyclerAdapter()
        main_recycler_view.layoutManager = LinearLayoutManager(this)
        main_recycler_view.adapter = adapter
        main_recycler_view.setHasFixedSize(true)

        add_item_button.setOnClickListener {
//            mainViewModel.addItem(submit_text.text.toString())
            adapter.setItem(submit_text.text.toString())
        }

        mainViewModel.todo.observe(this, Observer {
            adapter.setItem(it)
        })

    }
}
