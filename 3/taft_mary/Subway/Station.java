import java.io.*;
import java.util.*;

public class Station {

    private String name;
    private int street, avenue;
    private ArrayList<TrainLine> trains = new ArrayList<TrainLine>();

    public Station(String name, int street, int avenue) {
	this.name = name;
	this.street = street;
	this.avenue = avenue;
    }

    public void setTrains(TrainLine tl) {trains.add(tl);}
    public int getStreet() {return street;}
    public int getAvenue() {return avenue;}

}
