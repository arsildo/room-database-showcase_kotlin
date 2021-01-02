package com.arsildo.notesavingroomkotlin.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.arsildo.notesavingroomkotlin.handling.NoteViewModel
import com.arsildo.notesavingroomkotlin.R
import com.arsildo.notesavingroomkotlin.database.Note
import kotlinx.android.synthetic.main.fragment_add_note.*

class AddNoteFragment : Fragment(R.layout.fragment_add_note) {

    private var noteTitle = ""
    private var noteDescription = ""
    private lateinit var noteViewModel: NoteViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        noteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)

        addNote_Button.setOnClickListener {
            addNoteToDatabase()
        }

    }

    private fun addNoteToDatabase() {
        noteTitle = noteTitle_EditText.text.toString()
        noteDescription = noteDescription_EditText.text.toString()
        if (!(noteTitle.isEmpty() || noteDescription.isEmpty())){
            val note = Note(0,noteTitle,noteDescription)
            noteViewModel.addNote(note)
            Toast.makeText(context,"Note Added Successfully!",Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addNoteFragment_to_noteListFragment)
        }else{
            Toast.makeText(context,"Fill out all fields!",Toast.LENGTH_SHORT).show()
        }
    }

}