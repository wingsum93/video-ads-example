package com.example.videoexample.ui.page1

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.videoexample.Constant
import com.example.videoexample.R
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.source.hls.HlsDataSourceFactory
import com.google.android.exoplayer2.source.hls.HlsMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util

class VideoFragment : Fragment() {

    var playerView: PlayerView? = null
    lateinit var player: SimpleExoPlayer
    val videoUrl: String
        get() = arguments?.getString(Constant.Args.VIDEO_URL) ?: ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_video, container, false)
        playerView = view.findViewById(R.id.playerView)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        player = ExoPlayerFactory.newSimpleInstance(context)
        player.playWhenReady = true

        playerView?.player = player as Player

        val videoSource = createVideoDataSource()
        // Prepare the player with the source.
        player.prepare(videoSource)
    }


    private fun createVideoDataSource(): MediaSource {
        val dataSourceFactory = DefaultDataSourceFactory(
            context,
            Util.getUserAgent(context, "example video")
        )


        if (videoUrl.isHls()){

            return HlsMediaSource.Factory(dataSourceFactory)
                .createMediaSource(Uri.parse(videoUrl))
        }
        if(videoUrl.isMp4()) {
            return ProgressiveMediaSource.Factory(dataSourceFactory)
                .createMediaSource(Uri.parse(videoUrl))

        }
        return ProgressiveMediaSource.Factory(dataSourceFactory)
            .createMediaSource(Uri.parse(videoUrl))

    }

    private fun String.isMp4(): Boolean = this.contains(".mp4",true)

    private fun String.isHls():Boolean = this.contains(".m3u8",true)

    override fun onDestroy() {
        player.release()
        super.onDestroy()
    }
}