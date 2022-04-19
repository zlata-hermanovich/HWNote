package com.example.mynote.ui.notes.sheetfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.example.mynote.databinding.SheetInfoBinding
import com.example.mynote.ui.notes.NotesViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomInformationSheetFragment:BottomSheetDialogFragment() {

    lateinit var binding: SheetInfoBinding
    private val viewModel: NotesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SheetInfoBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.run {
            dataInfo.text = viewModel.activeNote.value?.date.toString()
            titleInfo.text = viewModel.activeNote.value?.title
            textInfo.text = viewModel.activeNote.value?.textNote
            Glide.with(this@BottomInformationSheetFragment).load(viewModel.activeNote.value?.pictureNote.toString()).into(imageInfo)

            closeButton.setOnClickListener {
                dismiss()
            }
        }
    }
}