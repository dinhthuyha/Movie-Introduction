package com.sunasterisk.movieintroduction.data.source.remote

import android.os.AsyncTask
import android.util.Log
import com.sunasterisk.movieintroduction.data.model.ResponseGenre
import com.sunasterisk.movieintroduction.data.source.MovieDataSource
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL

class HomeTask() : AsyncTask<String?, Void?, List<ResponseGenre>>() {
    var list = mutableListOf<ResponseGenre>()
    var genre_ids = mutableListOf<Int>()
    override fun doInBackground(vararg p0: String?): List<ResponseGenre> {
        var content = StringBuffer()
        var url = URL(p0[0])
        var bufferedReader: BufferedReader? = null
        try {

            var inputStreamReader = InputStreamReader(url.openConnection().getInputStream())
            val bufferedReader = BufferedReader(inputStreamReader)
            var line: String? = ""
            while (bufferedReader.readLine().also { line = it } != null) {
                content.append(line)
            }
            var jsonObject = JSONObject(content.toString())
            var genres = jsonObject.getJSONArray("genres")
            for (i in 0 until genres.length()) {
                var ob = genres.getJSONObject(i)
                var id = ob.getInt("id")
                var name = ob.getString("name")
                list.add(ResponseGenre(id, name))
            }

        } catch (e: Exception) {
            when (e) {
                e.stackTrace -> null
            }
        } finally {
            bufferedReader?.close()
        }

        return list
    }


}

