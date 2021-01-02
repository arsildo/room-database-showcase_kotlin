package com.arsildo.notesavingroomkotlin.database

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "note_table")
class Note (
    @PrimaryKey(autoGenerate = true)
    val noteID : Int,
    val noteTitle : String,
    val noteDescription : String,

) : Parcelable