package leagueSim;

import java.util.ArrayList;

public class team <T extends player> implements Comparable<team<T>>
{
    private String teamName;
    int playedGame=0;
    int win=0;
    int lost=0;
    int equal=0;

    private ArrayList<T> players= new ArrayList<>();
    public team(String teamName)
    {
        this.teamName=teamName;
    }

    public String getTeamName()
    {
        return teamName;
    }

    public boolean addGamer(T newPlayer)
    {
        if (players.contains(newPlayer))
        {
            System.out.println((newPlayer).getPlayerName()+" already added by Kaan");
            return false;
        }
        players.add(newPlayer);
        System.out.println("Player "+(newPlayer).getPlayerName()+" is just added.");
        return true;
    }

    public int sumTeamPlayers()
    {
        return players.size();
    }
    public void match(team<T> enemy,int myScore,int enemyScore)
    {
        String message="";
        if (myScore>enemyScore)
        {
            win++;
            message="win";
        }
        else if (enemyScore>myScore)
        {
            lost++;
            message="lost";
        }
        else
        {
            equal++;
            message="equal";
        }
        playedGame++;

        if (enemy != null)
        {
            System.out.println(this.getTeamName()+" "+message+" "+enemy.getTeamName());
            enemy.match(null,enemyScore,myScore);
        }
    }
    public int sumTeamPoint()
    {
        return ((win*3)+equal);
    }


    @Override
    public int compareTo(team<T> o) {
        if (this.sumTeamPoint()>o.sumTeamPoint())
        {
            return 1;
        }
        else if (this.sumTeamPoint()<o.sumTeamPoint())
        {
            return -1;
        }
        else
            return 0;
    }
}
