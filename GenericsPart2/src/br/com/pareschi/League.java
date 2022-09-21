package br.com.pareschi;

import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Team>{
    // Create a generic class to implement a league table for a sport.
    // The class should allow teams to be added to the list, and store
    // a list of teams that belong to the league.
    //
    // Your class should have a method to print out the teams in order,
    // with the team at the top of the league printed first.
    //
    // Only teams of the same type should be added to any particular
    // instance of the league class - the program should fail to compile
    // if an attempt is made to add an incompatible team.
    private String name;
    private ArrayList<T> teams = new ArrayList<>();

    public League(String name) {
        this.name = name;
    }

    public boolean addTeam(T team){
        if(teams.contains(team)){
            return false;
        }
        teams.add(team);
        return true;
    }

    public void print(){
        Collections.sort(teams);
        for(Team team: teams){
            System.out.println(team.getName()+ ": " + team.ranking());
        }
    }
}
