package com.homework.hw5_notifications.app

import android.app.Application

class FunFactsApp: Application() {
    lateinit var apiManager: APIManager
    lateinit var notificationManager: NotificationManager

    override fun onCreate() {
        super.onCreate()
        apiManager = APIManager(this)
        notificationManager = NotificationManager(this)
    }
}