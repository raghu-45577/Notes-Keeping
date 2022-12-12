package com.example.notekeepingbackend.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.notekeepingbackend.dao.NoteMapper;
import com.example.notekeepingbackend.dao.NotesDAO;
import com.example.notekeepingbackend.model.Note;

@Repository
public class NotesDAOImpl implements NotesDAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void createNote(Note note) {
		String sql="INSERT INTO notes(title,description,updated_date) VALUES(?,?,?)";
		jdbcTemplate.update(sql, new Object[] {note.getTitle(),note.getDescription(),note.getUpdatedDate()});
	}

	@Override
	public List<Note> getAllNotes() {
		String sql="SELECT * FROM notes";
		return jdbcTemplate.query(sql, new NoteMapper());
	}

	@Override
	public Note getNoteById(long id) {
		String sql="SELECT * FROM notes WHERE id=?";
		List<Note> notes= jdbcTemplate.query(sql, new NoteMapper(), id);
		if(notes.size()==0) {
			return null;
		}
		return notes.get(0);
	}

	@Override
	public void deleteNoteById(long id) {
		String sql="DELETE FROM notes WHERE id=?";
		jdbcTemplate.update(sql, id);
		
	}

	@Override
	public void updateNoteById(Note note,long id) {
		String sql="UPDATE notes SET title=?,description=?,updated_date=? WHERE id=?";
		jdbcTemplate.update(sql, note.getTitle(),note.getDescription(),note.getUpdatedDate(),id);
		
	}

}
