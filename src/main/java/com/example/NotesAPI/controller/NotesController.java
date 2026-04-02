package com.example.NotesAPI.controller;


import com.example.NotesAPI.model.Note;
import com.example.NotesAPI.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NotesController {
    @Autowired
    NotesService notesService;

    @PostMapping
    public String addNotes(@RequestBody Note note){
        return  notesService.addNote(note);
    }

    @GetMapping
    public List<Note> printAllNotes(){
        return  notesService.getAllNotes();
    }

    @PutMapping("/{id}")
    public String updateNotes(@PathVariable int id , @RequestBody Note updatedNotes){
        return notesService.updateNote(id , updatedNotes);
    }
    @DeleteMapping("/{id}")
    public String deleteNotes(@PathVariable int id){
        return notesService.deleteNote(id);
    }
}
