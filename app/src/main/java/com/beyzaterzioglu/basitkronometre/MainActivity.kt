package com.beyzaterzioglu.basitkronometre

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.inputmethod.InputBinding

import com.beyzaterzioglu.basitkronometre.databinding.ActivityMainBinding
import kotlinx.coroutines.delay

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var number=0
    var runnable : Runnable= Runnable {} //boş bir runnable objesi oluşturuldu
    var handler : Handler= Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)


    }
    fun start(view: View){
        number=0 // her start dediğimizde number 0 oluyor.
        runnable = object : Runnable{
            override fun run() {
                number=number+1
                binding.textView2.text="Time : ${number}"

                handler.postDelayed(runnable,1000) // 1000 milis'te rötarlı oalrak işlemi yapar.


            }
        }
        handler.post(runnable) // runnable'ı başlat
        binding.durbutonu.isEnabled= false;

    }
    fun stop(view: View){
        binding.durbutonu.isEnabled=true;
        binding.textView2.text="Time : 0"
        handler.removeCallbacks(runnable)

    }
}
