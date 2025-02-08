package com.example.realtodo

import android.icu.text.SimpleDateFormat
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Locale

@Composable
fun TodoList(viewModel: TodoviewModel) {
    val todolist by viewModel.todolist.observeAsState()
    var TaskName by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp, 45.dp)
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 15.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically

        ){
            OutlinedTextField(value = TaskName, onValueChange = {TaskName = it} , label = { Text(text = "Add your task")})
            Button(onClick = {viewModel.addingTodo(TaskName)
                                        TaskName = ""},
                modifier = Modifier.padding(top = 5.dp)) {
                Text(text = "ADD")
            }
        }
        todolist?.let {
            LazyColumn(content = {
                itemsIndexed(it) { index : Int, item : TodoData ->
                    Todoitem(item = item, viewModel)
                }

            }
            )
        }?: Text(text = "No items yet",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 16.sp)

    }
}

@Composable
fun Todoitem(item : TodoData, viewModel: TodoviewModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.primary)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f),
        ) {
            Text(text = SimpleDateFormat("HH:mm:aa, dd/mm", Locale.ENGLISH).format(item.realTime), color = Color.LightGray, fontSize = 12.sp)
            Text(text = item.des, color = Color.White, fontSize = 20.sp)
        }
        IconButton(onClick = {viewModel.deleteTodo(item.id)}) {
            Image(painter = painterResource(id = R.drawable.baseline_delete_24), contentDescription = "Delete icon")
        }
    }
}