package com.example.mynote.ui.notes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynote.model.Notes
import com.example.mynote.repository.NotesRepository
import kotlinx.coroutines.launch
import java.util.*
import kotlin.collections.ArrayList

class NotesViewModel : ViewModel() {

    lateinit var showProgressBar: (isShow: Boolean) -> Unit

    val activeNote = MutableLiveData<Notes>()
    val listNotes = MutableLiveData<ArrayList<Notes>>()

    private val repository = NotesRepository()

    fun loadList() {//загрузка всего списка из БД
        viewModelScope.launch {
            showProgressBar(true)
            listNotes.value = repository.getList() as ArrayList
            showProgressBar(false)
        }
    }

    fun saveNote(_title: String, _text: String,_image:String, _data: String?) {
        viewModelScope.launch {
            showProgressBar(true)
            repository.saveNote(Notes(0, _title, _text, _image, _data))
            loadList()
            showProgressBar(false)
        }
    }

    fun deleteAll() {
        viewModelScope.launch {
            repository.deleteList(listNotes.value!!)
            loadList()
        }
    }

    fun edit(note: Notes) {
        viewModelScope.launch {
            val key = note.id
            val title = note.title
            val text = note.textNote
            val image = note.pictureNote
            val data = note.date

            repository.updateOneNote(Notes(key, title, text, image, data))
            loadList()
        }
    }

    fun delete(note: Notes) {
        viewModelScope.launch {
            repository.deleteOneNote(note)
            loadList()
        }
    }
}