import java.io.*;
import java.util.*;

public class Turtle {

    private String name;
    private int age;
    private int speed;

    public Turtle() {
	getName("Shelly");
	getAge(14);
	getSpeed(120);
    }

    public Turtle(String newName) {
	getName(newName);
	getAge(75);
	getSpeed(35);
    }

    public Turtle(String newName, int newAge, int newSpeed) {
	getName(newName);
	getAge(newAge);
	getSpeed(newSpeed);
    }

    public void speedUp(int n) {
	speed = speed + n;
    }

    public void slowDown(int n) {
	speed = speed - n;
    }

    public void getOlder() {
	age = age + 1;
    }

    public void getName(String setName) {
	name = setName;
    }

    public String returnName() {
	return name;
    }

    public void getAge(int setAge) {
	age = setAge;
    }

    public int returnAge() {
	return age;
    }

    public void getSpeed(int setSpeed) {
	speed = setSpeed;
    }

    public int returnSpeed() {
	return speed;
    }

}
