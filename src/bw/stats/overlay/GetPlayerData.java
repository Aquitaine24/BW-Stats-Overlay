package bw.stats.overlay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONObject;

public class GetPlayerData {
    private static String apikey = "c79a7945-857f-45dc-84c8-a3dc92b7ec20";
    private static String urlString = "https://api.hypixel.net/v2/player?key=";

    public static void GetPlayerData(String username) throws IOException {
        URL url = new URL(urlString + apikey + "&name=" + username);

        URLConnection con = url.openConnection();
        InputStream is = con.getInputStream();

        StringBuilder response = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line = null;

            while ((line = br.readLine()) != null) {
                response.append(line);

            }
            JSONObject jsonResponse = new JSONObject(response.toString());
            if (jsonResponse.getBoolean("success")) {
                JSONObject playerData = jsonResponse.optJSONObject("player");
                if (playerData != null) {
                    JSONObject stats = playerData.optJSONObject("stats");
                    if (stats != null) {
                        JSONObject bedwarsStats = stats.optJSONObject("Bedwars");
                        if (bedwarsStats != null) {
                            // Extract the required stats
                            String playerUsername = playerData.optString("playername", "N/A");
                            int playerStars = playerData.optJSONObject("achievements").optInt("bedwars_level", 0);
                            int playerFinalKills = bedwarsStats.optInt("final_kills_bedwars", 0);
                            int playerFinalDeaths = bedwarsStats.optInt("final_deaths_bedwars", 0);
                            int playerWinstreak = bedwarsStats.optInt("winstreak", 0);
                            int playerBedsBroken = bedwarsStats.optInt("beds_broken_bedwars", 0);
                            int playerBedsLost = bedwarsStats.optInt("beds_lost_bedwars", 0);
                            int playerLosses = bedwarsStats.optInt("losses_bedwars", 0);
                            int playerWins = bedwarsStats.optInt("wins_bedwars", 0);
                            double playerBedKD = playerBedsLost != 0 ? (double) playerBedsBroken / playerBedsLost
                                    : playerBedsBroken;
                            double playerKD = playerFinalDeaths != 0 ? (double) playerFinalKills / playerFinalDeaths
                                    : playerFinalKills;
                            double playerWinLoseRatio = playerLosses != 0 ? (double) playerWins / playerLosses
                                    : playerWins;

                            PlayerData player = new PlayerData(playerUsername, playerStars, playerKD, playerBedKD,
                                    playerWinLoseRatio, playerFinalKills, playerFinalDeaths, playerWinstreak);

                            System.out.println("Username: " + player.getUsername());
                            System.out.println("Stars: " + player.getStars());
                            System.out.println("Final Kills: " + player.getFinalKills());
                            System.out.println("Final Deaths: " + player.getFinalDeaths());
                            System.out.println("Win Streak: " + player.getWinStreak());
                            System.out.println("K/D Ratio: " + player.getKD());
                            System.out.println("Bed Win/Lose Ratio: " + player.getBedKD());
                            System.out.println("Win/Lose Ratio: " + player.getWinLoseRatio());
                        } else {
                            System.out.println("No Bedwars stats found for player.");
                        }
                    } else {
                        System.out.println("No stats found for player.");
                    }
                } else {
                    System.out.println("No player data found.");
                }
            } else {
                System.out.println("Failed to retrieve player data.");
            }

        }
    }
}
