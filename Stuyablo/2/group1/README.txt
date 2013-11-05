
Group members: Kevin Kan, Tina Lee, George Vorobyev, Eric Wong


Basic Attributes:
_________________

Strength - Determines how much damage a character (physical strike) will do & how much health

Dexterity - Determines dodge chance and crit chance

Intelligence - Determines how much damage a character (spell) will do & how much mana

Armor - Determines how much damage is reduced by

Health - Amount of health remaning (max health determined by class and level)

Experience - Gain from killing NPC and lose when killed

Level - Gives player skill points to allocate

skill point - can be used to increase stats


Basic Methods (Both NPC and Player):
____________________________________

attack(target) - two parts: 1. determine if hit or miss
			    2. when hit, use str/int to determine how much damage to do
		 returns an integer

defend(damage) - two parts: 1. determine if dodge using dex
			    2. when hit, use armor to determine how much damage is taken

status() - will return current health or player/NPC and mana (if applicable)

flee() - leave battle (lose exp)


Player Methods:
______________

reward() - takes exp output from battle and either add/subtract the amount

addStat(int) - have number choices that correspond to a stat and will add one each time
	       return status as to how much skill points you have left

specialAttack(int) - each class has 4 special skills they can call
		     similar to basic attack but has a set % of hitting & base damage

Game Methods:
_____________

battle() - a while loop that will continually call attack and defend until player/NPC health = 0
	   return an int exp

ecounter() - randomly create an NPC for the player to battle