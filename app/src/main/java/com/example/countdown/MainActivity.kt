package com.example.countdown

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this).get(MAViewModel::class.java)
        val btnStart = findViewById<Button>(R.id.btnStart)
        val theNumber = findViewById<TextView>(R.id.txtNumber)

        viewModel.seconds().observe(this, Observer {
            theNumber.text = it.toString()
        })

        btnStart.setOnClickListener {
            viewModel.startTimer()
        }

        viewModel.finished().observe(this, Observer {
            if (it){
                Toast.makeText(this,"Timer has ended", Toast.LENGTH_LONG).show()
            }
        })

    }
}