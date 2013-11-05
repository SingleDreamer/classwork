import java.io.*;
import java.util.*;

public class NPC extends Character{
    Random r = new Random();
    int x, y;

    public NPC (String name, double Pstr, double Pdex, double Pintl, double Pdef, int lvl){
	this.name = name;
	str = 8;
	dex = 8;
	intl = 8;
	def = 8;
	this.lvl = lvl;
	for (int i = 0; i < (7+lvl); i++){
	    if (r.nextDouble()<Pstr){
		str = str + 1;
	    }
	    else if (r.nextDouble()<Pdex){
		dex = dex + 1;
	    }
	    else if (r.nextDouble()<Pintl){
		intl = intl + 1;
	    }
	    else {
		def = def + 1;
	    }
	}
    }
    public NPC (String name, double Pstr, double Pdex, double Pintl, double Pdef){
	this.name = name;
	str = 8;
	dex = 8;
	intl = 8;
	def = 8;
	this.lvl = 1;
	for (int i = 0; i < 8; i++){
	    if (r.nextDouble()<Pstr){
		str = str + 1;
	    }
	    else if (r.nextDouble()<Pdex){
		dex = dex + 1;
	    }
	    else if (r.nextDouble()<Pintl){
		intl = intl + 1;
	    }
	    else {
		def = def + 1;
	    }
	}
    }
    public NPC (String Name){
	this.name = name;
	str = 10;
	dex = 10;
	intl = 10;
	def = 10;
    }
    
    public void attack (Character other, String type){
	int x = 0;
	if (type.equals("magic")){
	    x = intl - other.def;
	}
	else if (type.equals("melee")){
	    x = str - other.def;
	}
	
	if (x < 0){
	    x = 0;
	}
	other.hp = other.hp - x;
    }
}
