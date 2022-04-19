package com.example.mynote.ui.notes.sheetfragment

import android.annotation.SuppressLint
import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.cesarferreira.tempo.Tempo
import com.example.mynote.databinding.SheetNewBinding
import com.example.mynote.ui.notes.NotesViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomNewSheetFragment : BottomSheetDialogFragment() {

    private val viewModel: NotesViewModel by activityViewModels()
    private val date= Tempo.now
    lateinit var binding: SheetNewBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SheetNewBinding.inflate(layoutInflater)
        return binding.root
    }

    @SuppressLint("SimpleDateFormat")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.showProgressBar={}

        binding.buttonSaveSheet.setOnClickListener {
            viewModel.saveNote(
                binding.titleNoteSheet.text.toString(),
                binding.textSheet.text.toString(),
                binding.pictureNew.text.toString(),
                SimpleDateFormat("dd-MM-yyyy").format(date)
            )
            dismiss()
        }
    }
}


