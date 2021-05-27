package com.api.football.service.team;

import com.api.football.exception.DataNotFoundException;
import com.api.football.model.request.team.TeamRequest;
import com.api.football.model.response.team.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.Locale;

@Component
public class TeamService {

    @Autowired
    TeamTransformResponse teamTransformResponse;

    @Value("${football.team.url}")
    private String url;

    @Value("${football.mysql.username}")
    private String userName;

    @Value("${football.mysql.password}")
    private String password;

    String query = "SELECT * FROM team WHERE common_name = ";
    Statement statement;
    Connection connection;
    ResultSet resultSet;

    public Team getTeam(TeamRequest request) throws DataNotFoundException, SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(url, userName, password);
        statement = connection.createStatement();

        String teamName = request.teamName.toLowerCase(Locale.ROOT);
        try {
            resultSet = statement.executeQuery(query + "\"" + teamName + "\"");
            Team team = teamTransformResponse.transformResponse(resultSet);
            statement.close();
            connection.close();
            return team;

        } catch (SQLException e) {
            throw new DataNotFoundException("This team does not exist. Please try again with a valid team");
        }
    }
}
