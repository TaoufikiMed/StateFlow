package com.example.stateflow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TimerViewModel : ViewModel() {
    private val _timerTextView = MutableStateFlow<Int>(0)
    val timerTextView : StateFlow<Int> =_timerTextView

    fun startTimer(){
        val list= listOf<Int>(1,1,1,1,2,2,3,3,3,4,5,5,5,5)
        viewModelScope.launch {
            for (i in list){
                _timerTextView.emit(i)
                delay(1000)
            }
        }
    }
}