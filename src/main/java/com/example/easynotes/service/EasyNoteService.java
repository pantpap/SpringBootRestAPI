package com.example.easynotes.service;

import com.example.easynotes.model.Note;

import java.util.List;
import java.util.Optional;

public interface EasyNoteService{
    List<Note> findAll();
    Note findById(long id);
    Note save (Note note);
    void delete (Note noteId);
}
