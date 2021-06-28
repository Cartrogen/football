package com.api.football.model.response.team;

import com.api.football.model.response.team.subtype.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class Team {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String teamName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String commonName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String season;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String country;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String leaguePosition;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String corners;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String cards;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Matches matches;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Goals goals;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Result result;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private CleanSheets cleanSheets;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Shots shots;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Fouls fouls;
}

