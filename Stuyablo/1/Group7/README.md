Group 7
David Bang, Thomas Duda, Casper Lant, Seehe (Christina) Ko

Characters

Characters will a string representing their name and Character Class. 
They will also have an int representing health, strength, intelligence, dexterity, experience, gold.
They will have a double representing their x,y position and distance.
Each Character will also have a method of attack and flee.

Combat System

Characters encounter an enemy at a random chance, 
each time the character moves or a turn is over. 
If the character meets an enemy, you can either fight or flee 
( we might make it so that the you have to fight the enemy). 
If you choose to fight (by entering 1 when you are give the options), 
your stats will be taken into account. 
Each point in dex will serve to increase your accuracy 
(or your chance of attacking the enemy) by 1%, up to 100% 
(we will do this by asking if dex >= random.nextInt(100) then do some stuff...).

The amount of strength you have is proportional to the amount of hp your attack take away 
if the attack successfully hits the enemy. A good formula would be something like str/5 (or something else).
Int is basically a nearly useless stat for warriors 
(it will be used for wizards when we get to that) but it does increase the amount of dialogue each character is assigned.

A character can flee from their enemy and the chance you are able to flee from the 
enemy is dex > = random.nextInt (1000), thereby giving someone with 100 dex,
 a 101/1000 chance of fleeing and someone with 0 dex, a 1/1000 chance of fleeing.