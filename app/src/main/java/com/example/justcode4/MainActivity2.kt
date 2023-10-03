package com.example.justcode4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import com.example.justcode4.databinding.ActivityMain2Binding
import java.util.*

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    private var seconds:Int=0
    private var running:Boolean=false
    private var wasRunning:Boolean=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.e(this.javaClass.name,">>> onCreate")

        with(binding){
            pauseButton.setOnClickListener{
                pauseClick()
            }
            startButton.setOnClickListener{
                startClick()
            }
            resetButton.setOnClickListener{
                resetClick()
            }
        }

        savedInstanceState?.let{
            seconds=it.getInt(State.SECONDS.name)
            running=it.getBoolean(State.RUNNING.name)
            wasRunning=it.getBoolean(State.WAS_RUNNING.name)
        }
        runTimer()

    }

    private fun runTimer(){
        val handler= Handler(Looper.getMainLooper())
        handler.post(object :Runnable {
            override fun run(){
                val minutes=(seconds%3600)/60
                val time=String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds)
                binding.timeView.text=time

                if(running) seconds++
                handler.postDelayed(this,1000)

            }
        })
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(State.SECONDS.name,seconds)
        outState.putBoolean(State.RUNNING.name,running)
        outState.putBoolean(State.WAS_RUNNING.name,running)
        super.onSaveInstanceState(outState)
    }
    private fun resetClick() {
       // Toast.makeText(this,"Pause",Toast.LENGTH_SHORT).show()
    seconds=0
        running=false

    }

    private fun startClick() {
      //  Toast.makeText(this,"Start",Toast.LENGTH_SHORT).show()
    running=true
    }

    private fun pauseClick() {
        //Toast.makeText(this,"Reset",Toast.LENGTH_SHORT).show()
    running=false
    }


    override fun onStart() {
        super.onStart()
        Log.e(this.javaClass.name,">>> onStart")

    }

    override fun onResume() {
        super.onResume()
        running=wasRunning
        Log.e(this.javaClass.name,">>> onResume")
    }

    override fun onPause() {
        super.onPause()
        running=false
        Log.e(this.javaClass.name,">>> onPause")
    }

    override fun onStop() {
        super.onStop()
        running=false
        Log.e(this.javaClass.name,">>> onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(this.javaClass.name,">>> onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        running=true
        Log.e(this.javaClass.name,">>> onRestart")
    }
}

enum class State {
    RUNNING,SECONDS,WAS_RUNNING
}