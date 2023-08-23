package com.boycoder.githubtrending.data.repository

import com.android.kotlinmvvmcleantemplate.data.entity.ResultX
import com.android.kotlinmvvmcleantemplate.data.entity.VideoList
import com.android.kotlinmvvmcleantemplate.data.source.remote.RemoteVideoDataSource
import com.android.kotlinmvvmcleantemplate.data.source.remote.VideoDataSource

/**
 * @author: CodeMeditator
 * @desc:
 */
class MainRepository(
    private val dataSource: VideoDataSource = RemoteVideoDataSource,
    private val localDataSource: VideoDataSource? = null
) : IRepository {
    override suspend fun getVideoList(): ResultX<VideoList> {
        // 暂不处理缓存逻辑
        return dataSource.getVideos()
    }
}