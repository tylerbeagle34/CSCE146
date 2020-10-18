/*
 * Written by Warren Beagle
 * Homework03: Rock, Paper, Scissors Double Round Robin Tournament
 */
public class Player {
	//Instance variables
	private int name;
	private int wins;
	private int losses;
	private int ties;
	//Constructors
	public Player() //Default
	{
		this.name = 0;
		this.wins = 0;
		this.losses = 0;
		this.ties = 0;
	}
	public Player(int aName, int aWins, int aLosses, int aTies) //Parameterized
	{
		this.setName(aName);
		this.setWins(aWins);
		this.setLosses(aLosses);
		this.setTies(aTies);
	}
	public int getName() //Accessor
	{
		return name;
	}
	public void setName(int name) //Mutator
	{
		if(name >=0) //Checks for correct values
		{
			this.name = name;
		}
	}
	public int getWins() 
	{
		return wins;
	}
	public void setWins(int wins) 
	{
		if(wins >= 0)
		{
			this.wins = wins;
		}
	}
	public int getLosses() 
	{
		return losses;
	}
	public void setLosses(int losses) 
	{
		if(losses >= 0)
		{
			this.losses = losses;
		}
	}
	public int getTies() 
	{
		return ties;
	}
	public void setTies(int ties) 
	{
		if(ties >= 0)
		{
			this.ties = ties;
		}
	}
	//Other methods
	public boolean equals(Player aPlayer)
	{
		return aPlayer != null && aPlayer.name == name && aPlayer.wins == wins && aPlayer.losses == losses && aPlayer.ties == ties;
	}
	public String toString()
	{
		return "Name: " + name + " Wins: " + wins + " Losses: " + losses + " Ties: " + ties;
	}
	//Adds a win
	public void addWin()
	{
		this.wins ++;
	}
	//Adds a loss
	public void addLoss()
	{
		this.losses ++;
	}
	//Adds a tie
	public void addTie()
	{
		this.ties ++;
	}
}
