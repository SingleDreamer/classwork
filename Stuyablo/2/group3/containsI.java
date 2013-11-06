import java.io.*;
import java.util.*;

public class containsI {
    public boolean containsInt ( int[] a , int i ) {
	for ( int j = 0 ; j < a.length ; j++ ) {
	    if ( a [ j ] == i )
		return true;
	}
	return false;
    }

    public int findInt ( int[] a , int i ) {
	for ( int j = 0 ; j < a.length ; j++ ) {
	    if ( a [ j ] == i )
		return j;
	}
	return -1;
    }
}
