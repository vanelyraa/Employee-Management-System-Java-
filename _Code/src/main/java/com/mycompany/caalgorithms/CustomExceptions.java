/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.caalgorithms;


/**
 * Part 2: Defensive Programming and Exception Handling
 * Question 3 - part 1
 */

//Custom exception class created to validate name input
public class CustomExceptions extends Exception{
  
    public CustomExceptions(String message){
    super(message);
    }
}

