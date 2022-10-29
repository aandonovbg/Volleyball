package models;


import java.io.Serializable;
import java.util.ArrayList;

public class VolleyballTeam implements Serializable {
    private String name, stadium, trainer;
    ArrayList<VolleyballPlayer> teamPlayers;

    public VolleyballTeam(String name, String stadium, String trainer, ArrayList<VolleyballPlayer> teamPlayers) {
        this.name = name;
        this.stadium = stadium;
        this.trainer = trainer;
        this.teamPlayers = teamPlayers;
    }

    public double calculateStrength() {
        double teamStrength=0;
        for (VolleyballPlayer player:this.teamPlayers){
            teamStrength+=player.getSkills();
        }
        return teamStrength/6;
    }
    private void teamTraining(){
        System.out.println("Team is training.");
    }

    private void teamRest(){
        System.out.println("Team is resting.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public ArrayList<VolleyballPlayer> getTeamPlayers() {
        return teamPlayers;
    }

    public void setTeamPlayers(ArrayList<VolleyballPlayer> teamPlayers) {
        this.teamPlayers = teamPlayers;
    }

    private void appendFieldValue(StringBuilder dataBuilder, String fieldValue) {
        if(fieldValue != null) {
            dataBuilder.append(fieldValue).append(",");
        } else {
            dataBuilder.append("").append(",");
        }
    }
    @Override
    public String toString() {
        StringBuilder dataBuilder = new StringBuilder();
        appendFieldValue(dataBuilder, name);
        appendFieldValue(dataBuilder, stadium);
        appendFieldValue(dataBuilder, trainer);
        appendFieldValue(dataBuilder, teamPlayers.toString());

        return dataBuilder.toString();
    }
}
