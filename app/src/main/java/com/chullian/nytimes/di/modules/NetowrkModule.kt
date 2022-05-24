package com.chullian.nytimes.di.modules

import com.chullian.nytimes.BuildConfig
import com.chullian.nytimes.data.network.ApiServices
import com.chullian.nytimes.data.network.BASE_URL
import com.chullian.nytimes.data.network.NETWORK_TIMEOUT
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by binMammootty on 23/05/2022.
 */

@Module @Singleton @InstallIn(SingletonComponent::class)
class NetowrkModule{

    @Singleton
    @Provides
    fun provideJson() = Json {
        ignoreUnknownKeys = true

    }

    @Singleton
    @Provides
    fun provideRetrofitService(json: Json): ApiServices {
        val interceptor = HttpLoggingInterceptor()
        if(BuildConfig.DEBUG) {interceptor.level = HttpLoggingInterceptor.Level.BODY
        }else interceptor.level = HttpLoggingInterceptor.Level.NONE
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .callTimeout(NETWORK_TIMEOUT, TimeUnit.SECONDS)
            .build()
        val contentType = "application/json".toMediaType()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(json.asConverterFactory(contentType))
            .build()
            .create(ApiServices::class.java)
    }

}