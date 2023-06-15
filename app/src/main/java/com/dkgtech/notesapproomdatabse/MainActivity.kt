package com.dkgtech.notesapproomdatabse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appDB = NoteDatabase.getDatabase(this@MainActivity)
        appDB.NoteDao().addNote(NoteModel("Android Meet", "Meeting at 10:30 AM "))
        val listNotes = appDB.NoteDao().getAllNotes()
    }
}