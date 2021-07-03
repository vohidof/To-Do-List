package com.example.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        add_to_do.setOnClickListener {
            startActivity(Intent(this, AddToDoActivity::class.java))
        }
        to_do_list.setOnClickListener {
            startActivity(Intent(this, ListToDoActivity::class.java))
        }
    }
}