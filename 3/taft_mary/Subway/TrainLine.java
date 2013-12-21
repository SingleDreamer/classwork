import java.io.*;
import java.util.*;

public class TrainLine {

    private String name;
    private ArrayList<Station> stops = new ArrayList<Station>();

    public TrainLine(String name) {
	this. name = name;
    }

    public void setStops(Station s) {stops.add(s);}

}
