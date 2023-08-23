package com.android.kotlinmvvmcleantemplate


import com.android.kotlinmvvmcleantemplate.network.RetrofitClient
import com.android.kotlinmvvmcleantemplate.util.VideoUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Url
import java.io.IOException
import java.lang.StringBuilder
import kotlin.reflect.typeOf
import retrofit2.converter.scalars.ScalarsConverterFactory

class JSONTestd {
    @Test
    fun test() {

    }

    // okhttp
    fun OkGetArt(url: String): String? {
        var html: String? = null
        val client = OkHttpClient()
        val request = Request.Builder().url(url).build()
        try {
            client.newCall(request).execute().use { response ->
                //return
                html = response.body?.string()
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return html
    }

    // retrofit

}

