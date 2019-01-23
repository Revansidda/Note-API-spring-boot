package com.simple.crud.rest.noterestcrudapi.repository;

import com.simple.crud.rest.noterestcrudapi.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

}
