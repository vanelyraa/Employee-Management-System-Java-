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
import java.util.Scanner;
import java.io.File;
import java.text.ParseException;
import java.util.Arrays;

/**
 *
 * @author vanel
 */
public class ReadEmployeeData  {
    
    public static Employee[] employees;

    
    public static void main(String[] args) throws Exception{
        //parsing and reading the CSV file data into the employee (object) array
        // provide the path here...
        
        Scanner sc = new Scanner(new File("C:\\Users\\vanel\\OneDrive\\Documentos\\College\\2 Semester\\Algorithms and Advanced Programming\\CA\\X19234554_ HDSDEV_SEP1 _Vanessa_Lyra_AAP\\employees_data.csv"));
        employees = new Employee[10000];
        
        // this will just print the header in CSV file
        System.out.println(sc.nextLine());

        int i = 0; String st = "";
        while (sc.hasNextLine())  //returns a boolean value
        {
                st = sc.nextLine();
                String[] data = st.split(",");
                employees[i] = new Employee(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4].charAt(0), data[5]);
                i++;
        }
        sc.close();  //closes the scanner
        
        AlgorithmAnalysis myAlgo = new AlgorithmAnalysis(); //object creation to access methods of another class
        
        //Part 1 - Question 1        
        long startTime = System.nanoTime();// 
        myAlgo.sorting(employees);
        long endTime = System.nanoTime();
        long elapsedTime = (endTime - startTime);
        System.out.println("Current Time in nano for QuickSort 1: " + elapsedTime );
        
        //for loop to iterate over to array and print all objects, check sort method 
        /*for (int k = 0; k < employees.length; k++){
           System.out.println(employees[k].toString());
        }*/
        
        //Part 1 - Question 3 
        startTime = System.currentTimeMillis();
        AlgorithmAnalysis.binarySearch(employees, "Zsolt");
        endTime = System.currentTimeMillis();
        elapsedTime = (endTime - startTime);
        System.out.println("Current Time in milli for binarySearch: " + elapsedTime );
        
        startTime = System.currentTimeMillis();
        AlgorithmAnalysis.binarySearch(employees, "Krisvcn"); //Binary search in non-existent element*/
        endTime = System.currentTimeMillis();
        elapsedTime = (endTime - startTime);
        System.out.println("Current Time in milli for binarySearch not existing employee: " + elapsedTime );
        
       
        //Part 2 - Question 1
        addEmployees("1991-06-04", "Vanessa", "Lyra", 'F', "2008-09-21"); //Valid input  
        addEmployees("1975-11-18", "Jessica", "Marty", 'F', "2015-01-28"); //Valid input  
        
        //Part 2 - Question 2
        addEmployees("1946-03-05", "Kristian", "Stutgas", 'M', "2010-08-02"); //Age input validation: above retirement age
        addEmployees("2002-02-15", "Maxwell", "Crates", 'M', "2020-03-14"); //Age input validation: below the employment age
        
        //Part 2 - Question 3
        //addEmployees("1998-01-02", "Zanis55a", "Star", 'F', "2012-11-21"); //Name input validation: no numbers accepted
        for (int m = 0; m < employees.length; m++){
           System.out.println(employees[m].toString());
        }
    }
    

    /**
     * Part 2: Defensive Programming and Exception Handling
     * Question 1
     * @param dateOfBirth
     * @param firstName
     * @param lastName
     * @param gender
     * @param hireDate
     * @throws java.text.ParseException
     * @throws com.mycompany.caalgorithms.CustomExceptions
     */
        
    //method to add new employee
    
    public static void addEmployees(String dateOfBirth, String firstName, String lastName, char gender, String hireDate) throws ParseException, CustomExceptions {
    
        int atomicInt = Employee.counter.incrementAndGet(); //calling the counting variable for empNo
        int last = employees.length;//finding index of array`s last element
       
        //resize array (length+1) using Arrays.copyOf, to add new object
        Employee[] temp = Arrays.copyOf(employees, employees.length+1);
        employees = Arrays.copyOf(temp, temp.length);
        
        employees[last] = new Employee(atomicInt,dateOfBirth,firstName,lastName,gender,hireDate);//new employee creation at the end of the array (index = last)
        employees[last].getEmpNo(); //get empNo according to atomic counter
        employees[last].setDateOfBirth(dateOfBirth);
        employees[last].setFirstName(firstName);
        employees[last].setLastName(lastName);  
        employees[last].setGender(gender); 
        employees[last].setHireDate(hireDate);
    
        System.out.println("New employee added succesfully: " + employees[last].toString());
    } 
}
