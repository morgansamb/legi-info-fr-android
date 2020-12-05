package com.example.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.data.db.dao.DeputyDao
import com.example.data.db.dao.DeputyDetailDao
import com.example.data.db.dao.DeputySynthesisDao
import com.example.data.db.dao.OrganizationDao
import com.example.data.model.local.*

@Database(entities = [
    DeputyEntity::class,
    OrganizationEntity::class,
    DeputyDetailEntity::class,
    DeputySynthesisEntity::class
],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase() {

    abstract fun deputyDao(): DeputyDao
    abstract fun deputyDetailDao(): DeputyDetailDao
    abstract fun deputySynthesisDao(): DeputySynthesisDao
    abstract fun organizationDao(): OrganizationDao

    companion object {
        private const val DATABASE_NAME = "legi-info-db"

        fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}
