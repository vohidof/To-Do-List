package com.example.todolist

import Adapter.ExpandableAdapter
import Cache.MySharedPreference
import Models.TodoPlan
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_list_to_do.*

class ListToDoActivity : AppCompatActivity() {

    lateinit var map: HashMap<String, ArrayList<String>>
    lateinit var titleList:ArrayList<String>

    lateinit var openArray:ArrayList<String>
    lateinit var developmentArray:ArrayList<String>
    lateinit var uploadingArray:ArrayList<String>
    lateinit var rejectArray:ArrayList<String>
    lateinit var closedArray:ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_to_do)

        expanded_menu.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
            val intent = Intent(this, AboutListToDo::class.java)
            intent.putExtra("name", map[titleList[groupPosition]]?.get(childPosition))
            startActivity(intent)
            true
        }
    }


    private fun keshdanArrayga() {
        map = HashMap()
        titleList = ArrayList()
        titleList.add("Open")
        titleList.add("Development")
        titleList.add("Uploading")
        titleList.add("Reject")
        titleList.add("Close")

        openArray = ArrayList()
        developmentArray = ArrayList()
        uploadingArray = ArrayList()
        rejectArray = ArrayList()
        closedArray = ArrayList()

        var planArray = ArrayList<TodoPlan>()
        planArray = MySharedPreference.obektString
        println(planArray)
        var nameArray = ArrayList<TodoPlan>()
        for (todoPlan in planArray) {
            if (todoPlan.level == "Open"){
                openArray.add(todoPlan.name)
            }
            if (todoPlan.level == "Development"){
                developmentArray.add(todoPlan.name)
            }
            if (todoPlan.level == "Uploading"){
                uploadingArray.add(todoPlan.name)
            }
            if (todoPlan.level == "Reject"){
                rejectArray.add(todoPlan.name)
            }
            if (todoPlan.level == "Close"){
                closedArray.add(todoPlan.name)
            }
        }

        map[titleList[0]] = openArray
        map[titleList[1]] = developmentArray
        map[titleList[2]] = uploadingArray
        map[titleList[3]] = rejectArray
        map[titleList[4]] = closedArray

    }


    override fun onStart() {
        super.onStart()
        MySharedPreference.init(this)
        keshdanArrayga()
        Log.i("axborot", "onStart metodi")
        val spinerAdapter1 = ExpandableAdapter(titleList, map)
        expanded_menu.setAdapter(spinerAdapter1)

    }
}