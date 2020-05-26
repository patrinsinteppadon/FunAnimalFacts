package com.homework.hw5_notifications.app

import android.content.Context
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson

/**
 * Stores all fun animal facts that can be sent to the user.
 * On startup, retrieves these animal facts from an API using Volley.
 */
class FactsManager(private val context: Context) {
    var animalFacts: List<String> = emptyList()
    companion object {
        const val FUN_FACTS_URL = "https://raw.githubusercontent.com/echeeUW/codesnippets/master/funanimalfacts.json"
    }

    /**
     * retrieves animal facts from the API. These are used as the notifications
     */
    fun downloadFacts() {
        val queue = Volley.newRequestQueue(context)
        val request = StringRequest(
            Request.Method.GET, FUN_FACTS_URL,
            { response ->
                val responseAsObject = Gson().fromJson(response, ResponseObject::class.java)
                animalFacts = responseAsObject.animalFacts
            },
            {
                // error. Accommodated in MainActivity
            }
        )
        queue.add(request)
    }
}

data class ResponseObject(
    val animalFacts: List<String>
)