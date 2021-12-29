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
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author vanel
 */
class Employee implements Comparable<Object>{

    private int empNo;
    private String dateOfBirth;
    private String firstName;
    private String lastName;
    private char gender;
    private String hireDate;
    
    public static final AtomicInteger counter = new AtomicInteger(20000);
    
    // constructor
    public Employee(int empNo, String dateOfBirth, String firstName, String lastName, char gender, String hireDate){
        this.empNo = empNo;
        this.dateOfBirth = dateOfBirth;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.hireDate = hireDate;
    }
    
    public Employee(String dateOfBirth, String firstName, String lastName, char gender, String hireDate) throws ParseException, CustomExceptions{
        this.empNo = counter.incrementAndGet(); 
        this.dateOfBirth = dateOfBirth;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.hireDate = hireDate;
    }
    
    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Part 2: Defensive Programming and Exception Handling
     * Question 2 - part 2
     */
    
    /* Setter method with date of birth validation, in case the user`s date input  
    is out of the permitted range, the program will throw an exception */
    public void setDateOfBirth(String dateOfBirth) throws ParseException {
        int ageCheck = AlgorithmAnalysis.checkAge(dateOfBirth); //method checkAge call 
        String maxAge = "1950-01-01";
  
        //try{
        if ((ageCheck > 18 )&&(maxAge.compareTo(dateOfBirth) < 0)){ //if age is under 18, throw exception with message
            this.dateOfBirth = dateOfBirth;
            //System.exit(0);
        }else{ //if date of birth is before 1950-01-01 , throw exception with message
            throw new ArithmeticException("Invalid date, above retirement age or underaged"); 
           
        }            System.exit(0);

        /*}catch(IllegalArgumentException e){
            System.out.println(e.toString());*/
             
    }
    
       
         
    
    

    public String getFirstName()  {
        return firstName;
    }   

    /**
     * Part 2: Defensive Programming and Exception Handling
     * Question 3 - part 2
     */
  
    //Setter method with custom exception for name validation
    public void setFirstName(String firstName) throws CustomExceptions {
        for (char c : firstName.toCharArray()){ //iterate through every string character of name, if any is a number, throw custon exception
            if (Character.isDigit(c)) {
                throw new CustomExceptions("Name input: " + firstName + " must not contain numbers");
        
            }else{ //in case name is correct, set name
                this.firstName = firstName;
            }
        }
    }
    
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    // so the employee objects can be compared when sorting/searching
    // NOTE: this will only allow comparisons based on the firstName
   @Override
    public int compareTo(Object obj) {
        Employee emp = (Employee)obj;
        return firstName.compareTo(emp.getFirstName());
    }
    
    // return a String containing the employee details
    @Override
    public String toString(){
        return empNo+" "+dateOfBirth+" "+firstName+" "+lastName+" "+gender +" "+ hireDate;
    }

    
}
