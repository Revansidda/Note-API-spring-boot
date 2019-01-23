package com.simple.crud.rest.noterestcrudapi.controller;

import com.simple.crud.rest.noterestcrudapi.exception.ResourceNotFoundException;
import com.simple.crud.rest.noterestcrudapi.model.Note;
import com.simple.crud.rest.noterestcrudapi.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
    @RequestMapping("/v1")
    public class CrudNotesController {

        @Autowired
        NoteRepository noteRepository;



        @RequestMapping(value = "/notes",method = RequestMethod.GET)
        //  @GetMapping("/notes")
        public List<Note> getAllNotes() {
            return noteRepository.findAll();
        }

        @PostMapping("/notes")
        public Note createNote(@Valid @RequestBody Note note) {
            return noteRepository.save(note);
        }

        @RequestMapping(value = "/notes/{id}",method = RequestMethod.GET)
        //@GetMapping("/notes/{id}")
        public Note getNoteById(@PathVariable(value = "id") Long noteId) {
            return noteRepository.findById(noteId)
                    .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
        }

        @PutMapping("/notes/{id}")
        public Note updateNote(@PathVariable(value = "id") Long noteId,
                                    @Valid @RequestBody Note noteDetails) {

            Note note = noteRepository.findById(noteId)
                    .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

            note.setTitle(noteDetails.getTitle());
            note.setContent(noteDetails.getContent());
            note.setBenefits(noteDetails.getBenefits());
            Note updatedNote = noteRepository.save(note);
            return updatedNote;
        }

        @DeleteMapping("/notes/{id}")
        public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
            Note note = noteRepository.findById(noteId)
                    .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

            noteRepository.delete(note);

            return ResponseEntity.ok().build();
        }
}
