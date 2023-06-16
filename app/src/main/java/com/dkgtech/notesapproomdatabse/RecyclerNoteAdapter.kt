package com.dkgtech.notesapproomdatabse

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class RecyclerNoteAdapter(val context: Context, val arrNote: List<NoteModel>) :
    RecyclerView.Adapter<RecyclerNoteAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtNoteTitle = itemView.findViewById<TextView>(R.id.txtNoteTitle)
        val txtNoteDesc = itemView.findViewById<TextView>(R.id.txtNoteDesc)
        val btnEdtNote = itemView.findViewById<ImageView>(R.id.btnEditNote)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.note_row, parent, false))
    }

    override fun getItemCount(): Int {
        return arrNote.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtNoteTitle.text = arrNote[position].title
        holder.txtNoteDesc.text = arrNote[position].desc
    }


}