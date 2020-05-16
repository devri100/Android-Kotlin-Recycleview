package com.demo.recycleview.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.demo.recycleview.MainActivity
import com.demo.recycleview.R
import com.demo.recycleview.ViewModelFactory
import com.demo.recycleview.models.Todo
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_list.*
import java.util.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class ListFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val listAdapter = TodoListAdapter()
        val list = mutableListOf(
            Todo(1, "Abc", Date()),
            Todo(2, "Dbc", Date()),
            Todo(3, "Ebc", Date()),
            Todo(4, "Fbc", Date()),
            Todo(5, "Gbc", Date())
        )
        ItemTouchHelper(object: ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
               list.removeAt(viewHolder.adapterPosition)
               //listAdapter.submitList(list)
                listAdapter.notifyItemRemoved(viewHolder.adapterPosition)
            }

        }).attachToRecyclerView(recycleview)
        recycleview.adapter = listAdapter
        listAdapter.submitList(list)

        fab.setOnClickListener {
            list.add(Todo(list.last().id + 1L, "Új", Date()))
            listAdapter.notifyItemInserted(list.size - 1)
        }

    }

}
