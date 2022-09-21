package br.com.pareschi;

public class Main {

    public static void main(String[] args) {

        SoccerPlayer soccerPlayer = new SoccerPlayer("Gabigol");
        SoccerPlayer soccerPlayer1 = new SoccerPlayer("Henrique");
        SoccerPlayer soccerPlayer2 = new SoccerPlayer("Algum jogador do flamengo");

        Team<SoccerPlayer> team = new Team<>("Flamengo");

        Team<BaseballPlayer> team1 = new Team<>("Squatter");

        League<Team<SoccerPlayer>> teamLeague = new League<>("Brasileirão");
        teamLeague.addTeam(team);
        teamLeague.print();
    }
}
