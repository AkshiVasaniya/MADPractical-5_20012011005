package com.example.madpractical5_20012011005

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.WindowCompat
import com.example.madpractical5_20012011005.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.Slider

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        val mediaPlayer: MediaPlayer = MediaPlayer.create(applicationContext, R.raw.song)
        val bPlay = findViewById<FloatingActionButton>(R.id.playBtn)
        val bStop: FloatingActionButton = findViewById(R.id.stopBtn)
//        val bRight: Button = findViewById(R.id.rightBtn)
//        val bLeft: Button = findViewById(R.id.leftBtn)

        bPlay.setOnClickListener{
            play()

        }
        bStop.setOnClickListener{
            stop()
        }
    }

    fun play(){
        Intent(applicationContext, MediaService::class.java).putExtra(MediaService.DATA_KEY, MediaService.DATA_VALUE).apply {
            startService(this)
        }
    }

    fun stop(){
        Intent(applicationContext, MediaService::class.java).apply {
            stopService(this)
        }
    }
}