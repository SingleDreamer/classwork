import java.io.*;
import java.util.*;

public class Grid {

    private Station[][] stations;

    public Grid(int streets, int avenues) {
	stations = new Station[streets][avenues];
    }

    public void setStations(Station s) {stations[s.getStreet()][s.getAvenue()] = s;}

}
