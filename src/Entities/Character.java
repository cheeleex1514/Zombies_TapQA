package Entities;

public class Character extends Entity{
	
	private boolean isAlive;
	
	public Character(String consultantName) {
		super(consultantName);
		this.isAlive = true;
	}
	
	/*Accessors & Mutators*/
	public boolean isAlive()
	{
		return this.isAlive;
	}
	
	public void setAlive(boolean alive)
	{
		this.isAlive = alive;
	}
	
	public String toString()
	{
		return super.toString() + "\nAlive: " + this.isAlive;
	}

}
