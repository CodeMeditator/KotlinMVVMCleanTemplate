package com.boycoder.githubtrending.data.repository

import com.android.kotlinmvvmcleantemplate.data.entity.ResultX
import com.android.kotlinmvvmcleantemplate.data.entity.VideoList

/**
 * @author: CodeMeditator
 * @desc:
 */
interface IRepository {
    suspend fun getVideoList(): ResultX<VideoList>
}