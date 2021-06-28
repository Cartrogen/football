package com.api.football.model.response.player.subtype;

import lombok.Data;

@Data
public class Performance {
    private String goalsOverall;
    private String goalsHome;
    private String goalsAway;
    private String assistsOverall;
    private String assistsHome;
    private String assistsAway;
    private String penaltyGoals;
    private String penaltyMisses;
    private String cleanSheetsOverall;
    private String cleanSheetsHome;
    private String cleanSheetsAway;
    private String goalsConcededOverall;
    private String goalsConcededHome;
    private String goalsConcededAway;
}
