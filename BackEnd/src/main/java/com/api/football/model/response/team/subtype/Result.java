package com.api.football.model.response.team.subtype;

import lombok.Data;

@Data
public class Result {

    private String totalWins;
    private String winsHome;
    private String winsAway;
    private String totalDraws;
    private String drawsHome;
    private String drawsAway;
    private String totalLosses;
    private String lossesHome;
    private String lossesAway;

}
