package com.android.kotlinmvvmcleantemplate.network.service

import com.android.kotlinmvvmcleantemplate.data.entity.VideoList
import retrofit2.http.GET
import retrofit2.http.Query

interface VideoService {
    @GET("video/m/search/search_content/")
    suspend fun videos(
        @Query("aid") aid: Int = 0,
        @Query("keyword") keyword: String = "",
        @Query("device_id") device_id: String = "",
        @Query("offset") offset: Int = 0,
        @Query("count") count: Int = 0,
    ): VideoList
}