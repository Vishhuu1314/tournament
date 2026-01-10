package com.bgmi.tournament.repository;

import com.bgmi.tournament.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    boolean existsByBgmiId(String bgmiId);
}
