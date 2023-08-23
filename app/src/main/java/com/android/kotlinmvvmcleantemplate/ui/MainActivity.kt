package com.android.kotlinmvvmcleantemplate.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.kotlinmvvmcleantemplate.data.entity.VideoList
import com.android.kotlinmvvmcleantemplate.databinding.ActivityMainBinding
import com.android.kotlinmvvmcleantemplate.ui.adapter.VideoAdapter

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: VideoAdapter
    private val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.loadVideos()
        observeData()
    }

    private fun observeData() {
        viewModel.videos.observe(this) {
            display(it)
        }
    }

    private fun display(videoList: VideoList) {
        // filter null title data
        val filteredVideoList =
            videoList.copy(data = videoList.data.filter { it.title.isNotEmpty() })

        adapter = VideoAdapter(filteredVideoList)
        binding.recycler.layoutManager = layoutManager
        binding.recycler.adapter = adapter
    }

}