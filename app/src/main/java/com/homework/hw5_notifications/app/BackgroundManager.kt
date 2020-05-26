package com.homework.hw5_notifications.app

import android.content.Context
import android.util.Log
import androidx.work.Constraints
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

class BackgroundManager(private val context: Context) {
    companion object {const val FACTS_WORK_REQUEST_TAG = "ANIMAL_FUN_FACTS"}
    private var workManager = WorkManager.getInstance(context)

    /**
     * uses WorkManager.
     * starts a repeating background task after 5 seconds
     * this task runs every 20 min, and only while phone is charging
     */
    fun beginBackgroundTask() {
        val constraints = Constraints.Builder()
            .setRequiresCharging(true)
            .build()

        // This error says: "Cannot inline bytecode built with JVM target 1.8 into bytecode that is
        // being built with JVM target 1.6. Please specify proper '-jvm-target' option
        val workRequest = PeriodicWorkRequestBuilder<SendFactWorker>(20, TimeUnit.MINUTES)
            .setInitialDelay(5000, TimeUnit.MILLISECONDS)
            .setConstraints(constraints)
            .addTag(FACTS_WORK_REQUEST_TAG)
            .build()

        workManager.enqueue(workRequest)


    }
}

// notes about the notification
// each notification's title is "Fun Animal Facts #" + (i + 1)
// each notification's content is animalFacts[i]