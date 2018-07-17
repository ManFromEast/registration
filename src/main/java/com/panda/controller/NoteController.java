package com.panda.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.panda.entity.Note;
import com.panda.exception.ResourceNotFoundException;
import com.panda.repository.NoteRepository;

@RestController
@RequestMapping("/api")
public class NoteController {

    // @RestController annotation is a combination of Springs @Controller and
    // @ResponseBody annotations.
    // The @Controller annotation is used to define a controller
    // the @ResponseBody annotation is used to indicate that the return value of a
    // method
    // should be used as the response body of the request.
    // @RequestMapping("/api") declares that the url for all the apis in this
    // controller will start with /api

    @Autowired
    NoteRepository noteRepository;

    // The @GetMapping("/notes") annotation is a short form of
    // @RequestMapping(value="/notes", method=RequestMethod.GET).
    @GetMapping("/notes")
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    // The @RequestBody annotation is used to bind the request body with a method
    // parameter.

    // The @Valid annotation makes sure that the request body is valid. Remember, we
    // had marked Note s title and content with @NotBlank annotation in the Note
    // model?
    // If the request body does not have a title or a content, then spring will
    // return a 400 BadRequest error to the client.

    @PostMapping("/notes")
    public Note createNote(@Valid @RequestBody Note note) {
        return noteRepository.save(note);
    }

    @GetMapping("/notes/{id}")
    public Note getNoteById(@PathVariable(value = "id") Long noteId) {
        return noteRepository.findById(noteId).orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
    }

    @PutMapping("/notes/{id}")
    public Note updateNote(@PathVariable(value = "id") Long noteId, @Valid @RequestBody Note noteDetails) {

        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

        note.setTitle(noteDetails.getTitle());
        note.setContent(noteDetails.getContent());

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
