// Name        : Tyler S.  Zoucha
// Class       : 1620-002
// Program #   : Program 4
// Due Date    : 11/9/2015
//
// Honor Pledge: On my honor as a student of the University
//               of Nebraska at Omaha, I have neither given nor received
//               unauthorized help on this homework assignment.
//
// NAME: Tyler S. Zoucha
// NU ID: 405
// EMAIL: tzoucha@unomaha.edu

// Partners: NONE

// Filename: EmptyListException.java
// Defines the Exception - EmptyListException that can be thrown
// when an operation is requested that is not supported for an empty list
//
// This class will be stored in the ExceptionPkg package.

package ExceptionPkg;
public class EmptyListException extends RuntimeException
{
     // constructor with no parameter
       public EmptyListException ()
       {
               this ("List");
       }
       // constructor with .String. parameter
       public EmptyListException (String name) {
               // call super class constructor
               super (name + " is empty");
       }
}
