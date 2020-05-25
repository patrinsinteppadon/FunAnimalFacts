package com.homework.hw5_notifications.app

import android.content.Context
import android.util.Log

class NotificationManager(context: Context) {

    /**
     * starts a repetitive background task after 5 seconds
     * this task runs every 20 min, and only while phone is charging
     */
    fun beginBackgroundTask() {
        Log.i("patrin", "Sending animal facts your way")




        // notes about the notification
        // each notification's title is "Fun Animal Facts #" + i
        // each notification's content is animalFacts[i]
    }
}