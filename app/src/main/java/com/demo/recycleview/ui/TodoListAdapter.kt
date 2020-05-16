package com.demo.recycleview.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.demo.recycleview.R
import com.demo.recycleview.models.Todo
import kotlinx.android.synthetic.main.listitem_todo.view.*
import java.text.SimpleDateFormat
import java.util.*

class TodoListAdapter : ListAdapter<Todo, TodoListAdapter.TodoViewHolder>(
    DiffCallback
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.listitem_todo, parent, false)
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.view.text_value.text = getItem(position).value
        holder.view.text_date.text =
            SimpleDateFormat("yyyy-MM-dd", Locale("hu")).format(getItem(position).date)
    }

    inner class TodoViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    companion object DiffCallback : DiffUtil.ItemCallback<Todo>() {
        override fun areItemsTheSame(oldItem: Todo, newItem: Todo): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Todo, newItem: Todo): Boolean {
            return oldItem == newItem
        }
    }

}