package com.example.mynote.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mynote.model.Notes

@Database(entities = [Notes::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDAO
}
