package com.homework.hw5_notifications.app

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlin.random.Random

class NotificationManager(private val context: Context) {
    companion object { const val FACTS_CHANNEL_ID = "528491"}
    private val notificationMgrCompat = NotificationManagerCompat.from(context)
    init {
        createChannel()
    }

    private fun createChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Animal Facts Notifications"
            val descriptionText = "Educational messages about animals"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(FACTS_CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            notificationMgrCompat.createNotificationChannel(channel)
        }
    }

    /**
     * starts a repeating background task after 5 seconds
     * this task runs every 20 min, and only while phone is charging
     */
    fun beginBackgroundTask() {
        Log.i("patrin", "Sending animal facts your way")




        // notes about the notification
        // each notification's title is "Fun Animal Facts #" + (i + 1)
        // each notification's content is animalFacts[i]
    }

    /**
     * sends a single notification
     */
    fun sendNotification() {
        // notes about the notification
        // each notification's title is "Fun Animal Facts #" + (i + 1)
        // each notification's content is animalFacts[i]





        /*
        val dealsIntent = Intent(context, DealsActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            putExtra("NOTIF_DEAL", "fifty percent off!")
        }
        val pendingDealsIntent = PendingIntent.getActivity(context, 1234, dealsIntent, PendingIntent.FLAG_UPDATE_CURRENT)

        var notification = NotificationCompat.Builder(context, FUN_CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Little Timmy")
            .setContentText("Are we thereeee yettttt")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingDealsIntent) // launches this Activity when notifi is clicked
            .setAutoCancel(true)
            .build()

        // calling many times will post many notifications
        // set a unique id to make it update instead of post another
        notificationMgrCompat.notify(Random.nextInt(), notification) */
    }
}