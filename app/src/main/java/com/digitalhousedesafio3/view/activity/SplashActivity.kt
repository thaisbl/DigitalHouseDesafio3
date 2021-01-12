package com.digitalhousedesafio3.view.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.digitalhousedesafio3.databinding.ActivitySplashBinding
import kotlinx.coroutines.*
import java.util.concurrent.TimeUnit

class SplashActivity : AppCompatActivity() {
    private val activityScope: CoroutineScope = CoroutineScope(Dispatchers.Main)
    private lateinit var binding: ActivitySplashBinding

    private fun startSplashScope() {
        activityScope.launch {

            delay(TimeUnit.SECONDS.toMillis(3))

            startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
            finish()
        }
    }

    private fun clearSplashScope() {
        activityScope.cancel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        startSplashScope()
    }

    override fun onPause() {
        clearSplashScope()
        super.onPause()
    }
}