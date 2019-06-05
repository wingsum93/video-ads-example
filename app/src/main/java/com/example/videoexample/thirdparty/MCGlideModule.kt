package com.example.videoexample.thirdparty

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.disklrucache.DiskLruCache
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader
import com.bumptech.glide.load.engine.cache.DiskCache
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory
import com.bumptech.glide.load.model.GlideUrl
import java.io.InputStream


@GlideModule
class MCGlideModule :AppGlideModule(){

    val DISK_CACHE_SIZE:Long = 1024 * 1024 * 300

    override fun applyOptions(context: Context, builder: GlideBuilder) {
        //修改默认配置，如缓存配置

        builder.setDiskCache(DiskLruCacheFactory(context.cacheDir.path,DISK_CACHE_SIZE))

    }

    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        //替换组件，如网络请求组件
        registry.replace(GlideUrl::class.java, InputStream::class.java, OkHttpUrlLoader.Factory())
    }
}