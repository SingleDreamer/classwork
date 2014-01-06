public class driver{
    public static void main(String[] args){
	/*
	testrm1 t = new testrm1();
	t.roomDesc();
	*/
	commands c = new commands("use hat on pants");
	System.out.println(c.numWords + "\n" + c.words);
    }
}
