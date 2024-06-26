package com.example.c001apk.compose.logic.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.c001apk.compose.logic.dao.StringEntityDao
import com.example.c001apk.compose.logic.model.StringEntity

@Database(version = 1, entities = [StringEntity::class])
abstract class StringEntityDatabase : RoomDatabase() {
    abstract fun stringEntityDao(): StringEntityDao
}