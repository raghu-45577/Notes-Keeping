package com.example.notekeepingbackend.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.notekeepingbackend.model.Note;

public class NoteMapper implements RowMapper<Note>{

	@Override
	public Note mapRow(ResultSet rs, int rowNum) throws SQLException {
		Note note = new Note();
		note.setId(rs.getLong("id"));
		note.setTitle(rs.getString("title"));
		note.setDescription(rs.getString("description"));
		note.setUpdatedDate(rs.getDate("updated_date"));
		return note;
	}

}
