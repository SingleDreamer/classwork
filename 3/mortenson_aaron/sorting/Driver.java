import java.util.*;

public class Driver {
    public static void main(String[] args) {
	System.out.println("Type\tobjects-digits:\t Time");
	for (int objs=10000;objs<=10000000;objs*=10) {
	    for (int decs=1;decs<32;decs+=2) {
		if (objs<1000000||decs<10) {
		    Radix r1 = new Radix(objs,decs);
		    Radix r2 = new Radix(objs,decs);
		    int t1 = 0;
		    int t2 = 0;
		    int start = (int) (System.currentTimeMillis());
		    r1.sort();
		    int end = (int) (System.currentTimeMillis());
		    t1=end-start;
		    System.out.print((String)"Radix\t "+objs+"-"+decs+": \t"+t1+"\t");
		    start = (int) (System.currentTimeMillis());
		    Arrays.sort(r2.getA());
		    end = (int) (System.currentTimeMillis());
		    t2=end-start;
		    System.out.println((String)"Sort\t "+objs+"-"+decs+": \t"+t2);
		}
	    }
	}
    }
}
