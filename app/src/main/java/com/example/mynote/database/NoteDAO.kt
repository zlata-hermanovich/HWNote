package com.example.mynote.database

import androidx.room.*
import com.example.mynote.model.Notes

@Dao
interface NoteDAO {

    @Insert //добавление записи
    suspend fun insertNote(note: Notes)

    @Query("select * from Notes") //достает весь список
    suspend fun getAllList(): List<Notes>

    @Update//обновление записи
    suspend fun updateNote(note: Notes)

    @Delete//удаление записи
    suspend fun deleteNote(note: Notes)

    @Delete//удаление записей
    suspend fun deleteAllNotes(noteList: List<Notes>)
}