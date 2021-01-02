package com.arsildo.notesavingroomkotlin.handling

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.arsildo.notesavingroomkotlin.R
import com.arsildo.notesavingroomkotlin.database.Note
import com.arsildo.notesavingroomkotlin.fragments.NoteListFragmentDirections
import kotlinx.android.synthetic.main.item_note.view.*

class NoteListAdapter : RecyclerView.Adapter<NoteListAdapter.NoteViewHolder>() {

    var noteList = mutableListOf<Note>()
    private lateinit var noteViewModel : NoteViewModel

    inner class NoteViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        init {
            itemView.editNote.setOnClickListener {
                val position = adapterPosition
                val action = NoteListFragmentDirections.actionNoteListFragmentToUpdateNoteFragment(noteList[position])
                itemView.findNavController().navigate(action)
            }



        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_note,parent,false))
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = noteList[position]
        holder.itemView.noteTitle.text = currentNote.noteTitle
        holder.itemView.noteDescription.text = currentNote.noteDescription
        
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    fun setData(note :  List<Note>){
        this.noteList = note as MutableList<Note>
        notifyDataSetChanged()
    }


}