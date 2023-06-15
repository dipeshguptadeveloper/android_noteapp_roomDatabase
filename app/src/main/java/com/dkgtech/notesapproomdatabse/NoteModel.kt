package com.dkgtech.notesapproomdatabse

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey


@Entity(tableName = "note")
data class NoteModel(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "note_title") val title: String,
    @ColumnInfo(name = "note_desc") val desc: String
)


{
    @Ignore
    constructor(note_title: String, note_desc: String) : this(0, note_title, note_desc)
}


