package com.example.strings_themes_color_dimensions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.strings_themes_color_dimensions.databinding.ActivityMainBinding
import com.example.strings_themes_color_dimensions.databinding.ItemTodoBinding


class TodoAdapter(private val todos: MutableList<Todo>) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    inner class TodoViewHolder(val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val binding = ItemTodoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TodoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val todo = todos[position]

        holder.binding.tvTitle.text = todo.title
        holder.binding.cbDone.isChecked = todo.isChecked
    }

    override fun getItemCount(): Int = todos.size
}
