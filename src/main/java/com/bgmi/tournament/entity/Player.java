package com.bgmi.tournament.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String ign;

    @Column(unique = true, nullable = false)
    private String bgmiId;

    private String email;
    private String mobile;
    private Integer age;
    private String state;
    private String deviceType;

    private boolean agreedToRules;

    @ManyToOne
    @JoinColumn(name = "tournament_id")
    private Tournament tournament;

    // ===== getters & setters =====

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getIgn() {
        return ign;
    }

    public void setIgn(String ign) {
        this.ign = ign;
    }

    public String getBgmiId() {
        return bgmiId;
    }

    public void setBgmiId(String bgmiId) {
        this.bgmiId = bgmiId;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }
}
