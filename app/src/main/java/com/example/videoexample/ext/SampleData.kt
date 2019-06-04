package com.example.videoexample.ext

import android.provider.MediaStore
import com.example.videoexample.ui.page1.VideoItem

object SampleData {
    const val VIDEO_1 = "https://tedious.s3.us-west-1.amazonaws.com/SampleVideoBae_1280x720_1mb.mp4"

    fun getVideoList(): ArrayList<VideoItem> {
        return arrayListOf(
            buildVideoItem(url = SampleData.VIDEO_1),
            buildVideoItem(url = SampleData.VIDEO_1),
            buildVideoItem(url = SampleData.VIDEO_1),
            buildVideoItem(url = SampleData.VIDEO_1)
        )
    }

    fun buildVideoItem(title: String = "", description: String = "", url: String): VideoItem = VideoItem()
        .also {
            it.title = title
            it.description = description
            it.videoUrl = url
        }
}