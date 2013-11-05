import java.util.*;
import java.io.*;

public class Warrior extends Character {

    public Warrior(){
	dexterity = 8;
	health = strength = 8;
	experience = intelligence = 8;
	maxhealth = 16;
	gold = 8;
	name = "Warrior";
	charClass = "PC";
    }

    public void attack(Charater other){
	
