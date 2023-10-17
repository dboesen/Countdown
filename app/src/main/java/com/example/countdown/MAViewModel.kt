package com.example.countdown

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MAViewModel: ViewModel() {

    private lateinit var  timer: CountDownTimer

    private val _seconds = MutableLiveData<Int>()
    fun seconds(): LiveData<Int>{
        return _seconds
    }

    private val _finished = MutableLiveData<Boolean>()
    fun finished(): LiveData<Boolean>{
        return _finished
    }

    fun startTimer(){
        timer = object : CountDownTimer(20000,1000){
            override fun onTick(millisUntilFinished: Long) {
                _seconds.value = (millisUntilFinished/1000).toInt()
            }

            override fun onFinish() {
                _finished.value = true
            }

        }.start()
    }

    fun stopTimer(){
        timer.cancel()
    }

}