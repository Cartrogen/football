package com.api.football.model.response.player;

import com.api.football.model.response.player.subtype.Appearance;
import com.api.football.model.response.player.subtype.MinutesPlayed;
import com.api.football.model.response.player.subtype.Performance;
import lombok.Data;

@Data
public class Player {
    private String fullName;
    private String age;
    private String league;
    private String season;
    private String position;
    private String club;
    private String nationality;
    private MinutesPlayed minutesPlayed;
    private Appearance appearances;
    private Performance performance;
    private String yellowCards;
    private String redCards;
}
