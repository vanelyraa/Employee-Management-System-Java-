/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.caalgorithms;

/**
 *
 * @author vanel
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;


/**
 *
 * @author vanel
 * @param <T>
 */
public class AlgorithmAnalysis<T extends Comparable<T>>  {
    
    /**
     * Part 1: Sorting and Searching: Algorithm Analysis
     * Question 1
     * 
     * 
     * 
     * @param myArray
     */

    //quick sort algorithm in Java Generics - divided in 4 methods:
    public void sorting(T[] myArray) {
	quicksort(myArray, 0, myArray.length-1); //call method quicksort
    }

    // Quicksort using Java Generics
    private void quicksort (T[] myArray, int i, int j) {
	if (i<j) {
	    int l = partition(myArray,i,j);
	    quicksort(myArray, i, l);
	    quicksort(myArray, l+1, j);
	}
    }

    //Partition method using Generics
    //the last element is the pivot,all smaller elements are placed to left and bigger to the right
    private <T extends Comparable<? super T>> int partition(T[] myArray, int a, int b) {
	T elem = myArray[a];
	int m = (a+b)/2;//find middle of array
        //checking if the element is smaller 
	if ((myArray[a].compareTo(myArray[m])<=0 && myArray[m].compareTo(myArray[b])<=0) || (myArray[b].compareTo(myArray[m])<=0 && myArray[m].compareTo(myArray[a])<=0))
	    elem = myArray[m];
	if ((myArray[a].compareTo(myArray[b])<=0 && myArray[b].compareTo(myArray[m])<=0) || (myArray[m].compareTo(myArray[b])<=0 && myArray[b].compareTo(myArray[a])<=0))
	    elem = myArray[b];
	int i = a-1;
	int j = b+1;
	while (true) {
	    do i++; while (!(i>b || myArray[i].compareTo(elem)>=0));
	    do j--; while (!(j<a || myArray[j].compareTo(elem)<=0));
	    if (i<j) swap(myArray, i, j);
	    else return j;
	}
    }
    
    //swap method using Generics
    //compares elements and swap 
    private <T extends Comparable<? super T>> void swap (T[] myArray, int a, int b) {
	T tempA;
	tempA = myArray[a];
	myArray[a] = myArray[b];
	myArray[b] = tempA;
    }

    /**
     * Part 1: Sorting and Searching: Algorithm Analysis
     * Question 3
     * 
     * 
     * @param <T>
     * @param employees
     * @param target
     */
   
   //Iterative implementation of binary search using array and the name target as parameter 
    public static <T extends Comparable<? super T>> void binarySearch(Employee [] employees, String target) {
    
       if (employees == null){ //if array is empty, return null
            return;
       }
        
       //find first index where first occurence of the target is found
        int low = 0; //first index of array
        int high = employees.length - 1;////first index of array
        // get the start index of target number
        int stIndex = -1; //first index variable 
        while (low <= high) { //if low index is smaller than high, there are still elements to be checked
            int mid = (high - low) / 2 + low; //middle of array
            if (employees[mid].getFirstName().compareTo(target)> 0) { //compare target with name using getter method, if bigger than zero
                high = mid - 1; //set new upper portion, discarting elements
            } else if (employees[mid].getFirstName().equals(target)) { //if name is equals target
                stIndex = mid; 
                high = mid - 1; //set new higuer portion, discarting elements
            } else
                low = mid + 1;
        }

        // find last index where target was found
        int endIn = -1; //last index variable
        low = 0;
        high = employees.length-1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (employees[mid].getFirstName().compareTo(target)> 0) {
                high = mid - 1;
            } else if (employees[mid].getFirstName().equals(target)) {
                endIn = mid;
                low = mid + 1;
            } else
                low = mid + 1;
        }

        if (stIndex != -1 && endIn != -1){ //if none of the indexes are -1
            for(int i=0; i+stIndex<=endIn;i++){ //iterate through indexes where element was found 
                //if(i>0){
                System.out.print("Employee found at index: " +(i+stIndex)+ "\n"); //print all indexes found
            }
            
        }else{
            System.out.print("Not an employee! \n" );
        }
    }
   
    /**
     * Part 2: Defensive Programming and Exception Handling
     * Question 2 - part 1
     * @param dateOfBirth
     * @return 
     * @throws java.text.ParseException 
     */
    
    public static int checkAge (String dateOfBirth) throws ParseException {
  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //chosen date format according to CSV
        Date doB = sdf.parse(dateOfBirth); //parsing String dateOfBirth to date
        Calendar c = Calendar.getInstance(); //get calendar with current time zone
        c.setTime(doB);
        int year = c.get(Calendar.YEAR);//getting year from calendar
        int month = c.get(Calendar.MONTH) + 1;//getting month +1 to start in index 1 -> january
        int date = c.get(Calendar.DATE);//getting day from calendar
        LocalDate local = LocalDate.of(year, month, date);
        LocalDate curr = LocalDate.now();
        Period diff = Period.between(local, curr);//comparison between current date and dateOfBirth
        int age = diff.getYears(); //difference between dates = age
  
        return age;
    }
}
