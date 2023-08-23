package com.android.kotlinmvvmcleantemplate.data.entity

data class VideoList(
    val return_count: Int = 0, val message: String = "", val data: List<Video> = listOf()
)

data class Video(
    val title: String = "",
    val video_id: String = "",
    val video_duration: Int = 0,
    val publish_time: Long = 0,
    val video_detail_info: VideoDetailInfo? = null,
    val user_info: UserInfo? = null
)

data class VideoDetailInfo(
    val video_watch_count: Int = 0,
)

data class UserInfo(
    val name: String = "",
)
