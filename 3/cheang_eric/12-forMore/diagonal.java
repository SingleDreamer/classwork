public class diagonal{
    
    string returnString = "";
    int spaceMan;
    
    public string diag(int number){
	
	for (int numCount = 0;
	     numCount != number;
	     numcount = numcount + 1)
	    
	    {for (spaceMan = 0;
		  spaceMan != numCount;
		  spaceMan = spaceMan + 1){
		    
		    returnString = returnString + " ";
		    
		}
	
	returnString = returnString + "* /n";
    
	    }}}


		    
		 