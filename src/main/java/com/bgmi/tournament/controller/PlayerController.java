package com.bgmi.tournament.controller;

import com.bgmi.tournament.entity.Player;
import com.bgmi.tournament.repository.PlayerRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    private final PlayerRepository repository;

    public PlayerController(PlayerRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/test")
public String testApi() {
    return "Backend tak request pahunch gayi";
}

    @PostMapping
    public Player registerPlayer(@RequestBody Player player) {

        if (repository.existsByBgmiId(player.getBgmiId())) {
            throw new RuntimeException("Player already registered with this BGMI ID");
        }

        return repository.save(player);
    }
}
