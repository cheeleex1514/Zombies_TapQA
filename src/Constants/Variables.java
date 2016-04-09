/**
 * Static class for variables
 */
package Constants;

import java.util.ArrayList;
import Entities.Character;

@SuppressWarnings("serial")
public final class Variables {
	public static final double BASE_PISTOL_KILL_RATE = .60;
	public static final double BASE_SHOTGUN_KILL_RATE = .80;
	public static final double BASE_SWORD_KILL_RATE = .90;

	public static final int INITIAL_RATIONS = 100;
	public static final int INITIAL_AMMO = 75;
	public static final int ZOMBIE_MAX_SPAWN = 25;
	public static final int ZOMBIE_MAX_EXPLORE_SPAWN = 10;
	public static final int MAX_SURVIVAL_DAYS = 15;
	//public static final int MAX_DAILY_EXPLORE_COUNT = 3;
	public static final int EXPLORE_REQUIREMENTS = 3;
	
	public static final String WEAPON_TYPE_ONE = "Sword";
	public static final String WEAPON_TYPE_TWO = "Pistol";
	public static final String WEAPON_TYPE_THREE = "Shotgun";
	
	public static final ArrayList<Character> CONSULTANT_NAMES = new ArrayList<Character>(){{
		add(new Character("Andrew"));
		add(new Character("Evan"));
		add(new Character("Dean"));
		add(new Character("Chee"));
		add(new Character("Chue"));
		add(new Character("Colin"));
		add(new Character("Isaiah"));
		add(new Character("Matt"));
		add(new Character("Nick"));
		add(new Character("Zach"));
	}};
	
	public static final String WEAPON_SELECTION = "Select a weapon for battle: " + 
												  "\n[1] Sword" +
												  "\n[2] Pistol" +
												  "\n[3] Double barrel Shotgun";
	
	public static final String DAY_MENU = "[1] Check living consultants" +
										  "\n[2] Check supplies" +
										  "\n[3] Explore for supplies" +
										  "\n[4] Bring on the zombies!";
	
	public static final String ENDING_LOSS = "All consultants have died! Humanity is lost....";
	
	public static final String ENDING_WIN = "Congratulations! The consultants have survived! You win!";
	
	public static final String SURVIVING_NIGHT = "YAY! The consultants have survived to live another day!";

	
	/**
	 * Constructor static class constructor
	 * @throws AssertionError Class should not be instantiable
	 */
	public Variables()
	{
		throw new AssertionError(); //cannot be instantiated
	}
}
