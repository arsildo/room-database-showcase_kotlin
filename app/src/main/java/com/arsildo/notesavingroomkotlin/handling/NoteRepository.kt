package com.arsildo.notesavingroomkotlin.handling

import androidx.lifecycle.LiveData
import com.arsildo.notesavingroomkotlin.database.Note
import com.arsildo.notesavingroomkotlin.database.NoteDAO

class NoteRepository (private val noteDAO: NoteDAO) {

    val getAllNotes : LiveData<List<Note>> = noteDAO.getAllNotes()

    suspend fun addNote(note: Note){
        noteDAO.addNote(note)
    }

    suspend fun updateNote(note: Note){
        noteDAO.updateNote(note)
    }

    suspend fun deleteNote(note: Note){
        noteDAO.deleteNote(note)
    }

    suspend fun deleteAllNotes(){
        noteDAO.deleteAllNotes()
    }


}