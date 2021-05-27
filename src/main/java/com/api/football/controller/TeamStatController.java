package com.api.football.controller;

import com.api.football.model.response.team.Team;
import com.api.football.model.request.team.TeamRequest;
import com.api.football.service.team.TeamService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping(TeamStatController.PATH)
public class TeamStatController {

    public static final String PATH = "/team";
    public static final String GET_TEAM = "/getTeam";

    @Autowired
    private TeamService teamService;

    @PostMapping(value = GET_TEAM, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "get team", response = Team.class, httpMethod = "POST")
    public Team getTeam(@RequestBody TeamRequest request) throws SQLException, ClassNotFoundException {
        return teamService.getTeam(request);
    }
}