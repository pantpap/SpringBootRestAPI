package com.example.easynotes.service;

import com.example.easynotes.model.Note;
import com.example.easynotes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EasyNoteServiceImpl implements EasyNoteService {

   @Autowired
    NoteRepository noteRepository;

    @Override
    public List<Note> findAll() {
        return noteRepository.findAll();
    }

    @Override
    public Note findById(long id) {
        return noteRepository.findById(id);
    }

    @Override
    public Note save(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public void delete(Note noteId) {
        noteRepository.delete(noteId);
    }
}
