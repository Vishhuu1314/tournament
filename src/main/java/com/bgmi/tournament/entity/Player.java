package com.bgmi.tournament.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String teamName;
    private String leaderName;
    private String bgmiId;

    private Integer age;   // ⚠️ Integer, NOT int
    private String whatsappNumber;

    public Long getId() { return id; }

    public String getTeamName() { return teamName; }
    public void setTeamName(String teamName) { this.teamName = teamName; }

    public String getLeaderName() { return leaderName; }
    public void setLeaderName(String leaderName) { this.leaderName = leaderName; }

    public String getBgmiId() { return bgmiId; }
    public void setBgmiId(String bgmiId) { this.bgmiId = bgmiId; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public String getWhatsappNumber() { return whatsappNumber; }
    public void setWhatsappNumber(String whatsappNumber) {
        this.whatsappNumber = whatsappNumber;
    }
}
