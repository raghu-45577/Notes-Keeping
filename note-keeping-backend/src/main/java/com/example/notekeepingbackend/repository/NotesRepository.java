package com.example.notekeepingbackend.repository;

//import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.notekeepingbackend.model.Note;


//import com.example.notekeepingbackend.dao.NoteMapper;
//import com.example.notekeepingbackend.dao.NotesDAO;
//import com.example.notekeepingbackend.model.Note;

@Repository
public interface NotesRepository extends MongoRepository<Note,Long> {
}
