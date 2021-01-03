package com.arsildo.notesavingroomkotlin.fragments


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.arsildo.notesavingroomkotlin.handling.NoteListAdapter
import com.arsildo.notesavingroomkotlin.handling.NoteViewModel
import com.arsildo.notesavingroomkotlin.R
import com.arsildo.notesavingroomkotlin.database.Note
import kotlinx.android.synthetic.main.fragment_note_list.*

class NoteListFragment : Fragment(R.layout.fragment_note_list) {

    private lateinit var noteList : List<Note>
    private lateinit var noteViewModel : NoteViewModel
    private lateinit var adapter : NoteListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = NoteListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        viewModels()
        addNote.setOnClickListener{
            findNavController().navigate(R.id.action_noteListFragment_to_addNoteFragment)
        }

        deleteAllNotes.setOnClickListener {
            noteViewModel.deleteAllNotes()
        }


    }

    private fun viewModels(){
        noteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)
        noteViewModel.getNotes.observe(viewLifecycleOwner, Observer {
            adapter.setData(it)
            noteList = it
        })
    }


}