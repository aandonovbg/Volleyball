package menus;

import WrapperDTO.WrapperDTO;
import models.VolleyballPlayer;
import models.VolleyballTeam;

import java.util.ArrayList;
import java.util.Scanner;

import static menus.PlayerMenu.chosenPlayer;
import static services.CSVFileOperation.saveTeamsToCSV;

public class TeamMenu {
    public static void enterNewTeam(WrapperDTO plTl) {
//        ArrayList<VolleyballTeam> teamsList = new ArrayList<>();
//        ArrayList<VolleyballPlayer> playersList = loadPlayersList();

        Scanner sc = new Scanner(System.in);
        System.out.print("Team's Name - > ");
        String teamName = sc.nextLine();
        System.out.print("Stadium's Name - > ");
        String stadiumName = sc.nextLine();
        System.out.print("Trainer's Name - > ");
        String trainerName = sc.nextLine();
        ArrayList<VolleyballPlayer> teamPlayers = new ArrayList<>();
        System.out.println("Add players from the List?");
        System.out.println("Yes / No");
        System.out.print("Your choice - > ");
        String choice = sc.next();
        WrapperDTO plTlTp = new WrapperDTO(plTl.getPlayersList(),plTl.getTeamsList(), teamPlayers);
        if (choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y")) {
            plTlTp = new WrapperDTO(plTl.getPlayersList(),plTl.getTeamsList(), teamPlayers);
            choosePlayers(plTlTp);
            addPlayersToTeam(plTlTp, teamName, stadiumName, trainerName);
        } else {
            addPlayersToTeam(plTlTp, teamName, stadiumName, trainerName);
        }
    }

    private static void choosePlayers(WrapperDTO plTlTp) {
        for (int i = 1; i <= 6; i++) {
            System.out.println("Choose player " + i + ":");
            VolleyballPlayer player = chosenPlayer(plTlTp.getPlayersList(), plTlTp.getTeamPlayers());
            plTlTp.getTeamPlayers().add(player);
            System.out.println(player.getName() + " successfully added to the Team.");
        }
        System.out.println("Team is full!");
    }

    private static void addPlayersToTeam(WrapperDTO plTpTl, String teamName, String stadiumName, String trainerName) {
        plTpTl.getTeamsList().add(new VolleyballTeam(teamName, stadiumName, trainerName, plTpTl.getTeamPlayers()));
        System.out.println("Team \"" + teamName + "\" successfully created.");
        System.out.println("Let's PLAY!!!");
        saveTeamsToCSV(plTpTl.getTeamsList());

        WrapperDTO plTl = new WrapperDTO(plTpTl.getPlayersList(), plTpTl.getTeamsList());

        Start.menu(plTl);
    }

    public static void showTeams(WrapperDTO plTl) {
        System.out.println("Teams details: \n");
        for (int i = 0; i < plTl.getTeamsList().size(); i++) {
            System.out.println("ID - > " + (i + 1));
            System.out.println("Team's Name - > " + plTl.getTeamsList().get(i).getName());
            System.out.println("Stadium's Name - > " + plTl.getTeamsList().get(i).getStadium());
            System.out.println("Trainer's Name - > " + plTl.getTeamsList().get(i).getTrainer());
            for (int j = 0; j < plTl.getTeamsList().get(i).getTeamPlayers().size(); j++) {
                System.out.println("Player Name - > " + plTl.getTeamsList().get(i).getTeamPlayers().get(j).getName());
                System.out.println("Position - > " + plTl.getTeamsList().get(i).getTeamPlayers().get(j).getPosition());
                System.out.println("Age - > " + plTl.getTeamsList().get(i).getTeamPlayers().get(j).getAge());
                System.out.println("Skills - > " + plTl.getTeamsList().get(i).getTeamPlayers().get(j).getSkills());
                System.out.println("Condition - > " + plTl.getTeamsList().get(i).getTeamPlayers().get(j).getCondition());
                System.out.println("****************************");
            }
            System.out.println("================================================================");
        }
        System.out.println("To continue to \"Main Menu\" press ENTER");
        try{
            System.in.read();
        } catch(Exception e){}
        Start.menu(plTl);
    }
    public static VolleyballTeam chosenTeam(WrapperDTO plTl){

        VolleyballTeam team;
        int choice = 0;
        if (plTl.getTeamsList().size() == 0) {
            System.out.println("Players List is Empty.");

        } else {
            showTeams(plTl);
            System.out.print("Choose ID number of Team - > ");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            try {
                if (choice < 1 || choice > plTl.getTeamsList().size()) {
                    System.out.println("Choice out of range(1-" + plTl.getTeamsList().size() + ")!");
                    System.out.println("To another Player press ENTER");
                    try {
                        sc.nextLine();
                        System.in.read();
                    } catch (Exception e) {
                    }
                    chosenTeam(plTl);
                }
            } catch (NumberFormatException e) {
                System.out.println("Write a digit from 1 to " + plTl.getTeamsList().size() + " including!");

                chosenTeam(plTl);
            }
        }
        return team = plTl.getTeamsList().get(choice - 1);
    }
}
