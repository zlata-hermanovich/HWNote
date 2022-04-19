package com.example.mynote.database

import android.content.Context
import androidx.room.Room
import com.example.mynote.model.Notes
import kotlin.random.Random

object NotesDataBase {

    lateinit var dataBase: AppDatabase

    fun initDataBase(context: Context) {
        if (!this::dataBase.isInitialized) {
            dataBase = Room.databaseBuilder(
                context,
                AppDatabase::class.java, "database-name"
            )
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
        }
    }
}
