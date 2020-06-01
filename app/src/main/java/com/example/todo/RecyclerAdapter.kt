package com.example.todo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.data.Todo
import kotlinx.android.synthetic.main.recyclerview_item.view.*

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>(){

    private val todoList = mutableListOf<Todo>()

    fun setItem(items: List<Todo>) {
        todoList.clear()
        todoList.addAll(items)
        notifyDataSetChanged()
    }

    class RecyclerViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        val sampleImg = view.sampleImg
        val sampleTxt = view.sampleTxt
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val item = layoutInflater.inflate(R.layout.recyclerview_item, parent, false)
        return RecyclerViewHolder(item)
    }

    override fun getItemCount(): Int = todoList.size

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.view.let{
            it.sampleImg.setImageResource(R.mipmap.ic_launcher_round)
            it.sampleTxt.text = todoList[position].todoTitle
        }
    }
}
