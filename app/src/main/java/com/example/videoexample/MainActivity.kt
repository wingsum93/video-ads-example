package com.example.videoexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.videoexample.ext.SampleData
import com.example.videoexample.ui.DefaultVideoActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_1.setOnClickListener {
            startActivity<DefaultVideoActivity>(
                Constant.Args.VIDEO_URL to SampleData.VIDEO_1
            )
        }
    }
}
