package menus;

import WrapperDTO.WrapperDTO;
import models.VolleyballTeam;
import services.CSVFileOperation;
import services.PlayMatch;
import services.Validators;

import java.util.Scanner;

public class Start {
    public static void menu( WrapperDTO plTl) {
        System.out.println("=====Main Menu =====");
        System.out.println("1. Create New Team.");
        System.out.println("2. Train.");
        System.out.println("3. Rest.");
        System.out.println("4. PLAY.");
        System.out.println("0. EXIT.");
        System.out.print("Your choice - > ");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        if (Validators.validateChoice(choice, 4)) {
            switch (choice) {
                case 0 -> {
                    CSVFileOperation.savePlayersListToCSVFile(plTl.getPlayersList());
                    CSVFileOperation.saveTeamsToCSV(plTl.getTeamsList());
                    return;
                }
                case 1->TeamMenu.enterNewTeam(plTl);
                case 2 -> PlayerMenu.startTraining(plTl);
                case 3-> PlayerMenu.startResting(plTl);
                case 4 -> chooseTeams(plTl);

                }
            }
        }

    public static void chooseTeams(WrapperDTO plTl){
        if (plTl.getTeamsList().size()==0){
            System.out.println("List is Empty.");
            System.out.println("Please first Create New Team.");
            TeamMenu.enterNewTeam(plTl);
        }else {
            VolleyballTeam team1=TeamMenu.chosenTeam(plTl);
            VolleyballTeam team2=TeamMenu.chosenTeam(plTl);
            PlayMatch.PlayMatch(team1, team2);
            System.out.println("To continue to Main Menu press ENTER");

            try {
                Scanner sc=new Scanner(System.in);
                sc.nextLine();
                System.in.read();
            } catch (Exception e) {
            }
            Start.menu(plTl);
        }
    }
}
