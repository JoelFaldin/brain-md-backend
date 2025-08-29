package com.example.brainmd.auth;

import com.example.brainmd.auth.dto.GoogleDto;
import com.example.brainmd.auth.dto.GoogleUserDto;
import com.example.brainmd.note.Note;
import com.example.brainmd.note.NoteService;
import com.example.brainmd.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;
    private final UserService userService;
    private final NoteService noteService;

    public AuthController(AuthService service, UserService userService, NoteService noteService) {
        this.authService = service;
        this.userService = userService;
        this.noteService = noteService;
    }

    @PostMapping("/google")
    public ResponseEntity<?> googleAuth(@RequestBody GoogleDto googleDto) {
        try {
            GoogleUserDto response = authService.getGoogleData(googleDto.getToken());
            String token = authService.generateToken(response.getEmail(), response.getName());

            boolean userExists = userService.searchUser(response.getEmail());

            Map<String, Object> res = new HashMap<>();

            res.put("response", "generated");
            res.put("token", token);
            res.put("name", response.getName());
            res.put("email", response.getEmail());
            res.put("picture", response.getPicture());

            if (userExists) {
                List<Note> notes = noteService.getNotesByEmail(response.getEmail());
                res.put("notes", notes);
            } else {
                userService.createUser(response.getEmail(), response.getName(), response.getPicture());
            }

            return ResponseEntity.ok(res);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token.");
        }
    }
}
