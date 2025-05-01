package com.example.roomcomplete

class NoteRepository(private val noteDao: NoteDao) {

    fun getAllNotes() = noteDao.getAllNotes()

    suspend fun insertNote(note: Note) {
        noteDao.insertNote(note)
    }

    suspend fun deleteNote(note: Note) {
        noteDao.deleteNote(note)
    }
}