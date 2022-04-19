package com.example.mynote.repository

import com.example.mynote.database.NotesDataBase
import com.example.mynote.model.Notes

class NotesRepository {

    private val noteDao = NotesDataBase.dataBase.noteDao()

    suspend fun saveNote(note: Notes) = noteDao.insertNote(note)

    suspend fun getList() = noteDao.getAllList()

    suspend fun updateOneNote(note: Notes) = noteDao.updateNote(note)

    suspend fun deleteOneNote(note: Notes) = noteDao.deleteNote(note)

    suspend fun deleteList(list: List<Notes>) = noteDao.deleteAllNotes(list)
}


