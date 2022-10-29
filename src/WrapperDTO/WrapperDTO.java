package WrapperDTO;

import models.VolleyballPlayer;
import models.VolleyballTeam;

import java.util.ArrayList;

public class WrapperDTO {
    private ArrayList<VolleyballPlayer> playersList;
    private ArrayList<VolleyballTeam> teamsList;
    private ArrayList<VolleyballPlayer> teamPlayers;

    public WrapperDTO(ArrayList<VolleyballPlayer> playersList, ArrayList<VolleyballTeam> teamsList, ArrayList<VolleyballPlayer> teamPlayers) {
        this.playersList = playersList;
        this.teamsList = teamsList;
        this.teamPlayers = teamPlayers;
    }

    public WrapperDTO(ArrayList<VolleyballPlayer> playersList, ArrayList<VolleyballTeam> teamsList) {
        this.playersList = playersList;
        this.teamsList = teamsList;
    }

    public ArrayList<VolleyballPlayer> getPlayersList() {
        return playersList;
    }

    public void setPlayersList(ArrayList<VolleyballPlayer> playersList) {
        this.playersList = playersList;
    }

    public ArrayList<VolleyballPlayer> getTeamPlayers() {
        return teamPlayers;
    }

    public void setTeamPlayers(ArrayList<VolleyballPlayer> teamPlayers) {
        this.teamPlayers = teamPlayers;
    }

    public ArrayList<VolleyballTeam> getTeamsList() {
        return teamsList;
    }

    public void setTeamsList(ArrayList<VolleyballTeam> teamsList) {
        this.teamsList = teamsList;
    }
}
