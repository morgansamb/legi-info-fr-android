package com.example.data.db.converter

import androidx.room.TypeConverter
import com.example.data.model.local.Document
import com.example.data.model.local.Session
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class FileConverter {

    private val moshi by lazy {
        Moshi.Builder().build()
    }

    @TypeConverter
    fun sessionListToJson(sessions: List<Session>?): String {
        val type = Types.newParameterizedType(List::class.java, Session::class.java)
        val adapter = moshi.adapter<List<Session>>(type)
        return adapter.toJson(sessions)
    }

    @TypeConverter
    fun documentListToJson(documents: List<Document>?): String {
        val type = Types.newParameterizedType(List::class.java, Document::class.java)
        val adapter = moshi.adapter<List<Document>>(type)
        return adapter.toJson(documents)
    }

    @TypeConverter
    fun jsonToSessionList(json: String): List<Session>? {
        val type = Types.newParameterizedType(List::class.java, Session::class.java)
        val adapter = moshi.adapter<List<Session>>(type)
        return adapter.fromJson(json)
    }

    @TypeConverter
    fun jsonToDocumentList(json: String): List<Document>? {
        val type = Types.newParameterizedType(List::class.java, Document::class.java)
        val adapter = moshi.adapter<List<Document>>(type)
        return adapter.fromJson(json)
    }
}
