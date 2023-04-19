package com.example.hiltex2

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
const val TAG = "Hilt Debug"
@HiltAndroidApp
class HiltExApp:Application() {
}