package com.example.videoexample.thirdparty

import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.videoexample.R


fun ImageView.loadImage(string:String,requestOptions: RequestOptions = getDefaultRequestOption()){
    GlideApp.with(this)
        .load(string)
        .apply(requestOptions)
        .into(this)
}

fun getDefaultRequestOption():RequestOptions{
    return RequestOptions().let{
        it.diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
        it.skipMemoryCache(false)
        it.placeholder(R.drawable.fish_xzz)
            it.error(R.drawable.player_dim_bg)
    }

}