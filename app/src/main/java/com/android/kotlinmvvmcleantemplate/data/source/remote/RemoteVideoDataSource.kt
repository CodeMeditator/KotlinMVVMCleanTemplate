package com.android.kotlinmvvmcleantemplate.data.source.remote

import android.util.Log
import com.android.kotlinmvvmcleantemplate.data.entity.ResultX
import com.android.kotlinmvvmcleantemplate.data.entity.ResultX.*
import com.android.kotlinmvvmcleantemplate.data.entity.VideoList
import com.android.kotlinmvvmcleantemplate.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object RemoteVideoDataSource : VideoDataSource {
    const val TAG = "RemoteVideoDataSource"
    override suspend fun getVideos(): ResultX<VideoList> = withContext(
        Dispatchers.IO
    ) {
        try {
            Success(
                RetrofitClient.service.videos(
                    3586,
                    "火影忍者",
                    "",
                    0,
                    10,
                )
            )
        } catch (e: Exception) {
            Log.e(TAG, e.message, e)
            Error(e)
        }
    }

}