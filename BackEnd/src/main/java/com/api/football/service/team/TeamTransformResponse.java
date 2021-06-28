package com.api.football.service.team;

import com.api.football.model.response.team.Team;
import com.api.football.model.response.team.subtype.*;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class TeamTransformResponse {

    public Team transformResponse(ResultSet result) throws SQLException {
        Team team = new Team();
        result.next();
        team.setTeamName(result.getString("team_name"));
        team.setCommonName(result.getString("common_name"));
        team.setSeason(result.getString("season"));
        team.setCountry(result.getString("country"));
        team.setLeaguePosition(result.getString("league_position"));
        team.setCorners(result.getString("corners_total"));
        team.setCards(result.getString("cards_total"));

        team.setMatches(new Matches());
        team.getMatches().setPlayed(result.getString("matches_played"));
        team.getMatches().setPlayedHome(result.getString("matches_played_home"));
        team.getMatches().setPlayedAway(result.getString("matches_played_away"));

        team.setGoals(new Goals());
        team.getGoals().setScored(result.getString("goals_scored"));
        team.getGoals().setScoredHome(result.getString("goals_scored_home"));
        team.getGoals().setScoredAway(result.getString("goals_scored_away"));
        team.getGoals().setConceded(result.getString("goals_conceded"));
        team.getGoals().setConcededHome(result.getString("goals_conceded_home"));
        team.getGoals().setConcededAway(result.getString("goals_conceded_away"));
        team.getGoals().setDifference(result.getString("goal_difference"));

        team.setResult(new Result());
        team.getResult().setTotalWins(result.getString("wins"));
        team.getResult().setWinsHome(result.getString("wins_home"));
        team.getResult().setWinsAway(result.getString("wins_away"));
        team.getResult().setTotalDraws(result.getString("draws"));
        team.getResult().setDrawsHome(result.getString("draws_home"));
        team.getResult().setDrawsAway(result.getString("draws_away"));
        team.getResult().setTotalLosses(result.getString("losses"));
        team.getResult().setLossesHome(result.getString("losses_home"));
        team.getResult().setLossesAway(result.getString("losses_away"));

        team.setCleanSheets(new CleanSheets());
        team.getCleanSheets().setTotal(result.getString("clean_sheets"));
        team.getCleanSheets().setHome(result.getString("clean_sheets_home"));
        team.getCleanSheets().setAway(result.getString("clean_sheets_away"));

        team.setShots(new Shots());
        team.getShots().setTotal(result.getString("shots"));
        team.getShots().setOnTarget(result.getString("shots_on_target"));
        team.getShots().setOffTarget(result.getString("shots_off_target"));

        team.setFouls(new Fouls());
        team.getFouls().setTotal(result.getString("fouls"));
        team.getFouls().setHome(result.getString("fouls_home"));
        team.getFouls().setAway(result.getString("fouls_away"));

        return team;
    }

}
