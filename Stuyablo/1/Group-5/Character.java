import java.io.*;
import java.util.*;

public class Character {
    protected int hp, maxhp, xp, str, dex, intl, def;
    protected String name;
    private Random r = new Random();

    protected void init(String name, int hp) {
	this.name = name;
	this.hp = hp;
	str = 8;
	dex = 8;
	intl = 8;
	def = 8;
    }

    public Character () {
	init("No Name",50);
    }
    
    public Character (String name) {
	init(name, 50);
    }

    public Character (String name, int hp) {
	init(name, hp);
    }

    public String attack () {
	return "Generic attack";
    }

    public String toString () {
	return name;
    }

}
