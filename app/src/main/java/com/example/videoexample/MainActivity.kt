package com.example.videoexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.videoexample.ext.SampleData
import com.example.videoexample.thirdparty.GlideApp
import com.example.videoexample.ui.DefaultVideoActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    private val uiScope = CoroutineScope(Dispatchers.Main + SupervisorJob())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_1.setOnClickListener {
            startActivity<DefaultVideoActivity>(
                Constant.Args.VIDEO_URL to SampleData.VIDEO_2
            )
        }

        uiScope.launch() {
            GlideApp.get(applicationContext).clearMemory()
            withContext(Dispatchers.IO) {
                GlideApp.get(applicationContext).clearDiskCache()
            }
        }
    }


    override fun onDestroy() {
        uiScope.coroutineContext.cancel()
        super.onDestroy()
    }
}
