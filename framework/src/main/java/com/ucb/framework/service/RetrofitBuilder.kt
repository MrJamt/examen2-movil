package com.ucb.framework.service

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitBuilder(
    val context: Context,
) {
    private fun getRetrofit(url: String): Retrofit {
        val client =
            OkHttpClient
                .Builder()
                .addInterceptor(ChuckerInterceptor.Builder(context).build())
                .build()

        return Retrofit
            .Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(url)
            .client(client)
            .build()
    }
}
