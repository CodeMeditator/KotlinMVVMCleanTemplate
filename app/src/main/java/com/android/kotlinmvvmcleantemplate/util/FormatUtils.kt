package com.android.kotlinmvvmcleantemplate.util

import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

object FormatUtils {
    fun formatTime(durationInSeconds: Int): String {
        val minutes = durationInSeconds / 60
        val seconds = durationInSeconds % 60

        val durationString = String.format("%d:%02d", minutes, seconds)
        return durationString
    }

    fun formatPlayCount(playCount: Int): String {
        return if (playCount >= 10000) {
            String.format("%.1f万", playCount / 10000.0)
        } else {
            "$playCount"
        }
    }

    fun formatPublishTime(publishTime: Long): String {
        val instant = Instant.ofEpochSecond(publishTime.toLong())
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
        val dateTimeString = formatter.format(instant.atZone(ZoneId.systemDefault()))
        return dateTimeString //
    }
}