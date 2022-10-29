package models;

import WrapperDTO.WrapperDTO;
import menus.Start;
import services.CSVFileOperation;
import services.Validators;

import java.io.Serializable;
import java.util.Scanner;

public class VolleyballPlayer implements Serializable {
    private String name, position;
    private int age, skills, condition;

    public VolleyballPlayer(String name, String position, int age, int skills, int condition) {
        this.name = name;
        this.position = position;
        this.age = age;
        this.skills = skills;
        this.condition = condition;
    }
    public static void enterPlayers(WrapperDTO plTl) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Player's Name - > ");
        String playerName = sc.nextLine();
        System.out.print("Player's Position - > ");
        String playerPosition = sc.nextLine();
        System.out.print("Player's Age - > ");
        int playerAge = sc.nextInt();
        System.out.print("Player's Skills - > ");
        sc.nextLine();
        String choiceSkills = sc.nextLine();
        int playerSkills = Validators.validateSkillsCondition(choiceSkills, 10);
        System.out.print("Player's Condition - > ");
        String choiceCondition = sc.nextLine();
        int playerCondition = Validators.validateSkillsCondition(choiceCondition, 5);

        addPlayer(plTl,playerName,playerPosition,playerAge,playerSkills,playerCondition);
    }
    private static void addPlayer(WrapperDTO plTl,String playerName,String playerPosition,int playerAge,int playerSkills,int playerCondition){
        plTl.getPlayersList().add(new VolleyballPlayer(playerName, playerPosition, playerAge, playerSkills, playerCondition));
        CSVFileOperation.savePlayersListToCSVFile(plTl.getPlayersList());

        System.out.println("NEW Player successfully added to the list of players.");
        Start.menu(plTl);
    }
    public void rest(){
        if (getCondition()==5){
            System.out.println(getName()+" is fully rested");
        }else {setCondition(getCondition()+1);}
    }

    public void train(){
        if (getCondition()==1){
            System.out.println(getName()+" condition is 1, therefore he can't be training");
        }else {
            setSkills(getSkills()+1);
            setCondition(getCondition()-1);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSkills() {
        return skills;
    }

    public void setSkills(int skills) {
        this.skills = skills;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    private void appendFieldValue(StringBuilder dataBuilder, String fieldValue) {
        if (fieldValue != null) {
            dataBuilder.append(fieldValue).append(",");
        } else {
            dataBuilder.append("").append(",");
        }
    }

    @Override
    public String toString() {
        StringBuilder dataBuilder = new StringBuilder();
        appendFieldValue(dataBuilder, name);
        appendFieldValue(dataBuilder, position);
        appendFieldValue(dataBuilder, String.valueOf(age));
        appendFieldValue(dataBuilder, String.valueOf(skills));
        appendFieldValue(dataBuilder, String.valueOf(condition));

        return dataBuilder.toString();
    }
}
