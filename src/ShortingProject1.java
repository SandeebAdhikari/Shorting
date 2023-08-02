/*SANDEEB ADHIKARI
 * 03/13/2022
 */
import java.util.Random;
import java.util.Scanner;


public class ShortingProject1{

public static void main(String[] args) {
	
	// Part 1
	Random rand = new Random();
	//number to be generated
	int noToGenerate = 10;	
	
	//array to store random number 
	int randomlyGeneratedNumber[] = new int[noToGenerate];
	
	//random number generator
	for (int i = 0; i< noToGenerate ; i++) {
		randomlyGeneratedNumber[i]= rand.nextInt(100);
	}
	
	//Displays the sorted arrays
	System.out.println("Original Array:");
	displayResult(randomlyGeneratedNumber);
	System.out.println("Sorting using selection sort:");
	int selectionSorted[]= selection_sort(randomlyGeneratedNumber, noToGenerate);
	displayResult(selectionSorted);
	System.out.println("Sorting using insertion sort:");
	int insertionSorted[]= insertion_sort(randomlyGeneratedNumber, noToGenerate);
	displayResult(insertionSorted);
	
	//Part-2 
	Scanner can = new Scanner(System.in);
	//maximum value of the number 
	System.out.println("Maximum Value of number: ");
	int maxNumber = can.nextInt();
	//Initializing array
	int[] array = new int[maxNumber +1];
	System.out.println("Total number to sort: ");
	int totalNumber = can.nextInt();
	//getting the original array
	System.out.println("Enter the number: ");
	for( int i = 0; i<totalNumber; i++) {
		int originalArray= can.nextInt();
		array[originalArray]+=1;
	}
	
	//display the number in sorted order
	System.out.println("Sorted Array");
	for (int i =0 ; i< array.length; i++) {
		for(int j=0; j<array[i]; j++) {
			System.out.print(" "+i);
		}
	}
	
	
}

//SELECTION SORT 
//method to sort the number using selection sort.
public static int[] selection_sort(int a[], int n) {
	int min,pos =-1;
	//iterating n-1 times
    for(int i=0; i<n-1; i++) {
    	
    	//a[i] is initially the smallest number in each iteration
    	min =a[i];
    	
    	//updating a[i] after comparing all number with a[i] 
    	for (int j=i+1; j<n; j++) {
    		if(min>a[j]) {
    			min = a[j];
    		//pos will store the index of min
    			pos = j;
    		}
    	}
    	
    	//if min is updated then swap it with a[i]
    	if(a[i]!=min) {
    		int temp = a[pos];
    		a[pos]=a[i];
    		a[i]=temp;
    	}
    }
    
    //returning the sorted array
    return a;
}

//INSERTION SORT
//method to sort the number using insertion sort.
public static int[] insertion_sort(int a[],int n) {
	int key;
	//iterating n-1 times
	for (int i=1; i<n; i++) {
		key = a[i];
		//setting j to i-1 to compare key with previous value
		int j = i-1;
		
		//loop iterates through j=i-1 to 0
		//
		while( j>=0 && key<a[j] ) {
			a[j+1]=a[j];
			j--;
		}
		a[j+1] = key;
	}
	//returning the sorted array
	return a;
}


//DISPLAY RESULTS
public static void displayResult(int a[]) {
	for (int i =0; i<10; i++) {
		System.out.print(a[i] +" ");
	}
	System.out.println();
	}
}

/****OUTPUT****
 * Original Array:
44 51 22 93 74 57 88 0 70 77 
Sorting using selection sort:
0 22 44 51 57 70 74 77 88 93 
Sorting using insertion sort:
0 22 44 51 57 70 74 77 88 93 
Maximum Value of number: 
5
Total number to sort: 
8
Enter the number: 
5 3 4 2 1 0 2 4
Sorted Array
 0 1 2 2 3 4 4 5
 */
