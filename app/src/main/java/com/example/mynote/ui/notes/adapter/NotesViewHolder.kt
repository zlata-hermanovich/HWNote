package com.example.mynote.ui.notes.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mynote.databinding.ItemNoteBinding
import com.example.mynote.model.Notes

class NotesViewHolder(
    private val context: Context, binding: ItemNoteBinding):
    RecyclerView.ViewHolder(binding.root){

    private val image = binding.imageViewNote
    private val title = binding.titleTextView
    private val data = binding.dataTextView
    private val setting=binding.settingButton

    fun bindNote(note: Notes,onSettingsClick:(item:Notes)->Unit) {

        Glide.with(context).load(note.pictureNote).into(image)
        title.text = note.title
        data.text = note.date.toString()

        setting.setOnClickListener {
            onSettingsClick(note)
        }
    }
}