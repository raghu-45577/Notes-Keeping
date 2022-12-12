package com.example.notekeepingbackend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.notekeepingbackend.dao.NotesDAO;
import com.example.notekeepingbackend.model.Note;
import com.example.notekeepingbackend.service.NotesService;

@Service
public class NotesServiceImpl implements NotesService{
	
	@Autowired
	private NotesDAO notesDao;

	@Override
	public void addNote(Note note) {
		notesDao.createNote(note);	
	}

	@Override
	public List<Note> listNotes() {
		return notesDao.getAllNotes();
	}

	@Override
	public Note getNote(long id) {
		return notesDao.getNoteById(id);
	}

	@Override
	public void deleteNote(long id) {
		notesDao.deleteNoteById(id);
		
	}

	@Override
	public void updateNote(Note note,long id) {
		notesDao.updateNoteById(note,id);
		
	}

}
