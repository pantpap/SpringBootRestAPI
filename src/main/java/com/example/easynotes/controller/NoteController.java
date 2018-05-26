package com.example.easynotes.controller;

import com.example.easynotes.extension.ResourceNotFoundException;
import com.example.easynotes.model.Note;
import com.example.easynotes.repository.NoteRepository;
import com.example.easynotes.service.EasyNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class NoteController {

    @Autowired
    NoteRepository noteRepository;

    @Autowired
    EasyNoteService easyNoteService;

    // Get All Notes

    @RequestMapping(value = "/notes", method = RequestMethod.GET)
    // @GetMapping("/notes")
    public List<Note> getAllNotes(){
        return easyNoteService.findAll();
    }

    // Get a Single Note
    @RequestMapping(value = "/note/{id}", method = RequestMethod.GET)
//    @GetMapping("/note/{id}")
    public Note getNoteById(@PathVariable(value = "id")long noteId){
        return easyNoteService.findById(noteId);
//                .orElseThrow(()-> new ResourceNotFoundException("Note", "id", noteId));
    }

    // Create a new note
    @PostMapping("/notes")
    public Note createNote(@Valid @RequestBody Note note){
        return easyNoteService.save(note);
    }


    // Update a Note
    @PutMapping("/note/{id}")
    public Note updateNote(@PathVariable(value = "id") long noteId, @Valid @RequestBody Note noteDetails){
        Note note = easyNoteService.findById(noteId);
//                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

        note.setTitle(noteDetails.getTitle());
        note.setContent(noteDetails.getContent());

        Note updatedNote = easyNoteService.save(note);

        return updatedNote;
    }

    // Delete a Note
    @DeleteMapping("/note/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id")long noteId){
        Note note = easyNoteService.findById(noteId);
//                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

        easyNoteService.delete(note);

        return ResponseEntity.ok().build();
    }
}
