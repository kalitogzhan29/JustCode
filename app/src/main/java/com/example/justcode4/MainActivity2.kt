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

    }

    private fun runTimer(){
        val handler= Handler(Looper.getMainLooper())
        handler.post(object :Runnable {
            override fun run(){
                val minutes=(seconds%3600)/60
                val time=String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds)
                binding.timeView.text=time

            }
        })
    }
    private fun resetClick() {
        Toast.makeText(this,"Pause",Toast.LENGTH_SHORT).show()
    }

    private fun startClick() {
        Toast.makeText(this,"Start",Toast.LENGTH_SHORT).show()
    }

    private fun pauseClick() {
        Toast.makeText(this,"Reset",Toast.LENGTH_SHORT).show()
    }


    override fun onStart() {
        super.onStart()
        Log.e(this.javaClass.name,">>> onStart")

    }

    override fun onResume() {
        super.onResume()
        Log.e(this.javaClass.name,">>> onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e(this.javaClass.name,">>> onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e(this.javaClass.name,">>> onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(this.javaClass.name,">>> onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e(this.javaClass.name,">>> onRestart")
    }
}