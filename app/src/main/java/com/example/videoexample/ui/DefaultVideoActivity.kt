package com.example.videoexample.ui

import android.os.Bundle
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.videoexample.Constant
import com.example.videoexample.R
import com.example.videoexample.ext.SampleData
import com.example.videoexample.ext.loadFragment
import com.example.videoexample.ui.page1.VideoAdapter
import com.example.videoexample.ui.page1.VideoFragment

class DefaultVideoActivity : AppCompatActivity() {

    var frameLayout: FrameLayout? = null

    var rv1: RecyclerView? = null
    lateinit var adapter: VideoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_default_video)


        initView()
    }

    fun initView() {
        frameLayout = findViewById(R.id.container)
        calculateContainerSize()

        rv1 = findViewById(R.id.recyclerView)
        rv1?.layoutManager = LinearLayoutManager(this)
        rv1?.adapter = VideoAdapter(this, SampleData.getVideoList()).also { adapter = it }
        rv1?.setHasFixedSize(true)

        val f = VideoFragment()
        f.arguments = intent.extras
        loadFragment(R.id.playerContainer, f)
    }

    fun calculateContainerSize() {
        val parms = frameLayout!!.layoutParams as ViewGroup.LayoutParams
        val width = parms.width
        parms.height = width
        frameLayout?.layoutParams = parms
        frameLayout?.invalidate()
    }
}