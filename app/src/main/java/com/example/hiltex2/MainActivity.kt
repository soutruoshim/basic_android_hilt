package com.example.hiltex2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.hiltex2.database.DatabaseAdapter
import com.example.hiltex2.database.DatabaseService
import com.example.hiltex2.hilt.CallInterceptor
import com.example.hiltex2.network.NetworkAdapter
import com.example.hiltex2.network.NetworkService
import com.example.hiltex2.stats.StatsViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Singleton

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject lateinit var databaseAdapter: DatabaseAdapter

    //@Inject lateinit var networkAdapter: NetworkAdapter

    @CallInterceptor
    @Inject lateinit var networkService: NetworkService

   private val statsViewModel: StatsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG,"Database Adapter : $databaseAdapter")
        databaseAdapter.log("Hello Hilt")

        //networkAdapter.log("Interface binding")
       networkService.performNetworkCall()

        statsViewModel.statsLiveData.observe(this){
            stats->Log.d(TAG, "New stat coming in: $stats")
        }
        statsViewModel.startStatsCollection()
    }

    @Singleton
    @Inject
    fun directToDataBase(databaseService: DatabaseService){
        databaseService.log("Method Injection")
    }
}