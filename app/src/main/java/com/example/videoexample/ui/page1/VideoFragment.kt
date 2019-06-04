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
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util

class VideoFragment : Fragment() {

    var playerView: PlayerView? = null

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

        val player = ExoPlayerFactory.newSimpleInstance(context)
        player.playWhenReady = true

        playerView?.player = player as Player
        val dataSourceFactory = DefaultDataSourceFactory(
            context,
            Util.getUserAgent(context, "example video")
        )
        val videoSource = ProgressiveMediaSource.Factory(dataSourceFactory)
            .createMediaSource(Uri.parse(videoUrl))
        // Prepare the player with the source.
        player.prepare(videoSource)
    }
}