package com.android.kotlinmvvmcleantemplate.data.source.remote

import com.android.kotlinmvvmcleantemplate.data.entity.ResultX
import com.android.kotlinmvvmcleantemplate.data.entity.VideoList

interface VideoDataSource {
    suspend fun getVideos(): ResultX<VideoList>
}