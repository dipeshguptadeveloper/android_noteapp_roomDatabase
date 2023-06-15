package com.dkgtech.notesapproomdatabse

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [NoteModel::class], exportSchema = false, version = 1)
abstract class NoteDatabase : RoomDatabase() {

    companion object {
        private val DATABASE_NAME = "note_db"
        private var DATABASE_INSTANCE: NoteDatabase? = null

        @Synchronized
        fun getDatabase(context: Context): NoteDatabase {
            if (DATABASE_INSTANCE == null) {
                DATABASE_INSTANCE = Room.databaseBuilder(
                    context.applicationContext, NoteDatabase::class.java,
                    DATABASE_NAME
                ).build()
            }

            return DATABASE_INSTANCE!!
        }
    }


    abstract fun NoteDao(): NoteDao

}