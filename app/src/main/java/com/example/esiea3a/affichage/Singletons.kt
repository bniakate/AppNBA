package com.example.esiea3a.affichage

import com.example.esiea3a.affichage.LegendApplication.Companion.context
import com.example.esiea3a.affichage.api.LegendApi
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

class Singletons {
    companion object{

        var cache: Cache = Cache(File(context?.cacheDir, "responses"),10 * 1024 * 1024)
        val okhttpClient: OkHttpClient = OkHttpClient().newBuilder()
            .cache(cache)
            .build()
       val legendApi: LegendApi = Retrofit.Builder()
            .baseUrl("https://www.balldontlie.io/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okhttpClient)
            .build()
            .create(LegendApi::class.java)

    }
}
