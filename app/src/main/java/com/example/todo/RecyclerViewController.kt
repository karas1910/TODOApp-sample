package com.example.todo

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.observe
import com.airbnb.epoxy.TypedEpoxyController
import com.example.todo.data.Todo

class RecyclerViewController(
    lifecycleOwner: LifecycleOwner,
    viewModel: MainViewModel
) : TypedEpoxyController<List<Todo>>() {
    init {
        viewModel.todoList.observe(lifecycleOwner, ::setData)
    }
    override fun buildModels(data: List<Todo>?) {
        data?.forEach {
            RecyclerviewItemBindingModel_()
                .id(modelCountBuiltSoFar)
                .todoTitle(it.todoTitle)
                .addTo(this)
        }
    }
}