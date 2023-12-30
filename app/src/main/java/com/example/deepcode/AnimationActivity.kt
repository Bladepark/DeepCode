package com.example.deepcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

abstract class AnimationActivity(private val transitionMode: TransitionMode = TransitionMode.NONE) : AppCompatActivity() {

    enum class TransitionMode {
        NONE,
        LEFTTORIGHT,
        DOWNTOUP
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        when(transitionMode) {
            TransitionMode.LEFTTORIGHT -> overridePendingTransition(R.anim.left_to_right_enter, R.anim.none)
            TransitionMode.DOWNTOUP -> overridePendingTransition(R.anim.down_to_up, R.anim.none)
            else -> Unit
        }
    }

    override fun finish() {
        super.finish()

        when (transitionMode) {
            TransitionMode.LEFTTORIGHT -> overridePendingTransition(R.anim.none, R.anim.left_to_right_exit)
            TransitionMode.DOWNTOUP -> overridePendingTransition(R.anim.none, R.anim.up_to_down)
            else -> Unit
        }
    }
}