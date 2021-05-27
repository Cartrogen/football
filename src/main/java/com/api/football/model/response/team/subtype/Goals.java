package com.api.football.model.response.team.subtype;

import lombok.Data;

@Data
public class Goals {

    private String scored;
    private String conceded;
    private String difference;
    private String scoredHome;
    private String scoredAway;
    private String concededHome;
    private String concededAway;

}
