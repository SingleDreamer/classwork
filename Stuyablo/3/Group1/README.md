APCS Stuyablo
Period 3 Group 1
Sungwoo, Barak, Lawrence, Jason

#Characters

- Characters have 3 attributes(intelligence,dexterity,strength)
- Characters have 3 values dependent on each attribute:
- maximum weapon weight is dependent on strength
- magic damage is dependent on intelligence
- accuracy is dependent on effective dexterity vs 3d6
- Character's intial stat for each attribute is 8.
- Player has an additional 8 points to raise specific stat that he/she wants to raise.
- Player can choose weapons. Each weapon determines damage.
- Player has a distance variable that tells the distance between the player and other player(or NPC)
- Every player has a level. Level is raised through gaining experience from combat. After each level, 3 additional points are given to raise specific stat.


#Combat System

- When a player's encounter method is called, a battle is triggered between two characters
- Player has multiple options while in a battle:

1. Light attack(Less damage but more accurate)
2. Heavy attack(More damage but less accurate)
3. Use potion
4. Flee

- Effective stat is the overall stat (ex. effective strength = stat strength + weapon strength + potion bonus + spell bonus)
- Effective St acts as hit points and is reduced by taking hits, 0 Eff St is death of character.
- Effective dexterity is (stat dexterity) / (stat dexterity + level). If effective dexterity is higher than a randomized number, the opponent is hit with melee weapon. 
- For distance or magic weapons, the dexterity is that of the melee weapon minus 1 * distance.

- Player earns experience at the end of the battle
