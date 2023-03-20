package com.example.stateflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var timerViewModel: TimerViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        timerViewModel=ViewModelProvider(this).get(TimerViewModel::class.java)
        timerViewModel.startTimer()
        val tv = findViewById<TextView>(R.id.tv_timer)
        lifecycleScope.launchWhenStarted {
            timerViewModel.timerTextView.collect{
                tv.text=it.toString()
                Log.d("here ",it.toString())
            }
        }
    }
}