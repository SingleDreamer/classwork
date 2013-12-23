import java.io.*;
import java.util.*;

public class TrainLine {

    private String name;
    private ArrayList<Station> stops = new ArrayList<Station>();
    //I used an ArrayList here for the purpose of making setup easier, but we could use an array

    public TrainLine(String name) {
	this. name = name;
    }

    public void setStops(Station s) {stops.add(s);}

}
