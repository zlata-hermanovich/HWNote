package com.example.mynote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mynote.database.NotesDataBase
import com.example.mynote.databinding.ActivityHomeBinding
import com.example.mynote.ui.notes.NoteFragment

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        NotesDataBase.initDataBase(this)

     supportFragmentManager
         .beginTransaction()
         .replace(R.id.container, NoteFragment())
         .commit()
    }
}