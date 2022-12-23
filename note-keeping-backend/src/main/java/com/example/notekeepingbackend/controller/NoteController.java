package com.example.notekeepingbackend.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.notekeepingbackend.model.User;

import com.example.notekeepingbackend.model.Note;
import com.example.notekeepingbackend.service.NotesService;
import com.example.notekeepingbackend.service.impl.SequenceGeneratorService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/app/v1")
public class NoteController {
	
	@Autowired
	private NotesService notesService;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	
	@RequestMapping(method=RequestMethod.POST,value="/user")
	public void saveUser(@RequestBody String email_id) {
		notesService.addUser(email_id);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/user/{id}")
	public User getUserById(@PathVariable String id) {
		return notesService.getUser(id);
	}
	
	
	@RequestMapping(method=RequestMethod.POST,value="/user/{uid}/notes")
	public void saveNote(@RequestBody Note note,@PathVariable String uid) {
		note.setId(sequenceGeneratorService.generateSequence(Note.SEQ_NAME));
//		try {
			notesService.addNote(note,uid);
//		}catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/user/{uid}/notes")
	public List<Note> allNotes(@PathVariable String uid){
		try {
			return notesService.listNotes(uid);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/user/{uid}/notes/{id}")
	public Note FindNote(@PathVariable String uid,@PathVariable long id) {
		try {
		return notesService.getNote(uid,id);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/user/{uid}/notes/{id}")
	public void removeNote(@PathVariable String uid,@PathVariable long id) {
		try {
			notesService.deleteNote(uid,id);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/user/{uid}/notes/{id}")
	public void editNote(@RequestBody Note note,@PathVariable String uid,@PathVariable long id) {
		try {
			notesService.updateNote(note,uid,id);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
//	@RequestMapping(method=RequestMethod.GET,value="/user/{uid}/notes/{title}")
//	public Note getNoteByTitle(@PathVariable String uid,@PathVariable String title) {
//		return notesService.findNoteByTitle(uid,title);
//	}

}
