Terrance Liang, Eric Morgenstern, Emily Ruby, Veronika Azzara

Basic Player Attributes
=========================
Strength- This is basically how much damage the character does. 

Dexterity- This will account for accuracy.

Health- the current amount of health (base of 100, max health will be dependent on level of player)

Experience- gained throughout the game as players slay ogres. Level up at 100

Level- more health and gain 3 extra points in stats (Strength, Intelligence or Dexterity)

Intelligence- "Strength" for wizards or Mr. Moran

Gold- gained when leveling up and when defeating an ogre/Mr. Moran
	gold is used to restore health

charClass - for players: wizard or warrior
	for nonplayers: Ogre or Mr. Moran

Character class methods
==========================
getStatus()-returns status of all current attributes

getHealth()-returns health

loseHealth(int n) - this allows ogres and players to call upon each other to inflict damage

setStat- calls setIntelligence, setStrength and setDexterity until its called all three or the 8 available points have
	entirely run out.
	called at the beginning of the game once the name and class is established

setIntelligence()-adds a certain number of points to intelligence, following same rules as setDexterity

setDexterity()- adds a certain number of points to dexterity, following the same rules as setStrength

setStrength()- adds a certian amount of points to strength(depending on imput, but must be less than or equal
	to available points to be distributed)




Player Specific Methods 
=============================
attack(character name)- gives you three options of attack, basicattack, special attack 1 and special attack 2, 
	and depending on input runs one of the attacks unless your cooldown is too high
	There are cooldowns for special attack 1 and special attack 2
	cooldowns are reduced after a basic attack
	
levelUp()- levels up a character, increases their health, gold and expperience, also gives 3 more points to 
	be distribued among the attributes

basicattack(Nonplayer other)-increases damage, decreases cooldown variable and attempts to hit; different damage points depending on 
	character

specialattack1 (Nonplayer other)-attacks with special weapons, and damage done to warrior is in strength, but damage done to wizard is intelligence
	sets cooldown to 1 turn

specialattack2 (Nonplayer other)-same as specialattack 1 but with different weapons and thus different hit and damage returns
	sets cooldown to 3 turns

hit() is decided if the sum of 3 random 6 sided dice being rolled is less than dexterity

battle() goes for as long as health exists, and gold and experience is gained. if you have won, then action method is called

action()- allows you to choose whether or not to heal yourself (by paying gold), keep fighting, or check status
	most of the time, you will be returned to this method, unless you have died in a battle

flee()- you flee and lose experience points

encounter()-plays an encounter for whether you have encountered Mr.Moran or an ogre, allows you to fight or flee

Nonplayer/Ogre Specific Methods
===============================
attack() methods work basically the same with three attacks possible, basic, special 1 and special 2, except it depends on
random rather than input.

Note: In this Stuyablo game, the player will be playing until he or she dies.



