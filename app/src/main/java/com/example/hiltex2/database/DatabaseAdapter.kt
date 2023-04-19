package com.example.hiltex2.database

import android.content.Context
import android.util.Log
import com.example.hiltex2.TAG
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

class DatabaseAdapter @Inject constructor(@ActivityContext private val context: Context, val databaseService: DatabaseService) {
    fun log(message:String){
        Log.d(TAG, "Database Adapter message : $message")
        databaseService.log(message)

        Log.d(TAG, "Context available : $context")

    }
}