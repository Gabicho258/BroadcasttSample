package com.example.emisor

import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.emisor.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    companion object {
        const val PATH = "com.example.broadcastsample.ClimaReceiver.PATH"
        const val TAG = "BroadcastReceiverMessage"
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val edtWeather = binding.edtWeather
        val btnSendMessage = binding.btnSendMessage

        btnSendMessage.setOnClickListener {
            val message = edtWeather.text.toString()
            sendWeatherInfo(message)
        }

    }
    fun sendWeatherInfo(weatherInfo: String) {
        val intent = Intent()
        intent.setComponent(ComponentName("com.example.app", "ClimaReceiver"))

        intent.setAction(PATH)
        intent.putExtra(PATH, weatherInfo)

        sendBroadcast(intent)
        Log.d(TAG, "Mensaje enviado")
    }
}