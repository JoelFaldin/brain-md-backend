package com.example.brainmd.note;

import com.example.brainmd.note.dto.NoteDto;
import com.example.brainmd.note.dto.UpdateDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    NoteService noteService;

    public NoteController(NoteService _noteService) {
        this.noteService = _noteService;
    }

    @PostMapping("")
    public ResponseEntity<?> createNote(@RequestBody NoteDto note) {
        Note result = this.noteService.createNote(note);

        Map<String, Object> response = new HashMap();
        response.put("status", "created");
        response.put("note", result);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("")
    public ResponseEntity<?> getNotes() {
        List<Note> notes = this.noteService.getNotes();

        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("notes", notes);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getNote(@PathVariable Long id) {
        Note result = this.noteService.getNoteById(id);

        if (result == null) {
            Map<String, Object> response = new HashMap<>();
            response.put("status", "error");
            response.put("message", "Note not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("data", result);

        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateNote(@PathVariable Long id, @RequestBody UpdateDto updateDto) {
        Note result = this.noteService.updateNote(id, updateDto);

        Map<String, Object> response = new HashMap<>();
        response.put("status", "updated");
        response.put("note", result);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable Long id) {
        this.noteService.deleteNote(id);

        Map<String, Object> response = new HashMap<>();
        response.put("status", "deleted");

        return ResponseEntity.ok(response);
    }
}
