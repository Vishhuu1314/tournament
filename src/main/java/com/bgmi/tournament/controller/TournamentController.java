package com.bgmi.tournament.controller;

import com.bgmi.tournament.entity.Tournament;
import com.bgmi.tournament.repository.TournamentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tournaments")
public class TournamentController {

    private final TournamentRepository repository;

    public TournamentController(TournamentRepository repository) {
        this.repository = repository;
    }

    // Create tournament
    @PostMapping
    public Tournament createTournament(@RequestBody Tournament tournament) {
        return repository.save(tournament);
    }

    // Get all tournaments
    @GetMapping
    public List<Tournament> getAllTournaments() {
        return repository.findAll();
    }
@GetMapping("/list")
public List<Tournament> getTournaments() {
    return repository.findAll();
}
}

