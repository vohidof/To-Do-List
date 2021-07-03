package com.example.todolist

import Adapter.MySpinnerAdapter
import Cache.MySharedPreference
import Models.TodoPlan
import Models.User
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_to_do.*

class AddToDoActivity : AppCompatActivity() {

    lateinit var userArray:ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_to_do)

        title

        loadData()

        MySharedPreference.init(this)

        val spinerAdapter = MySpinnerAdapter(userArray)
        spinner.adapter = spinerAdapter

        btn_Save.setOnClickListener {
            val toDoName = edt_ToDoName.text.toString().trim()
            val toDoDescription = edt_ToDoDescription.text.toString().trim()
            val toDoCreateData = edt_ToDoData.text.toString().trim()
            val toDoDedline = edt_ToDoDeadline.text.toString().trim()

            val degree = userArray[spinner.selectedItemPosition]

            if (toDoName!="" && toDoCreateData!="" && toDoDedline!="" && toDoDescription!=""){
                val myList = MySharedPreference.obektString
                myList.add(TodoPlan(toDoName, toDoDescription, degree, toDoCreateData, toDoDedline, "Open"))
                println(myList)
                MySharedPreference.obektString = myList
                Toast.makeText(this, "Save", Toast.LENGTH_SHORT).show()
                finish()
            }else{
                Toast.makeText(this, "Error because editText is empty", Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun loadData() {
        userArray = ArrayList()
        userArray.add(User(-1, "To do degree"))
        userArray.add(User(R.drawable.ic_flag_red, "Urgent"))
        userArray.add(User(R.drawable.ic_flag_high, "High"))
        userArray.add(User(R.drawable.ic_flag_normal, "Normal"))
        userArray.add(User(R.drawable.ic_flag_low, "Low"))
    }
}