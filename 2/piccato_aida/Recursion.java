public class Recursion {

    public int fib(int n) {
	if (n<2) {
	    return 1;
	}
	else {
	    return fib(n-1) + fib(n-2);
	}
    }

    public int fibWithLoop(int n) {
	int currentNum = 1; 
	int prevNum = 1;
	for (int i = 0; i < n - 1; i++) {
	    int temp = currentNum;
	    currentNum += prevNum;
	    prevNum = temp;
	}
	return currentNum;
    }

    public int fibSpeedy(int n) {
        


    }
		
}

