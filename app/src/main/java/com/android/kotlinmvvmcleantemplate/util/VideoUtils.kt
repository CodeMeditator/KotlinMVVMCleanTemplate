package com.android.kotlinmvvmcleantemplate.util

import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.util.Base64
import java.util.Random
import java.util.zip.CRC32

/**
 * @author: CodeMeditator
 */
object VideoUtils {

    fun getDownloadUrl(videoId: String): String {
        // get url based on videoId
        val baseUrl = "https://ib.365yg.com"
        var url = "/video/urls/v/1/toutiao/mp4/$videoId?r="
        val randomNum = StringBuilder()
        val r = Random()
        while (randomNum.length < 16) {
            randomNum.append(r.nextInt(10))
        }
        url += randomNum
        val crc32 = CRC32()
        crc32.update(url.toByteArray())
        url = "$baseUrl$url&s=${crc32.value}"
        // parse the real downloadable url address
        var mainUrl = ""
        var conn: HttpURLConnection? = null
        val searchResult = StringBuffer()
        try {
            val target = URL(url)
            conn = target.openConnection() as HttpURLConnection
            conn.requestMethod = "GET"
            conn.setRequestProperty("Accept", "application/json")
            conn.setRequestProperty("connection", "Keep-Alive")
            conn.setRequestProperty(
                "user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)"
            )
            if (conn.responseCode == 200) {
                val inSr = InputStreamReader(conn.inputStream, "UTF-8")
                val `in` = BufferedReader(inSr)
                var line: String?
                if (`in` != null) {
                    while (`in`.readLine().also { line = it } != null) {
                        searchResult.append(line)
                    }
                    val regex =
                        "(?<=\\\"main_url\\\":\\\")[^\\\"]+".toRegex(RegexOption.IGNORE_CASE)
                    val m = regex.find(searchResult)
                    mainUrl = m?.value ?: ""
                    mainUrl = String(Base64.getDecoder().decode(mainUrl))
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            conn?.disconnect()
        }
        return mainUrl
    }

}