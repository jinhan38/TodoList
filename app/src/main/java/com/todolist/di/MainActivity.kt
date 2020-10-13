package com.todolist.di

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.todolist.data.Todo
import com.todolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val data = arrayListOf<Todo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.todoRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = TodoAdapter(data,
                onClickDeleteIcon = { deleteTodo(it) },
                onClickItem = { toggleTodo(it) }
            )
        }

        binding.button.setOnClickListener {
            addTodo()
        }


    }

    private fun addTodo() {
        val todo = Todo(binding.editText.text.toString())
        data.add(todo)
        binding.todoRecyclerView.adapter?.notifyDataSetChanged()
    }

    private fun deleteTodo(todo: Todo) {
        data.remove(todo)
        binding.todoRecyclerView.adapter?.notifyDataSetChanged()
    }

    private fun toggleTodo(todo: Todo) {
        todo.isDone = !todo.isDone
        binding.todoRecyclerView.adapter?.notifyDataSetChanged()
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}