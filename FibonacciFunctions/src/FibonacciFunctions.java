import java.util.Scanner;

public class FibonacciFunctions {

	 public static void main(String[] args) {
		 Scanner userInput = new Scanner(System.in);
		 
		 //nth element input
		 System.out.print("Enter the max number in your Fibonacci sequence: ");
		 int minValue = 0; // beginning min value
		 int maxValue = userInput.nextInt(); // max value in sequence provided by user
		 
		 long startRecursive = System.nanoTime(); // start recursive time
		 while(minValue < maxValue) {
			 
			 int returnedFibs = fibonacciRecursion(minValue); // calling recursive function with user input max and returning value

				 if(returnedFibs < maxValue) { // if sequence numbers are less than max proceed
				 	System.out.println(returnedFibs); 
				 	minValue++; 
				 }else { // if sequence numbers more than max break out
					 break;
				 }
			  
			 userInput.close(); // close the scanner 
		}
		long endRecursive = System.nanoTime(); // end recursive time
		System.out.println("Time taken in recursive approach : "+(endRecursive-startRecursive)+"ns"); //display recursive time
		 
		 long startIterative= System.nanoTime(); // start iterative time
		 fibonacciIterative(maxValue);
		 long endIterative = System.nanoTime(); // end iterative time
		 System.out.println("Time taken in iterative approach : "+(endIterative-startIterative)+"ns"); //display iterative time
		
	}
	 
	 
	 public static int fibonacciRecursion(int nthNumber) { // use recursion  
		 if (nthNumber == 0) return 0;   // ensuring to begin with 0 and 1
		 if (nthNumber == 1)  return 1; 
		 
		 return fibonacciRecursion(nthNumber - 1) + fibonacciRecursion(nthNumber - 2); 
	 }
	     
	  
	 public static int fibonacciIterative(int maxValue) { //use iteration
		 int a = 0, b = 1, sum = 0;
		 
		 for(int i=0; i < maxValue; i++) {
			 sum = a + b;
			 a = b;
			 b = sum;
			 
			 if(sum < maxValue) // print out sequence if under max
				 System.out.println(sum); 
			 else
				 break;
		 }
   		 return b;
	 }
}

