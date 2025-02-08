package com.example.realtodo

import java.sql.Date
import java.time.Instant

object TodoManager {

    private var _todolist = mutableListOf<TodoData>()

    fun showTodoList() : List<TodoData>{
        return _todolist
    }

    fun addingTodo(des : String){
        _todolist.add(TodoData(System.currentTimeMillis().toInt(), des, Date.from(Instant.now())))
    }

    fun deleteTodo (id : Int){
        _todolist.removeIf {
            it.id == id
        }
    }
}