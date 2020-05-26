package com.homework.hw5_notifications.app

import android.app.Application

class FunFactsApp: Application() {
    lateinit var factsManager: FactsManager
    lateinit var backgroundManager: BackgroundManager

    override fun onCreate() {
        super.onCreate()
        factsManager = FactsManager(this)
        backgroundManager = BackgroundManager(this)
    }
}