package com.example.mynote.ui.notes.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ItemTouchUIUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mynote.R
import com.example.mynote.databinding.ItemNoteBinding
import com.example.mynote.model.Notes

class NotesAdapter(
    private val context: Context,
    val onItemClick: (item: Notes) -> Unit
) : RecyclerView.Adapter<NotesViewHolder>() {

    private var listNotes: ArrayList<Notes> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        return NotesViewHolder(
            context, ItemNoteBinding.inflate(LayoutInflater.from(context))
        )
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        holder.bindNote(listNotes[position]) { onItemClick(listNotes[position]) }
    }

    override fun getItemCount() = listNotes.size

    @SuppressLint("NotifyDataSetChanged")
    fun setDataList(noteList: ArrayList<Notes>) {
        listNotes = noteList
        notifyDataSetChanged()
    }
}