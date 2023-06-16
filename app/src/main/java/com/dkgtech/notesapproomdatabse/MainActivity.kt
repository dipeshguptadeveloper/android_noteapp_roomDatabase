package com.dkgtech.notesapproomdatabse

import android.app.Dialog
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import androidx.recyclerview.widget.RecyclerView.Orientation
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.dkgtech.notesapproomdatabse.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    lateinit var noteAdapter: RecyclerNoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val appDB = NoteDatabase.getDatabase(this@MainActivity)
        appDB.NoteDao().addNote(NoteModel("Android Meet", "Meeting at 10:30 AM "))
        appDB.NoteDao()
            .addNote(NoteModel("Weather App UI", "Beautiful weather app UI concept we wish exists"))
        val listNotes = appDB.NoteDao().getAllNotes()

//        binding.rcViewNote.layoutManager = StaggeredGridLayoutManager(3, VERTICAL)
        binding.rcViewNote.layoutManager = GridLayoutManager(this@MainActivity, 2)
        noteAdapter = RecyclerNoteAdapter(this@MainActivity, listNotes)
        binding.rcViewNote.adapter = noteAdapter

        binding.btnFab.setOnClickListener {

            val addNoteDialog = Dialog(this@MainActivity).apply {
                setContentView(R.layout.note_add)
                setCancelable(false)

                val edtNoteTitle = findViewById<EditText>(R.id.edtNoteTitle)
                val edtNoteDesc = findViewById<EditText>(R.id.edtNoteDesc)
                val btnAdd = findViewById<Button>(R.id.btnAdd)
                val btnCancel = findViewById<Button>(R.id.btnCancel)

                btnAdd.setOnClickListener {
                    val noteTitle = edtNoteTitle.text.toString()
                    val noteDesc = edtNoteDesc.text.toString()

                    if (noteTitle.isNotBlank() && noteDesc.isNotBlank()) {
                        appDB.NoteDao().addNote(NoteModel(noteTitle, noteDesc))

                        noteAdapter.notifyItemInserted(listNotes.size - 1)
                        binding.rcViewNote.scrollToPosition(listNotes.size - 1)

                    }

                    dismiss()

                }

                btnCancel.setOnClickListener {
                    dismiss()
                }

            }

            addNoteDialog.show()

        }

    }
}