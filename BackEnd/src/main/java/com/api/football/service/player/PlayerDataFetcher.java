//package com.api.football.service.player;
//
//import com.api.football.model.response.player.Player;
//import com.api.football.model.response.team.Team;
//import com.api.football.model.response.team.subtype.*;
//import lombok.Data;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.csv.CSVFormat;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.stereotype.Component;
//import org.springframework.util.FileCopyUtils;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.StringReader;
//import java.nio.charset.StandardCharsets;
//import java.util.*;
//import java.util.stream.Collectors;
//
//@Slf4j
//@Component
//@Data
//public class PlayerDataFetcher {
//    private static final String PLAYER_CSV_FILE = "Players.csv";
//    private Map<List<String>, List<Team>> playerRecordsMap;
//
//    public PlayerDataFetcher() {
//        initialize(PLAYER_CSV_FILE);
//    }
//    private void initialize(String fileName) {
//        String csvData = readCsvData(fileName);
//
//        if (csvData != null) {
//            try (StringReader csvStringReader = new StringReader(csvData)) {
//                List<String> keyList = new ArrayList<>();
//                Map<List<String>, List<Team>> csvRecordsMap = CSVFormat.DEFAULT.
//                        withNullString("").withHeader("full_name", "age", "league", "season", "position", "current_club", "minutes_played_overall", "minutes_played_home", "minutes_played_away", "nationality", "appearances_overall", "appearances_home", "appearances_away", "goals_overall", "goals_home", "goals_away", "assists_overall", "assists_home", "assists_away", "penalty_goals", "penalty_misses", "clean_sheets_overall", "clean_sheets_home", "clean_sheets_away", "conceded_overall", "conceded_home", "conceded_away", "yellow_cards_overall", "red_cards_overall")
//                        .withSkipHeaderRecord()
//                        .withIgnoreHeaderCase()
//                        .parse(csvStringReader)
//                        .getRecords()
//                        .parallelStream()
//                        .collect(Collectors.groupingBy(
//                                 csvRecord -> {
//                                    keyList.add(csvRecord.get("full_name").toLowerCase(Locale.ROOT));
//                                    keyList.add(csvRecord.get("position").toLowerCase(Locale.ROOT));
//                                    return keyList;
//                                },
//                                Collectors.mapping(
//                                        csvRecord -> {
//                                            Player player = new Player();
//                                            player.setFullName(csvRecord.get("full_name"));
//                                            team.setCommonName(csvRecord.get("common_name"));
//                                            team.setSeason(csvRecord.get("season"));
//                                            team.setCountry(csvRecord.get("country"));
//                                            team.setMatches(new Matches());
//                                            team.getMatches().setPlayed(csvRecord.get("matches_played"));
//                                            team.getMatches().setPlayedHome(csvRecord.get("matches_played_home"));
//                                            team.getMatches().setPlayedAway(csvRecord.get("matches_played_away"));
//                                            team.setResult(new Result());
//                                            team.getResult().setTotalWins(csvRecord.get("wins"));
//                                            team.getResult().setWinsHome(csvRecord.get("wins_home"));
//                                            team.getResult().setWinsAway(csvRecord.get("wins_away"));
//                                            team.getResult().setTotalDraws(csvRecord.get("draws"));
//                                            team.getResult().setDrawsHome(csvRecord.get("draws_home"));
//                                            team.getResult().setDrawsAway(csvRecord.get("draws_away"));
//                                            team.getResult().setTotalLosses(csvRecord.get("losses"));
//                                            team.getResult().setLossesHome(csvRecord.get("losses_home"));
//                                            team.getResult().setLossesAway(csvRecord.get("losses_away"));
//                                            team.setLeaguePosition(csvRecord.get("league_position"));
//                                            team.setGoals(new Goals());
//                                            team.getGoals().setScored(csvRecord.get("goals_scored"));
//                                            team.getGoals().setScoredHome(csvRecord.get("goals_scored_home"));
//                                            team.getGoals().setScoredAway(csvRecord.get("goals_scored_away"));
//                                            team.getGoals().setConceded(csvRecord.get("goals_conceded"));
//                                            team.getGoals().setConcededHome(csvRecord.get("goals_conceded_home"));
//                                            team.getGoals().setConcededAway(csvRecord.get("goals_conceded_away"));
//                                            team.getGoals().setDifference(csvRecord.get("goal_difference"));
//                                            team.setCleanSheets(new CleanSheets());
//                                            team.getCleanSheets().setTotal(csvRecord.get("clean_sheets"));
//                                            team.getCleanSheets().setHome(csvRecord.get("clean_sheets_home"));
//                                            team.getCleanSheets().setAway(csvRecord.get("clean_sheets_away"));
//                                            team.setCorners(csvRecord.get("corners_total"));
//                                            team.setCards(csvRecord.get("cards_total"));
//                                            team.setShots(new Shots());
//                                            team.getShots().setTotal(csvRecord.get("shots"));
//                                            team.getShots().setOnTarget(csvRecord.get("shots_on_target"));
//                                            team.getShots().setOffTarget(csvRecord.get("shots_off_target"));
//                                            team.setFouls(new Fouls());
//                                            team.getFouls().setTotal(csvRecord.get("fouls"));
//                                            team.getFouls().setHome(csvRecord.get("fouls_home"));
//                                            team.getFouls().setAway(csvRecord.get("fouls_away"));
//                                            return player;
//                                        },
//                                        Collectors.toList())));
//                log.debug("csvRecordsMap: {}", csvRecordsMap);
//                this.playerRecordsMap = csvRecordsMap;
//
//            } catch (Exception e) {
//                log.error("Error while parsing input CSV.", e);
//            }
//        }
//    }
//
//
//    private String readCsvData(String fileName) {
//        ClassPathResource csvResource = new ClassPathResource(fileName);
//        try (InputStream csvResourceInputStream = csvResource.getInputStream()) {
//            byte[] csvByteArray = FileCopyUtils.copyToByteArray(csvResourceInputStream);
//            return new String(csvByteArray, StandardCharsets.UTF_8);
//        } catch (IOException e) {
//            System.out.println("Error loading CSV file for team data." + fileName);
//        }
//        return null;
//    }
//
//}
