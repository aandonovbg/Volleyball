package services;

import models.VolleyballTeam;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class PlayMatch {
    public static void PlayMatch(VolleyballTeam team1, VolleyballTeam team2) {
        Random rand = new Random();
        int gameCounter1 = 0;
        int gameCounter2 = 0;
        while (gameCounter1 != 3 || gameCounter2 != 3) {
            int luck1 = rand.nextInt(25) + 1;
            int luck2 = rand.nextInt(25) + 1;
            if (team1.calculateStrength() + luck1 > team2.calculateStrength() + luck2) {

                gameCounter1++;
            } else if (team1.calculateStrength() + luck1 < team1.calculateStrength() + luck2) {

                gameCounter2++;
            }
        }

        if (gameCounter1>gameCounter2){
            System.out.println(team1.getName() + " WON the match!");
        } else if (gameCounter1<gameCounter2) {
            System.out.println(team2.getName() + " WON the match!");
            ArrayList<String> results=CSVFileOperation.loadResults();
            results.add(team2.getName() + " WON the match!");
            CSVFileOperation.saveResults(results);
        }
    }
}
