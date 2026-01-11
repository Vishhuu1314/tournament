package com.bgmi.tournament.controller;

import com.bgmi.tournament.entity.Player;
import com.bgmi.tournament.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/player")
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Player p) {
        try {
            System.out.println("REQUEST RECEIVED: " + p.getBgmiId());

            if (p.getBgmiId() == null || p.getBgmiId().isEmpty()) {
                return ResponseEntity.badRequest().body("BGMI ID missing");
            }

            if (playerRepository.existsByBgmiId(p.getBgmiId())) {
                return ResponseEntity.badRequest().body("BGMI ID already registered");
            }

            if (p.getAge() == null || p.getAge() < 18) {
                return ResponseEntity.badRequest().body("Age must be 18 or above");
            }

            if (p.getWhatsappNumber() == null ||
                    !p.getWhatsappNumber().matches("\\d{10}")) {
                return ResponseEntity.badRequest()
                        .body("WhatsApp number must be exactly 10 digits");
            }

            playerRepository.save(p);
            System.out.println("SAVED SUCCESSFULLY");

            return ResponseEntity.ok("SUCCESS");

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("SERVER ERROR");
        }
    }
}
