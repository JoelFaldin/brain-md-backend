package com.example.brainmd.note;

import com.example.brainmd.note.dto.NoteDto;
import com.example.brainmd.note.dto.UpdateDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepo) {
        this.noteRepository = noteRepo;
    }

    public Note createNote(NoteDto note) {
        try {
            Note newNote = new Note(note.getTitle(), note.getContent());

            return this.noteRepository.save(newNote);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create new note", e);
        }
    }

    public List<Note> getNotes() {
        try {
            return this.noteRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch notes", e);
        }
    }

    public Note getNoteById(Long id) {
        try {
            Note note = this.noteRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Note not found"));

            return note;
        } catch (Exception e) {
            throw new RuntimeException("Failed to find note", e);
        }
    }

    public Note updateNote(Long id, UpdateDto updateDto) {
        try {
            Note note = this.noteRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Note not found"));

            if (updateDto.getTitle() != null) {
                note.setTitle(updateDto.getTitle());
            }

            if (updateDto.getContent() != null) {
                note.setContent(updateDto.getContent());
            }

            return noteRepository.save(note);
        } catch (Exception e) {
            throw new RuntimeException("Failed to update note", e);
        }
    }

    public void deleteNote(Long id) {
        try {
            boolean exists = this.noteRepository.existsById(id);

            if (exists) {
                this.noteRepository.deleteById(id);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete note", e);
        }
    }
}
