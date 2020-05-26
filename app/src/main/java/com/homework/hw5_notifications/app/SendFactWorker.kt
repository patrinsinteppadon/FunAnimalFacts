package com.homework.hw5_notifications.app

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class SendFactWorker(private val context: Context, workParams: WorkerParameters): Worker(context, workParams) {
    override fun doWork(): Result {
        Log.i("patrin", "Did this work? Let's find out")
        return Result.success()
    }
}