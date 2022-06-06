package com.example.gel_beta.api


import com.example.gel_beta.model.google.nearbySearch.NearbySearch
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GoogleMethods {
    @GET("place/nearbysearch/json")
    fun getNearbySearch(
        @Query("location") location: String,
        @Query("radius") radius: String,
        @Query("type") types: String,
        @Query("key") key: String
    ): Call<NearbySearch>
}