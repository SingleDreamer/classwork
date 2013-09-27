import java.io.*;
import java.util.*;


public class Turtle {
    private String name;
    private int speed, age;

    /*Constructors:*/
    public Turtle (){
    }
    public Turtle (String name) {
	age=2;
	speed=15;
    }
    public Turtle (String name,int speed, int age) {
    } 

    /*Set Methods:*/
    public void setSpeedUp(int n){
	speed = speed + n;
    }
    public void setSlowDown(int n){
	speed = speed - n;
    }
    public void setOlder(){
	age = age + 1;
    }


    /*Get Methods:*/
    public int getSpeed(int speed) {
	return speed;
    }
    public int getAge(int age){
	return age;
    }
    public String getName(String name) {
	return name;
    }

}
