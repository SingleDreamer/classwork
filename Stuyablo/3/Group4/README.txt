Steven Zabolotny, Michael Lim, George Drimba, Shane Lorenzen

CHARACTERS
==========

Have attributes stored as instance variables for the character. Initialized 
with certain values based on class picked in the beginning of the game. You 
start with each attribute at 8, and it will distribute 8 more points.

We also put a lot more health than just strength, because characters died a bit easily.
It will be multiplied by a factor that will be specific to the characters.

STR (Strength)
===============

Decides if you can use certain weapons. Weapons will not be stored by
name, but rather by value of their damage. To use a weapon of certain damage,
you must have strength of at least half that damage, with a deviation of
10 from those values. [Just an idea, not final]. This is a phenomenal way to correlate damage with weapons however I think their should be a distinction of the damage dealt upon each increment of strength (not just every deviation of 10).

We haven't implemented weapons yet, but this is a future idea for development.

DEX {Dexterity)
===============

Decides whether you hit or miss. Three six-sided die are rolled, if your
DEX is greater than or equal to the sum of the values rolled, your hit
will hit, otherwise it will miss. 

IQ
==

For wizards exclusively, this is their ability to learn spells. To learn
a certain spell, you must have an IQ great enough to use it.
You can put stat points on it, but it will not have any effect if you are not a mage.

EXPERIENCE
==========

You gain 1 exp for each point of damage dealt to the enemy. You require more
and more points to level each time, and you acquire one point each time you
level up.

COMBAT
======

To hit an opponent, you have to roll your dexterity or less on three six sided dice (Dexterity must be greater than or equal to the sum of the three rolls) so dexterity must always be greater than 3 (by default, it is).

In the case of distance weapons or spells you subtract 1 from your dexterity for the purposes of the roll per grid space travelled.

Damage is based on the weapon you use and the weapons you can use are based on strength, k (we need to discuss this before implementing as we need different weapons for every strength level as well as every class extension of character).

FLEE
====

In order to flee, the non player characters must have a health below certain amount, and the player characters can decide if they want to flee or not.
The enemy will gain exp upon your fleeing and vice versa.

ENCOUNTER
========
Although it returns the integer types for the various encounters, we have moved the printline of the fleeing to the flee() method for convenience.

LEVEL UP
========

After you reach a certain experience, you will level up and you may distribute the point to any of the stats.
NPCs will do that randomly.
Health will be replenished.
Exp requirement will grow each time by 5.

=========================================================================================================================================================================

Class specifics:


ARCHER CLASS
=============
Damage is exclusively based on Dexterity.
Has more health than normal characters.

OGRE CLASS
==========
Damage is strength + 3.
Has less health than normal characters.
