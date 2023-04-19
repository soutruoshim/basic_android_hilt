package com.example.hiltex2.network

import android.util.Log
import com.example.hiltex2.TAG
import javax.inject.Inject

class MyAppNetworkAdapter @Inject constructor():NetworkAdapter {
    override fun log(message: String) {
        Log.d(TAG, "MyAppnetworkadpater: $message")
    }
}