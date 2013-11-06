Terrance, Eric, Emily, Veronika

Basic Player Attributes
=========================
Strength- This is basically how much damage the character does. 
	As of now we will not include an intelligence attribute, for it acts similarly to that of strength.

Dexterity- This will account for accuracy as well as defense.

Health- the current amound of health (base of 100, max health will be dependent on level of player

Experience- gained throughout the game as players slay ogres. Level up at 100

Level- gain extra points in stats (Strength or Dexterity)

Intelligence-

Gold-gained when leveling up

Character class methods
==========================
getStatus-returns status of all current attributes

loseHealth(int n) - this allows ogres and players to call upon each other to inflict damage

setStat- calls setIntelligence, setStrength and setDexterity until its called all three or the 8 available points have
	entirely run out.

setIntelligence-adds a certain number of points to intelligence, following same rules as setDexterity

setDexterity- adds a certain number of points to dexterity, following the same rules as setStrength

setStrength- adds a certian amount of points to strength(depending on imput, but must be less than or equal
	to available points to be distributed)


Player Specific Methods 
=============================
attack(charcter type)- gives you three options of attack, basicattack, special attack 1 and special attack 2, 
	and depending on input runs one of the attacks unless your cooldown is too high
	
levelUp()- levels up a character, increases their health, gold and expperience, also gives more points to 
	be distribued among the attributes

basicattack-increases damage, decreases cooldown variable and attempts to hit; different damage points depending on 
	character

specialattack1-attacks with special weapons, and damage done to warrior is in strength, but damage done to wizard is intelligence
	sets cooldown to 1
specialattack2-same as specialattack 1 but with different weapons and thus different hit and damage returns

hit is decided if the sum of 3 random 6 sided dice being rolled is less than dexterity
battle goes for as long as health exists, and gold and experience is gained. if you have won, then action method is called

action- allows you to choose wether or not to heal yoursel, keep fighting or check status

flee- you flee and lose experience points

encounter-plays an encounter for whether you have encountered moran or an ogre, allows you to fight or flee

Nonplayer/Ogre Specific Methods
===============================
attack methods work basically the same with three attacks possible, basic, special 1 and special 2, except it depends on
random rather than input




