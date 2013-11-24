public class Arrays{
    private int[] data;
    public void insert(int val,int pos){
	int[] a = new int[data.length+1];
	for(int i = 0;i<pos;i++){
	    a[i] = data[i];
	}
	a[pos] = val;
	for(int i = pos+1;i<a.length;i++){
	    a[i] data[i-1];
	}
	data = a;
    }
}