Steven Zabolotny, Michael Lim, George Drimba, Shane

CHARACTERS
==========

Have attributes stored as instance variables for the character. Initialized 
with certain values based on class picked in the beginning of the game. You 
start with each attribute at 8, and it will distribute 8 more points.

STR (Strength)
--------------

Decides if you can use certain weapons. Weapons will not be stored by
name, but rather by value of their damage. To use a weapon of certain damage,
you must have strength of at least half that damage, with a deviation of
10 from those values. [Just an idea, not final]. This is a phenomenal way to correlate damage with weapons however I think their should be a distinction of the damage dealt upon each increment of strength (not just every deviation of 10).

DEX {Dexterity)
---------------

Decides whether you hit or miss. Three six-sided die are rolled, if your
DEX is greater than or equal to the sum of the values rolled, your hit
will hit, otherwise it will miss. 

IQ
--

For wizards exclusively, this is their ability to learn spells. To learn
a certain spell, you must have an IQ great enough to use it.

ARMOR
-----

Not a base stat, no base points can be granted for it, nor is it affected
by leveling up, but it can be changed by items and loot. It will reduce
damage taken by its amount.

EXPERIENCE
----------

You gain 1 exp for each point of damage dealt to the enemy. You require more
and more points to level each time, and you acquire one point each time you
level up.

COMBAT
======

To hit an opponent, you have to roll your dexterity or less on three six sided dice (Dexterity must be greater than or equal to the sum of the three rolls) so dexterity must always be greater than 3.

In the case of distance weapons or spells you subtract 1 from your dexterity for the purposes of the roll per grid space travelled.

Damage is based on the weapon you use and the weapons you can use are based on strength, k (we need to discuss this before implementing as we need different weapons for every strength level as well as every class extension of character).
