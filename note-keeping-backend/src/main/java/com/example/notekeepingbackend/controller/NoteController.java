package com.example.notekeepingbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.notekeepingbackend.model.Note;
import com.example.notekeepingbackend.service.NotesService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/app/v1")
public class NoteController {
	
	@Autowired
	private NotesService notesService;
	
	
	@RequestMapping(method=RequestMethod.POST,value="/notes")
	public void saveNote(@RequestBody Note note) {
		notesService.addNote(note);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/notes")
	public List<Note> allNotes(){
		return notesService.listNotes();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/notes/{id}")
	public Note FindNote(@PathVariable long id) {
		return notesService.getNote(id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/notes/{id}")
	public void removeNote(@PathVariable long id) {
		notesService.deleteNote(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/notes/{id}")
	public void editNote(@RequestBody Note note,@PathVariable long id) {
		notesService.updateNote(note,id);
	}

}
