package menus;

import WrapperDTO.WrapperDTO;
import models.VolleyballPlayer;
import services.Validators;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayerMenu {
    public static VolleyballPlayer chosenPlayer(ArrayList<VolleyballPlayer> playersList, ArrayList<VolleyballPlayer> teamPlayers) {

        VolleyballPlayer player;
        int choice = 0;
        if (playersList.size() == 0) {
            System.out.println("Players List is Empty.");

        } else {
            showPlayers(playersList);
            System.out.print("Choose ID number of Player to add to the Team - > ");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            try {
                if (choice < 1 || choice > playersList.size()) {
                    System.out.println("Choice out of range(1-" + playersList.size() + ")!");
                    System.out.println("To another Player press ENTER");
                    try {
                        sc.nextLine();
                        System.in.read();
                    } catch (Exception e) {
                    }
                    chosenPlayer(playersList, teamPlayers);
                }
            } catch (NumberFormatException e) {
                System.out.println("Write a digit from 1 to " + playersList.size() + " including!");

                chosenPlayer(playersList, teamPlayers);
            }
        }
        return player = playersList.get(choice - 1);
    }

    public static void showPlayers(ArrayList<VolleyballPlayer> playersList) {
        System.out.println("Players details: \n");
        for (int i = 0; i < playersList.size(); i++) {
            System.out.println("ID - > " + (i + 1));
            System.out.println("Player Name - > " + playersList.get(i).getName());
            System.out.println("Position - > " + playersList.get(i).getPosition());
            System.out.println("Age - > " + playersList.get(i).getAge());
            System.out.println("Skills - > " + playersList.get(i).getSkills());
            System.out.println("Condition - > " + playersList.get(i).getCondition());
            System.out.println("================================================================");
        }
    }

    public static void addPlayer(ArrayList<VolleyballPlayer> playersList, ArrayList<VolleyballPlayer> teamPlayers) {

        System.out.println("Add players?");
        System.out.println("Yes / No");
        System.out.print("Your choice - > ");
        Scanner sc = new Scanner(System.in);
        String choice = sc.next();
        if (Validators.yesOrNo(choice, playersList, teamPlayers)) {

        }
        System.out.println("");
        VolleyballPlayer player = chosenPlayer(playersList, teamPlayers);
        teamPlayers.add(player);
    }

    public static void startTraining(WrapperDTO plTl) {
        showPlayers(plTl.getTeamPlayers());
        VolleyballPlayer player=choosePlayerToTrain(plTl);
        player.train();
        Start.menu(plTl);
    }
    public static void startResting(WrapperDTO plTl) {
        showPlayers(plTl.getTeamPlayers());
        VolleyballPlayer player=choosePlayerToRest(plTl);
        player.rest();
        Start.menu(plTl);
    }

    private static VolleyballPlayer choosePlayerToRest(WrapperDTO plTl) {
        VolleyballPlayer player;
        System.out.print("Choose ID number of Player to Rest - > ");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        try {
            if (choice < 1 || choice > plTl.getTeamPlayers().size()) {
                System.out.println("Choice out of range(1-" + plTl.getTeamPlayers().size() + ")!");
                System.out.println("To another Player press ENTER");
                try {
                    sc.nextLine();
                    System.in.read();
                } catch (Exception e) {
                }
                choosePlayerToTrain(plTl);
            }
        } catch (NumberFormatException e) {
            System.out.println("Write a digit from 1 to " + plTl.getTeamPlayers().size() + " including!");
            choosePlayerToTrain(plTl);
        }
        return player = plTl.getTeamPlayers().get(choice - 1);
    }

    public static VolleyballPlayer choosePlayerToTrain(WrapperDTO plTl) {
        VolleyballPlayer player;
        System.out.print("Choose ID number of Player to Train - > ");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        try {
            if (choice < 1 || choice > plTl.getTeamPlayers().size()) {
                System.out.println("Choice out of range(1-" + plTl.getTeamPlayers().size() + ")!");
                System.out.println("To another Player press ENTER");
                try {
                    sc.nextLine();
                    System.in.read();
                } catch (Exception e) {
                }
                choosePlayerToTrain(plTl);
            }
        } catch (NumberFormatException e) {
            System.out.println("Write a digit from 1 to " + plTl.getTeamPlayers().size() + " including!");
            choosePlayerToTrain(plTl);
        }
        return player = plTl.getTeamPlayers().get(choice - 1);
    }
}

