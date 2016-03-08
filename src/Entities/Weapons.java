package Entities;

public final class Weapons extends Entity{
	private double killPercentage;
	
	
	public Weapons(String weaponName) {
		super(weaponName);
		this.killPercentage = setKillPercentage(weaponName);
		
		if(this.killPercentage > 0)
		{
			return;
		}
		else
		{
			throw new AssertionError(); //cannot be instantiated 
		}
	}
	
	/* PUBLIC METHODS */
	public double getKillPercentage()
	{
		return this.killPercentage;
	}
	
	/* PRIVATE METHODS */
	private double setKillPercentage(String weaponType) 
	{
		if(weaponType.equals(Constants.Variables.WEAPON_TYPE_ONE)){
			return Constants.Variables.BASE_PISTOL_KILL_RATE;
		}
		else if(weaponType.equals(Constants.Variables.WEAPON_TYPE_TWO))
		{
			return Constants.Variables.BASE_PISTOL_KILL_RATE;
		}
		else if(weaponType.equals(Constants.Variables.WEAPON_TYPE_THREE))
		{
			return Constants.Variables.BASE_PISTOL_KILL_RATE;
		}
		else
		{
			return -1;
		}
	}
	
	/* PUBLIC METHODS */
	public String toString()
	{
		return "Weapon: " + super.toString() + "\n" + this.killPercentage;
	}

}
