package leagueSim;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class league <T extends team>
{
    private String leagueName;

    private ArrayList<T> allTeams=new ArrayList<>();

    league(String leagueName)
    {
        this.leagueName=leagueName;
    }

    public boolean addTeam(T newTeam)
    {
        if (allTeams.contains(newTeam))
        {
            return false;
        }
        allTeams.add(newTeam);
        return true;
    }
    int i=1;
    public void pointTable()
    {
        Collections.sort(allTeams, Collections.reverseOrder());
        for (T temp:allTeams)
        {
            System.out.println(i+"."+temp.sumTeamPoint()+"->"+temp.getTeamName());
        }
    }
}
