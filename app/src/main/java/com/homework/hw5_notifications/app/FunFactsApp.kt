package com.homework.hw5_notifications.app

import android.app.Application

class FunFactsApp: Application() {
    lateinit var factsManager: FactsManager
    lateinit var notificationManager: NotificationManager

    override fun onCreate() {
        super.onCreate()
        factsManager = FactsManager(this)
        notificationManager = NotificationManager(this)
    }
}