package main;

import WrapperDTO.WrapperDTO;
import menus.Start;
import models.VolleyballPlayer;
import models.VolleyballTeam;
import services.CSVFileOperation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        try {
            BufferedReader playersListReader = new BufferedReader(new FileReader("ProgramFiles/PlayersList.csv"));
            BufferedReader teamsListReader = new BufferedReader(new FileReader("ProgramFiles/TeamsList.csv"));
            String line="";

                if (!(line = teamsListReader.readLine()).equals("")&&(playersListReader.readLine() != null)){
                ArrayList<VolleyballPlayer> playerList = CSVFileOperation.loadPlayersList();
                ArrayList<VolleyballTeam> teamsList=CSVFileOperation.loadTeamsFromCSV();
                WrapperDTO plTL=new WrapperDTO(playerList,teamsList);
                Start.menu(plTL);
            }else if (playersListReader.readLine() != null&&teamsListReader.readLine() == null){
                ArrayList<VolleyballPlayer> playerList = CSVFileOperation.loadPlayersList();
                ArrayList<VolleyballTeam> teamsList=new ArrayList<>();
                WrapperDTO plTL=new WrapperDTO(playerList,teamsList);
                Start.menu(plTL);
            } else if (playersListReader.readLine() == null&&!(line = teamsListReader.readLine()).equals("")) {
                ArrayList<VolleyballPlayer> playerList = new ArrayList<>();
                ArrayList<VolleyballTeam> teamsList=CSVFileOperation.loadTeamsFromCSV();
                WrapperDTO plTL=new WrapperDTO(playerList,teamsList);
                Start.menu(plTL);
            }else if (playersListReader.readLine() == null&&teamsListReader.readLine() == null){
                ArrayList<VolleyballPlayer> playerList = new ArrayList<>();
                ArrayList<VolleyballTeam> teamsList=new ArrayList<>();
                WrapperDTO plTL=new WrapperDTO(playerList,teamsList);
                Start.menu(plTL);
            }
        } catch (IOException e) {
            System.out.println("File Not Found.\n"+e.getMessage());
        }
    }
}
