package com.android.kotlinmvvmcleantemplate.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.kotlinmvvmcleantemplate.R
import com.android.kotlinmvvmcleantemplate.data.entity.Video
import com.android.kotlinmvvmcleantemplate.data.entity.VideoList
import com.android.kotlinmvvmcleantemplate.util.FormatUtils.formatTime
import com.android.kotlinmvvmcleantemplate.util.FormatUtils.formatPlayCount
import com.android.kotlinmvvmcleantemplate.util.FormatUtils.formatPublishTime
import com.bumptech.glide.Glide
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import com.android.kotlinmvvmcleantemplate.databinding.ItemVideoBinding
import com.android.kotlinmvvmcleantemplate.util.VideoUtils

class VideoAdapter(private val videoList: VideoList) :
    RecyclerView.Adapter<VideoAdapter.VideoHolder>() {

    class VideoHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        private val binding = ItemVideoBinding.bind(itemview)

        init {
            Log.d("VideoHolder", "init")
        }

        fun bind(video: Video) {
            binding.textVideoName.text = video.title
            binding.subTitle.text = video.user_info?.name ?: ""
            binding.duration.text = formatTime(video.video_duration)
            binding.thirdTitle.text = formatPlayCount(
                video.video_detail_info?.video_watch_count ?: 0
            ) + "次播放 · " + formatPublishTime(video.publish_time) + "发布"

            // bitmap
            CoroutineScope(Dispatchers.IO).launch {
                val downloadUrl = VideoUtils.getDownloadUrl(video.video_id)
                // Update UI on the main thread
                withContext(Dispatchers.Main) {
                    // Now you can use the downloadUrl to load the image
                    Glide.with(itemView.context).asBitmap().load(downloadUrl)
                        .into(binding.imageVideo)
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoHolder {
        return VideoHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_video, parent, false)
        )
    }

    override fun getItemCount(): Int = videoList.data.size

    override fun onBindViewHolder(holder: VideoHolder, position: Int) =
        holder.bind(videoList.data[position])

}

