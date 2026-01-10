package com.bgmi.tournament.entity;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "tournaments")
@Data
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tournamentName;
    private String gameName;
    private int entryFee;
    private int maxPlayers;
}
