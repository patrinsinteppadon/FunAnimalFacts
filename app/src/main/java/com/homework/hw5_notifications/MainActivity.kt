package com.homework.hw5_notifications

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.homework.hw5_notifications.app.FunFactsApp
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Behavior of the app:
 *  - Fetches fun animal facts from this link: https://raw.githubusercontent.com/echeeUW/codesnippets/master/funanimalfacts.json
 *  - Click the "Send notifications" button to receive an animal fact notification every 20 min
 */
class MainActivity : AppCompatActivity() {
    private lateinit var funFactsApp: FunFactsApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // init apps and facts
        funFactsApp = application as FunFactsApp
        funFactsApp.factsManager.downloadFacts()

        btnStart.setOnClickListener{
            if (funFactsApp.factsManager.animalFacts.isNotEmpty()) {
                funFactsApp.notificationManager.beginBackgroundTask()
            } else { // error: animal facts did not load
                findViewById<TextView>(R.id.tvInstructions).text = getString(R.string.error_instructions)
            }
        }
    }
}
