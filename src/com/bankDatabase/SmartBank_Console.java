package com.bankDatabase;

import java.util.ArrayList;
import java.util.Scanner;

//  SmartBank Java Console Application
public class SmartBank_Console {
    public static void main( String[] args){

        // Declaring Variables
        int Option;

        // Using ArrayList As The Storage for now
        ArrayList<User> dataBank = new ArrayList<>();

        // Used To Accept User Input
        Scanner input = new Scanner(System.in);

        // The Bank's User Interface Format
        System.out.println();
        System.out.println(" ******************************************** ");
        System.out.println(" *****   SmartBank Console Application  ***** ");
        System.out.println(" ******************************************** ");
        System.out.println();

        // Making The User Choose A Valid Menu
        System.out.println("1. User Account System ");
        System.out.println("2. Banking Features ");
        System.out.println("3. Admin Panel [ Separate Login ] ");
        System.out.println("4. Transaction History System  ");
        System.out.println("5. Exist ");
        System.out.println();
        System.out.println("Select An Option ");
        Option = input.nextInt();
        input.nextLine();

        // Using Switch Cases To Determine The User Input
        switch (Option){
            case 1:{
                userAccountSystem(dataBank);
                break;
            }

            case 2:{
                System.out.println("Banking Features ");
                break;
            }

            case 3:{
                System.out.println("Admin Panel [ Separate Login ] ");
                break;
            }

            case 4:{
                System.out.println("Transaction History System ");
                break;
            }

            case 5:{
                System.out.println(" Thank You For Visiting SmartBank Console ");
                break;
            }

            default:{
                System.out.println("Please Enter A Valid Input ");
                break;
            }

        }
    }

    // User Account System Method
   public static void  userAccountSystem( ArrayList<User> dataBank ) {

       // Accepting Variable
       int option;

       // Accepting Input
       Scanner accept = new Scanner(System.in);

       // User Account UI
       System.out.println("--------------------------------------------------------");
       System.out.println("                * USER ACCOUNT SYSTEM *                 ");
       System.out.println("________________________________________________________");
       System.out.println();
       System.out.println("1. Create A New Account ");
       System.out.println("2. Already Have An Account [ Login ] ");
       option = accept.nextInt();
       accept.nextLine();

       // Making Sure The User Types The Correct Things


               // Using Switch Case to check the option
               switch (option) {
                   case 1: {

                       // Variables For The New Account Creation
                       String firstName, lastName, dateOfBirth, email, occupation, address, phoneNumber, idNUmber;

                       // New Account UI
                       System.out.println();
                       System.out.println("----------------------------------------------");
                       System.out.println("              New Account Creation            ");
                       System.out.println("______________________________________________");
                       System.out.println();

                       // Accepting First Name
                       System.out.println(" Enter First Name ");
                       firstName = accept.nextLine();
                       System.out.println();

                       // Accepting Last Name
                       System.out.println(" Enter Last Name ");
                       lastName = accept.nextLine();
                       System.out.println();

                       // Accepting Date Of Birth
                       System.out.println(" Enter Date Of Birth ");
                       dateOfBirth = accept.nextLine();
                       System.out.println();

                       // Accepting Email
                       System.out.println(" Enter Your Email ");
                       email = accept.nextLine();
                       System.out.println();

                       // Accepting Occupation
                       System.out.println(" Enter Your Occupation ");
                       occupation = accept.nextLine();
                       System.out.println();

                       // Accepting Address
                       System.out.println(" Enter Address ");
                       address = accept.nextLine();
                       System.out.println();

                       // Accepting Phone Number
                       System.out.println(" Enter Phone Number ");
                       phoneNumber = accept.nextLine();
                       System.out.println();

                       // Accepting ID Number
                       System.out.println(" Enter Id Number ");
                       idNUmber = accept.nextLine();
                       System.out.println();

                       System.out.println("-----------------------------------------------------");
                       System.out.println("           ** Account Creation Completed **          ");
                       System.out.println("_____________________________________________________");

                       dataBank.add(new User(firstName, lastName, dateOfBirth, email, occupation, address, phoneNumber, idNUmber));
                   }

                   case 2: {
                       // Used Variables
                       String userName, password;

                       // Login UI
                       System.out.println();
                       System.out.println("----------------------------------------------------");
                       System.out.println("          ** Login To SmartBank Console **          ");
                       System.out.println("____________________________________________________");
                       System.out.println();

                       // Accepting Username
                       System.out.println("Enter Your UserName: ");
                       userName = accept.nextLine();
                       System.out.println();

                       // Accepting Password
                       System.out.println("Enter Your Password ");
                       password = accept.nextLine();
                       System.out.println();

                       System.out.println("--------------------------------------------------");
                       System.out.println(" Welcome Back Mr " + userName);
                       System.out.println(" And Your Password Is " + password);
                       System.out.println("__________________________________________________");
                       System.out.println();
                       break;
                   }

                   default: {
                       System.out.println();
                       System.out.println("Please Enter A Valid Input ");
                       break;
                   }
               }





   }


}
