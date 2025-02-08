package com.example.realtodo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TodoviewModel : ViewModel(){

    private var todoList = MutableLiveData<List<TodoData>>()
    val todolist : LiveData<List<TodoData>> = todoList

    fun showTodoList(){
        todoList.value = TodoManager.showTodoList().reversed()
    }

    fun addingTodo(des : String){
        TodoManager.addingTodo(des)
        showTodoList()
    }

    fun deleteTodo (id : Int){
        TodoManager.deleteTodo(id)
        showTodoList()
    }
}