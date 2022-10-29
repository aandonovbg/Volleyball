package services;

import models.VolleyballPlayer;
import models.VolleyballTeam;

import java.io.*;
import java.util.ArrayList;

public class CSVFileOperation {
    public static void savePlayersListToCSVFile(ArrayList<VolleyballPlayer> playersList) {
        try {
            PrintWriter writer = new PrintWriter("ProgramFiles/PlayersList.csv");
            writer.println("Name,Position,Age,Skills,Condition");
            for (VolleyballPlayer player : playersList) {
                writer.println(player.toString());
            }
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found" + e.getMessage());
        }
    }

    public static ArrayList<VolleyballPlayer> loadPlayersList() {
        ArrayList<VolleyballPlayer> playerList = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("ProgramFiles/PlayersList.csv"));

            String line = "";
            String[] tempArr;
            while ((line = br.readLine()) != null) {
                tempArr = line.split(",");
                if (!tempArr[0].equals("Name")) {
                    playerList.add(new VolleyballPlayer(tempArr[0], tempArr[1], Integer.parseInt(tempArr[2]), Integer.parseInt(tempArr[3]), Integer.parseInt(tempArr[4])));
                }
            }
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return playerList;
    }

    public static void saveTeamsToCSV(ArrayList<VolleyballTeam> teamsList) {
        try {
            PrintWriter writer = new PrintWriter("ProgramFiles/TeamsList.csv");
            StringBuilder sb = new StringBuilder();
            for (VolleyballTeam team : teamsList) {
                sb.append(team.getName()).append(",");
                sb.append(team.getStadium()).append(",");
                sb.append(team.getTrainer()).append(",");
                sb.append(team.getTeamPlayers().toString().replace(']', ' ').replace("[", "").replace(",,", ",").replace(", ,", ""));
                writer.println(sb);
            }
            writer.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static ArrayList<VolleyballTeam> loadTeamsFromCSV() {
        ArrayList<VolleyballTeam> teamsList = new ArrayList<>();
        ArrayList<VolleyballPlayer> teamPlayers = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("ProgramFiles/TeamsList.csv"));
            String line = "";
            String[] tempArr;
            while ((line = br.readLine()) != null) {
                tempArr = line.split(",");
                for (int i = 3; i < tempArr.length; i += 5) {
                    teamPlayers.add(new VolleyballPlayer(tempArr[i], tempArr[i + 1], Integer.parseInt(tempArr[i + 2]), Integer.parseInt(tempArr[i + 3]), Integer.parseInt(tempArr[i + 4])));
                }
                teamsList.add(new VolleyballTeam(tempArr[0], tempArr[1], tempArr[2], teamPlayers));
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return teamsList;
    }

    public static void saveResults(ArrayList<String> results) {
        try {
            PrintWriter writer = new PrintWriter("results.txt");
            for (int i = 0; i < results.size(); i++) {
                writer.println(results.get(i));
            }
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    public static ArrayList<String> loadResults() {
        ArrayList<String> results = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("results.txt"));
            String line = "";
            while ((line = br.readLine()) != null) {
                results.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return results;
    }
}
