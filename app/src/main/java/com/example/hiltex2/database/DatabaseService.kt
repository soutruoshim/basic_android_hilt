package com.example.hiltex2.database

import android.util.Log
import com.example.hiltex2.TAG
import javax.inject.Inject

class DatabaseService @Inject constructor() {
    fun log(message:String){
        Log.d(TAG, "Database Service message : $message")
    }
}