package com.dkgtech.notesapproomdatabse

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface NoteDao {

    @Insert
    fun addNote(note: NoteModel)

    @Query("select * from note")
    fun getAllNotes() : ArrayList<NoteModel>
}