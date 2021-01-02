package com.arsildo.notesavingroomkotlin.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.arsildo.notesavingroomkotlin.handling.NoteViewModel
import com.arsildo.notesavingroomkotlin.R
import com.arsildo.notesavingroomkotlin.database.Note
import kotlinx.android.synthetic.main.fragment_update_note.*

class UpdateNoteFragment : Fragment(R.layout.fragment_update_note) {

    private val args by navArgs<UpdateNoteFragmentArgs>()
    private lateinit var noteViewModel: NoteViewModel
    private var noteTitle = ""
    private var noteDescription = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        noteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)

        noteTitleUpdate_EditText.setText(args.selectedNote.noteTitle)
        noteDescriptionUpdate_EditText.setText(args.selectedNote.noteDescription)

        updateNote_Button.setOnClickListener {
            updateNote()
        }
        deleteNote_Button.setOnClickListener {
            deleteNote(args.selectedNote)
            Toast.makeText(context, "Note Deleted Successfully!", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateNoteFragment_to_noteListFragment)
        }

    }

    private fun updateNote() {
        noteTitle = noteTitleUpdate_EditText.text.toString()
        noteDescription = noteDescriptionUpdate_EditText.text.toString()

        if (!(noteTitle.isEmpty() || noteDescription.isEmpty())){
            val note = Note(args.selectedNote.noteID,noteTitle,noteDescription)
            noteViewModel.updateNote(note)
            Toast.makeText(context,"Note Updated Successfully!", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateNoteFragment_to_noteListFragment)
        }else{
            Toast.makeText(context,"Please Fill out all fields!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun deleteNote(note: Note){
        noteViewModel.deleteNote(note)
    }

}