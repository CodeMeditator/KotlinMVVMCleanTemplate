package com.android.kotlinmvvmcleantemplate.data.entity

import android.os.Message

/**
 * @author: CodeMeditator
 * @desc: It's either moshi or gson, but moshi is a better fit for kotlin maybe.
 */

class JsonModel {
    var message: String? = ""
    var data: MutableList<JsonObjectModel>? = null

    data class JsonObjectModel(
        val title: String = "",
        val video_id: String = "",
        val video_duration: Int = 0,
        val publish_time: Long = 0,
        val video_detail_info: VideoDetailInfoObjectModel? = null,
        val user_info: UserInfoObjectModel? = null
    )

    data class VideoDetailInfoObjectModel(
        val video_watch_count: Int = 0,
    )

    data class UserInfoObjectModel(
        val name: String = "",
    )
}
