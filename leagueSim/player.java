package leagueSim;

public abstract class player
{
    private String playerName;

    public player(String playerName)
    {
        this.playerName=playerName;
    }

    public String getPlayerName()
    {
        return playerName;
    }
}
