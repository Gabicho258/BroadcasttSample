package com.example.broadcastsample

import android.content.IntentFilter
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.broadcastsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object {
        const val PATH = "com.example."
    }
    private lateinit var binding : ActivityMainBinding
    private var climaReceiver : ClimaReceiver = ClimaReceiver()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val filter = IntentFilter(ClimaReceiver.PATH)
        registerReceiver(climaReceiver, filter)
    }

}
