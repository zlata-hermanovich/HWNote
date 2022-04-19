package com.example.mynote.ui.notes.sheetfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.mynote.databinding.SheetEditBinding
import com.example.mynote.databinding.SheetInfoBinding
import com.example.mynote.model.Notes
import com.example.mynote.ui.notes.NotesViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomEditSheetFragment(var note:Notes):BottomSheetDialogFragment() {

    private lateinit var binding: SheetEditBinding
    private val viewModel: NotesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SheetEditBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.run {
            data.text = viewModel.activeNote.value?.date.toString()
            title.setText(viewModel.activeNote.value?.title)
            textNote.setText(viewModel.activeNote.value?.textNote)
            imageEditText.setText(viewModel.activeNote.value?.pictureNote.toString())

            saveButton.setOnClickListener {
                note.title=binding.title.text.toString()
                note.textNote=binding.textNote.text.toString()
                note.pictureNote=binding.imageEditText.text.toString()

               viewModel.edit(note)
               dismiss()
            }
        }
    }
}
