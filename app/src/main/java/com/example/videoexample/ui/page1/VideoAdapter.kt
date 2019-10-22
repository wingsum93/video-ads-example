package com.example.videoexample.ui.page1

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.videoexample.R
import com.example.videoexample.ext.SampleData
import com.example.videoexample.thirdparty.GlideApp
import com.example.videoexample.thirdparty.loadImage

class VideoAdapter(val context: Context, val data: ArrayList<VideoItem>) :
    RecyclerView.Adapter<VideoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.row_video, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data.get(position)

        holder.txt_title.text = item.title
        holder.txt_date.text = "2019-5-20"

        if (item.isPlaying) {
            holder.lb_playing.visibility = View.VISIBLE
        } else {
            holder.lb_playing.visibility = View.GONE
        }
//        holder.icon.loadImage(SampleData.VIDEO_1)
        item.thumbnail?.let {
            GlideApp.with(context)
                .load(it)
                .thumbnail(0.2f)
                .into(holder.icon)

        }
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val icon = v.findViewById<ImageView>(R.id.thumbnail)
        val txt_title = v.findViewById<TextView>(R.id.title)
        val txt_date = v.findViewById<TextView>(R.id.date)
        val lb_playing = v.findViewById<TextView>(R.id.label_isPlaying)

    }
}