Program for Fibonacci functions
Last Updated: October 9, 2020


Definition of Fibonacci numbers
The Fibonacci numbers are the numbers in the following integer sequence.
0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89…

Approach
We can obtain both integer sequences by using two approaches:
•	Recursive
•	Iterative

Layout & Flow of Program
We have implemented a class named FibonacciFunctions that will house both our recursive and iterative functions. We will begin by asking the user for a max input on his/hers Fibonacci sequence. We will use 100 for our example. Upon receiving input, the program will fire off two functions. First the fibonacciRecursive() function followed by the fibonacciIterative() function. Before each function is called we will keep track of time and performance by implementing the System.nanoTime() method, thus ensuring we recording starting time of both functions. Upon completion of both functions, we will then call another System.nanoTime() function to ensure that end times are also retrieved. Both functions will display the same data, a sequence from 0 to whatever max number the user chooses followed by the amount of time in nano seconds it took each function to run.

Recursive
Our recursive approach utilizes a repeating pattern via our fibonacciRecursive() function and the looping is implemented in the main function. Upon every iteration of the loop, a comparison is made to ensure that the minValue (beginning number i.e.0) is less than the number chosen by the user (MaxValue i.e. 100):
long startRecursive = System.nanoTime(); // start recursive time
while(minValue < maxValue) {
			 
int returnedFibs = fibonacciRecursive(minValue); // calling recursive function with user input max and returning value
 
if(returnedFibs < maxValue) { // if sequence numbers are less than max proceed
	System.out.println(returnedFibs); 
	minValue++; 
	}else { // if sequence numbers more than max break out
		break;
	}
	userInput.close(); // close the scanner 
}
long endRecursive = System.nanoTime(); // end recursive time

A call to fibonacciRecursive() is made  upon every iteration with minValue as the argument. We then transfer any returned valued into our returnedFibs int variable. Notice that as long as returnedFibs is less than maxValue, it proceeds to be printed out. If however, we reach our max (i.e. 100) the program breaks out of the sequence. The Scanner object is then closed.

The function itself begins at 0 and sequentially one. It checks to ensure that these are our two first values. It then builds on these two values by calling fibonacciRecursive() yet again. This time adding the next number in the sequence with the previous one.

public static int fibonacciRecursive(int nthNumber) { // use recursion  
if (nthNumber == 0) return 0; // ensuring to begin with 0 and 
if (nthNumber == 1)  return 1; 
		 
return fibonacciRecursive(nthNumber - 1) + fibonacciRecursive(nthNumber - 2); 
}

Iterative

Our iterative approach is much simpler. We leave most of the logic in the function itself and simply call it.
long startIterative= System.nanoTime(); // start iterative time
fibonacciIterative(maxValue);
long endIterative = System.nanoTime(); // end iterative time

Notice that we have called System.nanoTime() before and after the function call, similar to the recursive approach. This is to record our time before and after the function logic.

As mentioned, most of the logic is implemented in fibonacciRecursive. We start off by declaring and defining three int variables a = 0, b = 1, and sum = 0. We then begin a for loop that similar to the recursive approach, begins at 0 and only ends if less than the user specified max. Through every iteration we add the first two numbers 0 and 1 then shift number positions by assigning succeeding values to the previous variables. Within the loop we see a condition that checks the new sum and compares it again with the max value, only breaking out once we’ve reached our max. The sum is then returned.

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





NanoTime Calculation

We reach our conclusive time performance results by simple subtracting the end recording nanoTime() with the initial preceeding one for both function. We then print both results. Please reference below:

Recursive
long startIterative= System.nanoTime(); // start iterative time
long endIterative = System.nanoTime(); // end iterative time

System.out.println("Time taken in recursive approach : "+(endRecursive-startRecursive)+"ns"); //display recursive time

endIterative-startIterative

Iterative
long startRecursive = System.nanoTime(); // start iterative time
long endRecursive = System.nanoTime(); // end iterative time

endRecursive-startRecursive

System.out.println("Time taken in iterative approach : "+(endIterative-startIterative)+"ns"); //display iterative time


Results/Output

As we can see, the iterative approach is much faster.


