package com.example.notekeepingbackend.dao;

import java.util.List;

import com.example.notekeepingbackend.model.Note;

public interface NotesDAO {
	
	void createNote(Note note);
	List<Note> getAllNotes();
	Note getNoteById(long id);
	void deleteNoteById(long id);
	void updateNoteById(Note note,long id);

}
