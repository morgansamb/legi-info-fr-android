package com.example.data.db.converter

import androidx.room.TypeConverter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class DeputyDetailConverter {

    private val moshi by lazy {
        Moshi.Builder().build()
    }

    @TypeConverter
    fun stringListToJson(strings: List<String>?): String {
        val type = Types.newParameterizedType(List::class.java, String::class.java)
        val adapter = moshi.adapter<List<String>>(type)
        return adapter.toJson(strings)
    }

    @TypeConverter
    fun jsonToStringList(json: String): List<String>? {
        val type = Types.newParameterizedType(List::class.java, String::class.java)
        val adapter = moshi.adapter<List<String>>(type)
        return adapter.fromJson(json)
    }
}
