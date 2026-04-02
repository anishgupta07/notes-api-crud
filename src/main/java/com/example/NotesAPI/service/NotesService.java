package com.example.NotesAPI.service;

import com.example.NotesAPI.model.Note;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class NotesService {
    List<Note> noteList = new ArrayList<>();
    int idCounter = 1;
    public String addNote(Note note){
        note.setId(idCounter++);
        noteList.add(note);
        note.setCreatedAt(LocalDateTime.now());
        note.setUpdatedAt(LocalDateTime.now());
        return "Notes Succesfully Added";
    }

    public List<Note> getAllNotes(){
        return noteList;
    }

    public String updateNote(int id, Note updateNotes){
        for (Note note : noteList) {
            if (note.getId() == id) {
                note.setTitle(updateNotes.getTitle());
                note.setDescription(updateNotes.getDescription());
                note.setUpdatedAt(LocalDateTime.now());
                return "Notes updated successfully";
            }
        }
        return "Notes not found";
    }

    public String deleteNote(int id){
        boolean removed = noteList.removeIf(note -> note.getId() == id);

        if (removed) return "Note Deleted Successfully";
        else return "Note Not Found";
    }
}
