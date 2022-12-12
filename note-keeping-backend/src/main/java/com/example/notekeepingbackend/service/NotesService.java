package com.example.notekeepingbackend.service;

import java.util.List;

import com.example.notekeepingbackend.model.Note;

public interface NotesService {
	
	void addNote(Note note);
	List<Note> listNotes();
	Note getNote(long id);
	void deleteNote(long id);
	void updateNote(Note note,long id);

}
