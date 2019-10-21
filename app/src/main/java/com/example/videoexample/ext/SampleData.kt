package com.example.videoexample.ext

import android.provider.MediaStore
import com.example.videoexample.ui.page1.VideoItem

object SampleData {
    const val VIDEO_1 = "https://tedious.s3.us-west-1.amazonaws.com/SampleVideoBae_1280x720_1mb.mp4"
    const val VIDEO_2 = "http://jav-dash2.s3.ap-northeast-1.amazonaws.com/sample.m3u8"
    const val thumbnail1 = "http://www.qpic.ws/images/1tmt.jpg"

    fun getVideoList(): ArrayList<VideoItem> {
        return arrayListOf(
            buildVideoItem(url = SampleData.VIDEO_2, thumbnail = thumbnail1),
            buildVideoItem(url = SampleData.VIDEO_2),
            buildVideoItem(url = SampleData.VIDEO_2),
            buildVideoItem(url = SampleData.VIDEO_2)
        )
    }

    fun buildVideoItem(
        title: String = "",
        description: String = "",
        url: String,
        thumbnail: String? = null
    ): VideoItem = VideoItem()
        .also {
            it.title = title
            it.description = description
            it.videoUrl = url
            it.thumbnail = thumbnail
        }
}