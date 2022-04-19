package com.example.mynote.ui.notes

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.*
import android.widget.PopupMenu
import androidx.core.app.NotificationCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mynote.R
import com.example.mynote.databinding.FragmentNoteBinding
import com.example.mynote.model.Notes
import com.example.mynote.ui.notes.adapter.NotesAdapter
import com.example.mynote.ui.notes.sheetfragment.BottomEditSheetFragment
import com.example.mynote.ui.notes.sheetfragment.BottomInformationSheetFragment
import com.example.mynote.ui.notes.sheetfragment.BottomNewSheetFragment

class NoteFragment : Fragment() {

    lateinit var binding: FragmentNoteBinding
    private val viewModel: NotesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoteBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.showProgressBar = {
            binding.progressBar.visibility = if (it) {
                View.VISIBLE
            } else View.GONE
        }

        viewModel.loadList()

        viewModel.listNotes.observe(viewLifecycleOwner) {

            binding.listNoteRecycler.run {
                adapter = NotesAdapter(requireContext()) { note ->
                    popupsMenu(this, note)
                }
                layoutManager = LinearLayoutManager(requireContext())
            }
            (binding.listNoteRecycler.adapter as NotesAdapter).setDataList(it)
        }

        binding.deleteAllnotesButton.setOnClickListener {
            AlertDialog.Builder(context)
                .setMessage("Are you ready?")
                .setPositiveButton("yes") { _, _ ->
                    viewModel.deleteAll()
                }
                .setNegativeButton("no") { _, _ ->
                }
                .show()
        }
        binding.addButton.setOnClickListener {
            BottomNewSheetFragment().show(parentFragmentManager, "")
        }
    }

    @SuppressLint("DiscouragedPrivateApi")
    fun popupsMenu(v: View, note: Notes) {
        val popUp = PopupMenu(context, v)
        popUp.menuInflater.inflate(R.menu.menu_option, popUp.menu)

        popUp.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.menu_open -> {
                    viewModel.activeNote.value = note
                    BottomInformationSheetFragment().show(parentFragmentManager, "open")
                }
                R.id.menu_edit -> {
                    viewModel.activeNote.value = note
                    BottomEditSheetFragment(note).show(parentFragmentManager, "edit")
                }
                R.id.menu_delete -> {
                    viewModel.delete(note)
                }
            }
            true
        }
        popUp.show()
    }
}