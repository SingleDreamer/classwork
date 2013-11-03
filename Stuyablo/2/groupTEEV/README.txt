Terrance, Eric, Emily, Veronika

Basic Player Attributes
=========================
Strength- This is basically how much damage the character does. 
	As of now we will not include an intelligence attribute, for it acts similarly to that of strength.

Dexterity- This will account for accuracy as well as defense.

Health- the current amound of health (base of 100, max health will be dependent on level of player

Experience- gained throughout the game as players slay ogres. Level up at 100

Level- gain extra points in stats (Strength or Dexterity)


Basic Player and Nonplayer Methods
==========================
Attack() - players or ogres will attack one another using their respective attack skills 
	This includes the roll for the "accuracy" part

status() - Current health of both fighters, and other miscellaneous information. 

loseHealth(int n) - this allows ogres and players to call upon each other to inflict damage

gainHealth(int n) - same as loseHealth

Battle() - calls upon a series of Attack() where the status of the entire battle will be printed out.
	Ends when a player/ogre has 0 health

Retreat() - avoid a battle
	Experience would be lost upon a retreat


Player Specific Methods 
=============================
gainExp(int n) - gains a specific amount of experience

addStrength() - +1 to strength

addDexterity() - +1 to dexterity

skill#() - inflicts this much damage and has this much accuracy
	This will be called upon by the player through a scanner for each Attack()
	Each player should have 3-4 attack skills


Nonplayer/Ogre Specific Methods
===============================
skill#() - same as player, but much weaker to make game somewhat easier

encounter(player name) - will run every "turn" or now and then (not sure how to do this yet)
	Based on a Math.Random() within a certain range, 
	the ogre will "encounter" the player, asking them to Battle() or Retreat()



