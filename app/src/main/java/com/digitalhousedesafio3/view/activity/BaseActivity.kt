package com.digitalhousedesafio3.view.activity

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    private var showActionBarBackButton: Boolean = false

    fun enableActionBarBackButton(enabled: Boolean) {
        this.showActionBarBackButton = enabled
        if (showActionBarBackButton) {
            supportActionBar?.setHomeButtonEnabled(true)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        if (showActionBarBackButton)
            onBackPressed()
        return true
    }

    private fun setPortraitOrientation() {
        // define a orientação de tela como retrato
        this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // trava a orientação de tela para todas as activities que herdar dessa
        this.setPortraitOrientation()
    }

}