package com.example.notekeepingbackend.service;


import java.util.List;

import com.example.notekeepingbackend.model.Note;
import com.example.notekeepingbackend.model.User;

public interface NotesService {
	
	void addNote(Note note,String id);
	List<Note> listNotes(String uid);
	Note getNote(String uid,long id);
	void deleteNote(String uid,long id);
	void updateNote(Note note,String uid,long id);
	void addUser(String email_id);
	User getUser(String id);
//	Note findNoteByTitle(String uid,String title);

}
