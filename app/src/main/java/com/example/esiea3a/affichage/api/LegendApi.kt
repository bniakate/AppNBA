package com.example.esiea3a.affichage.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface LegendApi {
    @GET("teams")
    fun getLegendList(): Call<LegendListResponse>

    @GET("teams/{id}")
    fun getLegendDetail(@Path("id") id: Int): Call<LegendDetailResponse>
}