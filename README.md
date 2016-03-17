WELCOME TO:
==========================================================================================
	 ________  ________  _____ ______   ________  ___  _______   ________
	|\_____  \|\   __  \|\   _ \  _   \|\   __  \|\  \|\  ___ \ |\   ____\
	 \|___/  /\ \  \|\  \ \  \\\__\ \  \ \  \|\ /\ \  \ \   __/|\ \  \___|_
       	     /  / /\ \  \\\  \ \  \\|__| \  \ \   __  \ \  \ \  \_|/_\ \_____  \
            /  /_/__\ \  \\\  \ \  \    \ \  \ \  \|\  \ \  \ \  \_|\ \|____|\  \
	   |\________\ \_______\ \__\    \ \__\ \_______\ \__\ \_______\____\_\  \
	    \|_______|\|_______|\|__|     \|__|\|_______|\|__|\|_______|\_________\
                                                                        \|_________|
==========================================================================================

Humanity is on the brink of extinction. All hope is lost for humanity! Fortunately a group of consultants have barricaded themselves at TapQA headquarters and have developed an algorithm to save the world. This group of consultants won't be able to save humanity by themselves. They require the assistance of humanity's last combined army. Unfortunately it will take 15 days for this army to arrive to extract the consultants. Until extraction at least one consultant must survive the zombies that only attack during the night as well as not run out of supplies.

==========================================================================================
BASIC REQUIREMENTS
==========================================================================================
  -This will be a "simple" console program that will simulate the survival of a set of consultants (10)
        ** We will use parts of this program in the future to construct a GUI game **
  -The consultants will start with a base food supply (100)
        - food units will be decremented per surviving consultant after each full turn
  -There should be two phases in 1 turn:
        -A stats phase where a player can at least check the status of the group of consultants (survivors vs. incapacitated) and check existing supplies
        -A battle phase where a random generated number of zombies will attack the consultants
  -A win condition is met when after the 15th turn at least one consultant survives
  -A loss condition is met when all the consultants have perished (Game should end immediately without reaching the next phase)
  -This game should be losable as well as winnable!

==========================================================================================
THE START
==========================================================================================
  -A player will be able to choose the starting weapon for the consultants (should have a choice of weapons, i.e. handgun, shotgun, axe....)
      ** for simplicity we will only allow one weapon selection **
  -Each weapon should have a probability to kill a zombie (the probability is up to you but it should mimic realism)
      i.e. axe = 85% chance of killing a zombies upon hitting, handgun 65% chance to kill, and shotgun 45% chance to kill

==========================================================================================
STATS PHASE
==========================================================================================
  -The food supply should decrement by how many surviving consultants before the player is able to check stats
  -Consultants will die this turn if there is not enough food for each consultant
  -The game will end if after calculations there are no surviving consultants.
  -The player will be able to check the remaining consultants
  -The player will be able to check the remaining food supply
  -Once satisfied the player can choose to enter the battle phase

==========================================================================================
BATTLE PHASE
==========================================================================================
  -A randomly generated number of zombies (5-25) will attack the consultants each battle phase
  -A consultant or zombie will die once a "hit" is achieved
  -No consultant or zombie will die if a "miss" is achieved
  -Total amount of consultants will decrement upon perishing
  -Total amount of zombies will decrement upon perishing
  -If the number of consultants reaches 0 before the number of zombies reaches 0 for that battle phase the game ends

  ** The battle should be 1 consultant vs 1 zombie. As soon as one zombie or one consultant perishes the next one will take its place. The weapon chosen at the beginning will be the same for each consultant. You can automate the battle phase or have it done turn based, your decision. 

==========================================================================================
OTHER	REQUIREMENTS
==========================================================================================
  -This will require the use of an object oriented programming language
  -Your program should display proper use of inheritance
  -Your program should display proper use of polymorphism
  -Static variables, if any, should be kept to a minimum
  -Your program should contain overloaded methods
  -Your program should be elegant and organized
  -You should have at least one superclass, and have at least 1 subclass

==========================================================================================
EXTRAS
==========================================================================================
  As you can tell the requirements above are very one sided but the game is still winnable. Add other options to the game that can improve the game's outcome for the consultants. For example: enable the random finding of food supplies after each night, add other items to the game, etc. Make sure though that the game is still balanced after each extra option added. In other words there is still the possibility of losing in the game.

==========================================================================================
NOTES
==========================================================================================
Requirements are subject to change.

==========================================================================================
Running Requirements
==========================================================================================
Requirements:
  -JRE 6+ (In order to run the program)
  -JDK 6+ (To develop java programs)
  ** http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html
  
Compiling:
  -Open terminal or cmd line
  -Change directories to folder containing the project
  -Compile the driver class (i.e. javac main.java)
  -Run the program
