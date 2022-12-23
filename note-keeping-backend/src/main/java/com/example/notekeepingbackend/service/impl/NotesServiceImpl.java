package com.example.notekeepingbackend.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.notekeepingbackend.repository.NotesRepository;
import com.example.notekeepingbackend.repository.UserRepository;
import com.example.notekeepingbackend.exception.NoteAlreadyExistsException;
import com.example.notekeepingbackend.exception.NoteNotFoundException;
import com.example.notekeepingbackend.model.Note;
import com.example.notekeepingbackend.model.User;
import com.example.notekeepingbackend.service.NotesService;

@Service
public class NotesServiceImpl implements NotesService{
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private NotesRepository notesRepo;
	
	@Override
	public void addUser(String email_id) {
		StringBuilder email=new StringBuilder(email_id);
		int i=email.indexOf("%40");
		String id=email.substring(0,i);
		if(userRepo.findById(id).isPresent()) {
			return;
		}
		User user=new User();
		user.set_id(id);
		userRepo.save(user);
	}

	@Override
	public void addNote(Note note, String id) {
		
		if(userRepo.findById(id).isPresent()) {
			User user=userRepo.findById(id).get();
			if(user.getNotes()==null) {
				List<Note> notes=new ArrayList<>();
				notes.add(note);
				user.setNotes(notes);
			}else {
				List<Note> notes=user.getNotes();
				notes.add(note);
				user.setNotes(notes);
			}
			if(notesRepo.save(note)!=null)
				System.out.println("note saved");
			System.out.println(user.getNotes());
			if(userRepo.save(user)!=null)
				System.out.println("note added");
		}
	}
	
	@Override
	public User getUser(String id) {
		return userRepo.findById(id).get();
	}

	@Override
	public List<Note> listNotes(String uid) {
		if(userRepo.findById(uid).isPresent()) {
			User user=userRepo.findById(uid).get();
			if(user.getNotes()==null || user.getNotes().isEmpty()) {
				List<Note> notes=new ArrayList<>();
				System.out.println(notes);
				return notes;
			}
			return user.getNotes();
		}
		return null;
	}

	@Override
	public Note getNote(String uid, long id) {
		User user=userRepo.findById(uid).get();
		List<Note> notes=user.getNotes();
		for(Note note:notes) {
			if(note.getId()==id) {
				return note;
			}
		}
		return null;
	}

	@Override
	public void deleteNote(String uid, long id) {
		
		if(userRepo.findById(uid).isPresent()) {
			User user=userRepo.findById(uid).get();
			List<Note> notes=user.getNotes();
			notesRepo.deleteById(id);
			for(Note note:notes) {
				if(note.getId()==id) {
					notes.remove(note);
				}
			}
			user.setNotes(notes);
			userRepo.save(user);
			
		}
	}

	@Override
	public void updateNote(Note note, String uid, long id) {
		User user=userRepo.findById(uid).get();
		List<Note> notes=user.getNotes();
		for(Note n:notes) {
			if(n.getId()==id) {
				n.setTitle(note.getTitle());
				n.setDescription(note.getDescription());
				n.setUpdatedDate(note.getUpdatedDate());
				notesRepo.save(n);
			}
		}
		
		user.setNotes(notes);
		userRepo.save(user);
		
		
	}
	
//	@Override
//	public Note findNoteByTitle(String uid,String title) {
//		if(userRepo.findById(uid).isPresent()) {
//			User user=userRepo.findById(uid).get();
//			List<Note> notes=user.getNotes();
//			for(Note note:notes) {
//				if(note.getTitle().equals(title)) {
//					return note;
//				}
//			}
//		}
//		return null;
//	}
	

}
