package com.bgmi.tournament.repository;
import com.bgmi.tournament.entity.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TournamentRepository extends JpaRepository<Tournament, Long>{
}
