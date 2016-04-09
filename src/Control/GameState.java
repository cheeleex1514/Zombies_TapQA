/**
 * Class for the game states
 */
package Control;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Entities.Character;
import Entities.Weapons;
public class GameState {

	private Weapons consultantWeapon;
	private Scanner scanner;
	private Random rand;
	private int daysRemaining;
	private int rationsCount;
	private int ammoCount;
	private boolean lossCondition;
	private int explorationCount;
	
	/**
	 * Constructor
	 */
	public GameState()
	{
		this.rationsCount = Constants.Variables.INITIAL_RATIONS;
		this.ammoCount = Constants.Variables.INITIAL_AMMO;
		this.daysRemaining = Constants.Variables.MAX_SURVIVAL_DAYS;
		this.rand = new Random();
		this.scanner = new Scanner(System.in);
	}
	
	/**
	 * Loads ArrayList for consultant characters
	 * @return
	 */
	private ArrayList<Character> loadConsultants()
	{
		return (ArrayList<Character>) Constants.Variables.CONSULTANT_NAMES;
	}
	
	/**
	 * Method for controlling flow of game states 
	 * 
	 * @param consultants 
	 * @throws InterruptedException 
	 */
	public void gameInstance(ArrayList<Character> consultants) throws InterruptedException
	{
		consultants = loadConsultants();
		consultantWeapon = chooseWeapon(this.scanner);
		System.out.println(this.consultantWeapon.getName() + " chosen!" +
							"\n-----------------------------------------------------");
		this.lossCondition = true;
		this.explorationCount = 0;
		
		do
		{
			daySequence(consultants, this.scanner);
			int totalSpawnedZombies = rand.nextInt(Constants.Variables.ZOMBIE_MAX_SPAWN)+1;
			lossCondition = battleSequence(consultants, consultantWeapon, rand, totalSpawnedZombies);
			
			if(lossCondition)
			{
				System.out.println(Constants.Variables.ENDING_LOSS);
				break;
			}
			else
			{
				this.daysRemaining --;
			}

			
		}while(lossCondition == false && this.daysRemaining != 0);
		
		if(lossCondition == false && this.daysRemaining == 0)
		{
			System.out.println(Constants.Variables.ENDING_WIN);
		}
		else
		{
			System.out.println("Game Over...");
		}
	}
	
	private Weapons chooseWeapon(Scanner scan)
	{
		Weapons tempWeapon = null;
		int usrSelection = 0;
		
		System.out.println(Constants.Variables.WEAPON_SELECTION);
		
		if(scan.hasNextInt())
		{
			usrSelection = Integer.parseInt(scan.nextLine());
		}
		else
		{
			throw new IllegalArgumentException();
		}	
		
		while(tempWeapon == null)
		{
			if(usrSelection > 0 && usrSelection <= 3)
			{
				if(usrSelection == 1){return tempWeapon = new Weapons(Constants.Variables.WEAPON_TYPE_ONE);}
				if(usrSelection == 2){return tempWeapon = new Weapons(Constants.Variables.WEAPON_TYPE_TWO);}
				if(usrSelection == 3){return tempWeapon = new Weapons(Constants.Variables.WEAPON_TYPE_THREE);}
			}
			else
			{
				throw new IllegalArgumentException();
			}
		}
		
		return tempWeapon;
	}
	
	/**
	 * Method for day sequence. 
	 * Options -
	 * [1] Check living characters
	 * [2] Check remaining supplies
	 * [3] Explore for supplies
	 * [4] Prepare for nightfall
	 * 
	 * @param consultants Consultants array
	 * @param scan	Scanner for user input **this parameter under review
	 * @throws InterruptedException **dependant on scanner parameter
	 */
	private void daySequence(ArrayList<Character> consultantsArray, Scanner scan) throws InterruptedException
	{
		boolean playerContinues = false;
		int usrInput = 0;
		int dailyExplorationCount = 0;
		
		System.out.println("Days remaing until extration: " + (this.daysRemaining));
		
		do
		{
			System.out.println(Constants.Variables.DAY_MENU);
			
			if(scan.hasNextInt())
			{
				usrInput = Integer.parseInt(scan.nextLine());
			}
			else
			{
				throw new IllegalArgumentException();
			}
						
			switch(usrInput)
			{
				case 1:
					System.out.println("Remaining consultants: " + consultantsArray.size() +
							"\n-----------------------------------------------------");
					break;
				case 2:
					System.out.println("Remaining rations: " + this.rationsCount);
					System.out.println("Remaining ammo: " + this.ammoCount +
							"\n-----------------------------------------------------");
					break;
				case 3:
					char exploreChoice = 0;
					if(this.explorationCount == 0){
						System.out.println("Exploring cost an additional supply count of 3 per exploration." + 
										   "\nYou can find more supplies and ammo but there is a chance to encounter zombies also!" + 
										   "\nDo you wish to continue? [y] or [n]");

						if(scan.hasNextLine())
						{
							String temp = scan.next();
							exploreChoice = temp.charAt(0);
						}
						else if(scan.hasNext())
						{
							String temp = scan.next();
							exploreChoice = temp.charAt(0);
						}
						else
						{
							throw new IllegalArgumentException();
						}
					}
					else
					{
						System.out.println("Confirm explore? [y] or [n]");
						exploreChoice = scan.next(".").charAt(0);
					}
					
					if(dailyExplorationCount != Constants.Variables.EXPLORE_REQUIREMENTS && 
							this.rationsCount > Constants.Variables.EXPLORE_REQUIREMENTS && 
							(this.ammoCount >= Constants.Variables.EXPLORE_REQUIREMENTS || this.consultantWeapon.getName().equals("Sword")))
					{
						explorationCount ++;
						
						if(scan.hasNext())
						{
							exploreChoice = scan.next("\b\n").charAt(0);
						}
						
						if(exploreChoice == 'y' || exploreChoice == 'Y')
						{
							this.rationsCount = this.rationsCount - Constants.Variables.EXPLORE_REQUIREMENTS;
							exploreSequence(consultantsArray);
						}
						else
						{
							break;
						}
					}
					else if(this.explorationCount > 0)
					{
						explorationCount ++;
						if(exploreChoice == 'y' || exploreChoice == 'Y')
						{
							this.rationsCount = this.rationsCount - Constants.Variables.EXPLORE_REQUIREMENTS;
							exploreSequence(consultantsArray);
						}
						else
						{
							break;
						}
					}
					else
					{
						if(dailyExplorationCount >= Constants.Variables.EXPLORE_REQUIREMENTS)
						{
							System.out.println("You are unable to explore any more than 3 times a day! You should prepare for night fall!");
						}
						
						if(this.rationsCount <= Constants.Variables.EXPLORE_REQUIREMENTS)
						{
							System.out.println("You do not have enough supplies to explore! You are unable to explore at the moment...");
						}
						
						if(this.ammoCount < Constants.Variables.EXPLORE_REQUIREMENTS)
						{
							System.out.println("You do not have enough ammo to explore safely...");
						}
						
					}
					
					break;
					
				case 4:
					if(consultantWeapon.getName().equals(Constants.Variables.WEAPON_TYPE_ONE))
					{
						this.rationsCount = this.rationsCount - (consultantsArray.size()*2);
						System.out.println((consultantsArray.size()*2) + " rations consumed.");
					}
					else
					{
						this.rationsCount = this.rationsCount - consultantsArray.size();
						System.out.println(consultantsArray.size() + " rations consumed.");
					}
					
					System.out.println("Awaiting night fall..." +
							"\n-----------------------------------------------------");
					
					playerContinues = true;
					break;
				default:
					System.out.println("Invalid selection! Please choose again!");
					break;	
			}
		}
		while(playerContinues != true);
	}
	
	/**
	 * Battle sequence. 
	 * 
	 * @param list 
	 * @param weaponType
	 * @param rand
	 * @param spawns
	 * @return
	 */
	private boolean battleSequence(ArrayList<Character> consultantsArray, Weapons weaponType, Random  rand, int spawns)
	{		
		System.out.println(spawns + " zombies approaching! Goodluck!");

		while(consultantsArray.size() > 0 && spawns > 0){
			
			int consultantHitChance = rand.nextInt(9);
			boolean consultantMiss = false;
			
			if(this.ammoCount == 0)
			{
				System.out.println("You are out of ammo!!");
				consultantHitChance = 9;
			}
			
			switch(consultantHitChance)
			{
				case 0:
				case 1:
				case 2:
				case 3:					
				case 4:
				case 5:
					if((weaponType.getName().equals(Constants.Variables.WEAPON_TYPE_ONE) ||
							   weaponType.getName().equals(Constants.Variables.WEAPON_TYPE_TWO) ||
							   weaponType.getName().equals(Constants.Variables.WEAPON_TYPE_THREE)) && this.ammoCount > 0)
					{
						System.out.println(consultantsArray.get(0).getName() + " successfully killed a zombie!");
						spawns --;
						
						if(weaponType.getName().equals(Constants.Variables.WEAPON_TYPE_TWO))
						{
							this.ammoCount --;
						}
						
						if(weaponType.getName().equals(Constants.Variables.WEAPON_TYPE_THREE))
						{
							this.ammoCount = Math.max(0, this.ammoCount - 2);
						}
						
						break;
					}
				case 6:
				case 7:
					if(weaponType.getName().equals(Constants.Variables.WEAPON_TYPE_THREE) && this.ammoCount > 0)
					{
						System.out.println(consultantsArray.get(0).getName() + " successfully killed a zombie!");
						spawns --;
						this.ammoCount = Math.max(0, this.ammoCount - 2);
						
						break;
					}
				case 8:
					if(weaponType.getName().equals(Constants.Variables.WEAPON_TYPE_ONE))
					{
						System.out.println(consultantsArray.get(0).getName() + " successfully killed a zombie!");
						spawns --;
						break;
					}
				default:
					if(this.ammoCount <= 0)
					{
						System.out.println(consultantsArray.get(0).getName()+ " is panicking!");
						consultantMiss = true;
						break;
					}
					else
					{
						System.out.println(consultantsArray.get(0).getName()+" attacks and misses!");
						consultantMiss = true;
						break;
					}
			}
			
			if(consultantMiss == true && consultantsArray.size() != 0)
			{
				int zombieHitChance = rand.nextInt(19);
				if(this.ammoCount == 0){zombieHitChance = 0;}
				
				if(zombieHitChance == 0)
				{
					System.out.println("Zombie successfully kills "+consultantsArray.get(0).getName());
					consultantsArray.remove(0);
				}
				else
				{
					System.out.println("Zombie attacks and misses!");
				}
			}
			
			consultantMiss = false;
			System.out.println("Remaining zombies: " + spawns +
					" Remaining consultants: " + consultantsArray.size() +
					"\n-----------------------------------------------------");
			}
		
		if(consultantsArray.size() > 0 || spawns == 0)
		{
			System.out.println(Constants.Variables.SURVIVING_NIGHT);
			return false;
		}
		else
		{
			return true;
		}
	}
	
	private void exploreSequence(ArrayList<Character> consultants ) throws InterruptedException
	{
		int encounterChance = this.rand.nextInt(5);
		System.out.println("Exploration in progress...");
		Thread.sleep(1000);
		
		switch(encounterChance)
		{
			case 1:
				System.out.print("Zombies encounter!");
				int totalSpawnedZombies = rand.nextInt(Constants.Variables.ZOMBIE_MAX_EXPLORE_SPAWN)+1;
				if(battleSequence(consultants, consultantWeapon, rand, totalSpawnedZombies) == true)
				{
					System.out.println("You found some supplies and ammo!");
					this.ammoCount = this.ammoCount + this.rand.nextInt(15)+5;
					this.rationsCount = this.rationsCount + this.rand.nextInt(15)+5;
				}
				
				break;
			case 2:
			case 3:
				System.out.println("You found some supplies and ammo!");
				this.ammoCount = this.ammoCount + this.rand.nextInt(10)+3;
				this.rationsCount = this.rationsCount + this.rand.nextInt(10)+3;
				break;
			case 4:
			default:
				System.out.println("Unfortunately you were unable to find anything of use...");
		}
	}
}
