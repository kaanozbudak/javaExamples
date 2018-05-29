package leagueSim;

import java.lang.reflect.Array;
import java.util.Arrays;

public class main
{
    public static void main(String args[])
    {
        footballPlayer fp1=new footballPlayer("Kaan");
        footballPlayer fp2=new footballPlayer("Melih");

        basketballPlayer bp1=new basketballPlayer("Furkan");
        basketballPlayer bp2=new basketballPlayer("Umut");

        team<footballPlayer> bjk=new team("BJK");
        team<footballPlayer> gs=new team("GS");
        team<footballPlayer> fb=new team("FB");
        team<footballPlayer> trb=new team("TRB");

        team<basketballPlayer> efes=new team("EFES");
        team<basketballPlayer> dacka=new team("DACKA");

        bjk.addGamer(fp1);
        bjk.addGamer(fp2);
        System.out.println(bjk.sumTeamPlayers());
        gs.addGamer(fp1);
        gs.addGamer(fp2);
        System.out.println(gs.sumTeamPlayers());

        efes.addGamer(bp1);
        efes.addGamer(bp2);

        System.out.println("");
        gs.match(bjk,2,3);
        bjk.match(fb,3,2);
        fb.match(trb,2,2);
        trb.match(gs,2,3);

        gs.match(fb,2,3);
        bjk.match(gs,3,2);
        fb.match(trb,2,2);
        trb.match(bjk,2,3);

        gs.match(trb,2,3);
        bjk.match(gs,3,2);
        fb.match(fb,2,2);
        trb.match(bjk,2,3);

        System.out.println("");
        System.out.println("BJK total point: "+bjk.sumTeamPoint());

        System.out.println("GS total point: "+gs.sumTeamPoint());

        System.out.println("FB total point: "+fb.sumTeamPoint());

        System.out.println("TRB total point: "+trb.sumTeamPoint());

        team array[]={bjk,fb,gs,trb};

       /* int temp;
        for (int i=0;i<4;i++)
        {
            int index = i;
            for (int j = i; j < array.length; j++)
                if (array[j].sumTeamPoint() < array[index].sumTeamPoint())
                    index = j;

            int smallerNumber = array[index].sumTeamPoint();
            int a=array[index].sumTeamPoint();
            int b=array[i].sumTeamPoint();
            a=b;
            b=smallerNumber;

            System.out.println(array[i].sumTeamPoint());

        }

        */

       league<team<footballPlayer>> league1=new league("Spor Toto 1. League");

        league1.addTeam(bjk);
        league1.addTeam(fb);
        league1.addTeam(gs);
        league1.addTeam(trb);

        league1.pointTable();

    }
}
