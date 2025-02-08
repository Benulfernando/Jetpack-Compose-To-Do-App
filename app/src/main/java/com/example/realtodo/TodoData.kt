package com.example.realtodo

import java.sql.Date
import java.time.Instant

data class TodoData(
    var id: Int,
    var des: String,
    var realTime: java.util.Date
)
fun fakeTodo() : List<TodoData>{
    return listOf()
}