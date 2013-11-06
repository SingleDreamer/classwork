import java.io.*;
import java.util.*;

public class ArraysTuff {

	public int[] Revfill(int n){
		int[] ans = new int[n];
		for (int i=n;i>0;i--){
			ans[n-i]=i;
		}
		return ans;
	}

}
