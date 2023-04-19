package com.example.hiltex2.hilt

import com.example.hiltex2.network.CallInterceptorImpl
import com.example.hiltex2.network.MyAppNetworkAdapter
import com.example.hiltex2.network.NetworkAdapter
import com.example.hiltex2.network.NetworkService
import com.example.hiltex2.network.ResponseInterceptorImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class NetworkModule {

    @CallInterceptor
    @Provides
    fun provideCallNetworkService():NetworkService{
        return NetworkService.Builder()
            .host("google.com")
            .protocol("Http")
            .interceptor(CallInterceptorImpl())
            .build()
    }

    @ResponseInterceptor
    @Provides
    fun provideResponseNetworkService():NetworkService{
        return NetworkService.Builder()
            .host("google.com")
            .protocol("Http")
            .interceptor(ResponseInterceptorImpl())
            .build()
    }
}

//class NetworkModule {
//    @Provides
//    fun provideNetworkService():NetworkService{
//         return NetworkService.Builder()
//             .host("google.com")
//             .protocol("Http")
//             .build()
//    }
//}
//abstract class NetworkModule {
//   @Binds
//   abstract fun bindNetworkAdapterImpl(myAppNetworkAdapter: MyAppNetworkAdapter):NetworkAdapter
//}