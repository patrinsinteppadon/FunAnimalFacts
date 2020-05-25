package com.homework.hw5_notifications

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.homework.hw5_notifications.app.FunFactsApp
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Behavior of the app:
 *  - Fetches JSON from this link: https://raw.githubusercontent.com/echeeUW/codesnippets/master/funanimalfacts.json
 *  - "Send notifications" button that starts a background task
 */
class MainActivity : AppCompatActivity() {
    private lateinit var funFactsApp: FunFactsApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        funFactsApp = FunFactsApp()
//        funFactsApp.apiManager.getFacts()
        btnStart.setOnClickListener{ funFactsApp.notificationManager.beginBackgroundTask() }
    }

    /**
     * retrieves animal facts from the API. These are used as the notifications
     */
    private fun getFacts() {

    }

    /**
     * starts a repetitive background task after 5 seconds
     * this task runs every 20 min, and only while phone is charging
     */
    private fun beginBackgroundTask() {
        // start with 5 second delay
    }
}
