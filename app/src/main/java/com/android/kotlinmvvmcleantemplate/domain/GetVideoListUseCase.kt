package com.android.kotlinmvvmcleantemplate.domain

import com.android.kotlinmvvmcleantemplate.data.entity.ResultX
import com.android.kotlinmvvmcleantemplate.data.entity.VideoList
import com.boycoder.githubtrending.data.repository.IRepository
import com.boycoder.githubtrending.data.repository.MainRepository

/**
 * @author:
 * @desc:
 */
class GetVideoListUseCase(private val repository: IRepository = MainRepository()) {
    suspend operator fun invoke(): ResultX<VideoList> {
        return repository.getVideoList()
    }
}