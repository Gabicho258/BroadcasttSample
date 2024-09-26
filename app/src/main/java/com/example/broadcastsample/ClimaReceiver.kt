package com.example.broadcastsample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class ClimaReceiver : BroadcastReceiver() {
    companion object {
        const val PATH = "com.example.broadcastsample.ClimaReceiver.PATH"
    }
    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        val message = intent.getStringExtra(PATH)
        Log.d("Mensaje recibido", message.toString())
    }
}