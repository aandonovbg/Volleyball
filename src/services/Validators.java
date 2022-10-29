package services;

import models.VolleyballPlayer;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static menus.PlayerMenu.addPlayer;

public class Validators {
    public static boolean yesOrNo(String choice, ArrayList<VolleyballPlayer> playersList,ArrayList<VolleyballPlayer> teamPlayers){
        boolean validateChoice = false;
        try {
            if (choice.equalsIgnoreCase("yes")||choice.equalsIgnoreCase("no")){
                validateChoice=true;

            }
        }catch (InputMismatchException e){
            System.out.println("Invalid choice! Enter YES or NO.");
            addPlayer(playersList,teamPlayers);
        }

        return validateChoice;
    }
    public static boolean validateChoice(int choice, int end) {
        boolean validateChoice = true;
        try {
            if (choice < 0 || choice > end) {
                System.out.println("Choice range can be from 0 to " + end + " including!");
                validateChoice = false;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid choice! Enter digit from 0 to " + end + " including!");
            validateChoice = false;
        }
        return validateChoice;
    }
    public static int validateSkillsCondition(String parameter,int end) {
        Scanner sc = new Scanner(System.in);
        try {
            if (Integer.parseInt(parameter) < 1 || Integer.parseInt(parameter) > end) {
                System.out.println("Range can be from 1 to "+end+" including!");
                if (end==10){
                    System.out.print("Enter Player's Skills - > ");
                    parameter = sc.nextLine();
                    validateSkillsCondition(parameter,end);
                }else if (end==5) {
                    System.out.print("Enter Player's Condition - > ");
                    parameter = sc.nextLine();
                    validateSkillsCondition(parameter, end);
                }
            }
        }catch (NumberFormatException e) {
            System.out.println("Invalid choice! Enter digit from 1 to "+end+" including!");
            if (end==10){
                System.out.print("Enter Player's Skills - > ");
                parameter = sc.nextLine();
                validateSkillsCondition(parameter,end);
            }else if (end==5) {
                System.out.print("Enter Player's Condition - > ");
                parameter = sc.nextLine();
                validateSkillsCondition(parameter, end);
            }
        }
        return Integer.parseInt(parameter);
    }
}
