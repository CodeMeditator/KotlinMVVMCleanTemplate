package com.android.kotlinmvvmcleantemplate.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.kotlinmvvmcleantemplate.data.entity.ResultX
import com.android.kotlinmvvmcleantemplate.data.entity.VideoList
import com.android.kotlinmvvmcleantemplate.domain.GetVideoListUseCase
import kotlinx.coroutines.launch

/**
 * @author:
 * @desc:
 */

class MainViewModel(
    val getVideoListUseCase: GetVideoListUseCase = GetVideoListUseCase()
) : ViewModel() {
    val videos: LiveData<VideoList>
        get() = _videos
    private val _videos = MutableLiveData<VideoList>()

    fun loadVideos() {
        viewModelScope.launch {
            val result = getVideoListUseCase()
            Log.d("MainViewModel-->loadVideos()", result.toString())
            when (result) {
                is ResultX.Success -> {
                    _videos.value = result.data
                }

                is ResultX.Error -> {
                    _videos.value = VideoList()
                }

                is ResultX.Loading -> {
                    // show loading animation
                }
            }
        }
    }
}