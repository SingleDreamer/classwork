import java.io.*;
import java.util.*;

public class test{
    public String desc;
    public ArrayList items;
    public Scanner sc;
    public test(String d){
	desc = d;
	items = new ArrayList();
	sc = new Scanner(System.in);
	
    }
    public test(){
	this("You are in an finished room");
    }

    public void roomDesc(String desc){
	System.out.println(desc);
    }
}
