package com.example.roomcomplete

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class NoteViewModel : ViewModel() {
    private val repository = NoteRepository(NoteDatabase.getDatabase().noteDao())

    val notes: LiveData<List<Note>> = repository.getAllNotes()

    fun addNote(title: String, text: String) {
        viewModelScope.launch {
            repository.insertNote(Note(title = title, text = text))
        }
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch {
            repository.deleteNote(note)
        }
    }
}