Group Members: James Kong, James Chen, Jamie Yip, Dmitriy Kagno, Victor Gaitour

Instance Variables that we will have:
protected String name;
protected int health;
protected int intelligence;
protected int strength;
protected int dexterity;
protected int level;

It will be turned based. Players will attack other NPCs and the NPC will take damage, the same applies to the NPC, it will attack and the player will be dealt damage.
Players will have the option whether to leave or to continue fighting while the NPC will attempt to flee when they reach a certain health (10% or less). A scanner will be used for th player to choose an option. There will also be an encounter method that will be used to dictate which enemy the Player enemy has to fight. For example there will be a 75% chance that the enemy will be an orge,and a 25% chance it will be Mr Moran.
When the NPC's health reaches 0 the battle is over and a new battle will begin shortly, and if the Player's health reaches 0 the game ends. Dexterity will determine the chance of whether a hit is successful or not. Level will determine the amount of bonus points in stats. Strength will determine the damage for the Warrior and Intelligence will determine the damage for the Wizard.

