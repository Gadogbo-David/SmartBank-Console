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

        // Transaction History Storage
        ArrayList<transHistory> storage = new ArrayList<>();

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
                bankingFeatures(storage);
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
                System.out.println("Thank You For Visiting SmartBank Console ");
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

   // Banking Features Method
    public static void bankingFeatures( ArrayList<transHistory> storage){

        // Variable Selection
        int Option;
        double balance = 0;

        // Used For Accepting User Input
        Scanner accept = new Scanner(System.in);

        // Using do while loop until the user Exits
       do{

           // The Banking Features UI
           System.out.println("--------------------------------------------------");
           System.out.println(" ***            BANKING FEATURES              *** ");
           System.out.println("__________________________________________________");
           System.out.println();

           // Making The User Choose A Valid Input
           System.out.println("1. Deposit ");
           System.out.println("2. Withdraw ");
           System.out.println("3. Check Balance ");
           System.out.println("4. View Transaction History ");
           System.out.println("5. Transfer Between Accounts ");
           System.out.println("6. Exit ");
           System.out.println();
           System.out.println(" Please Select An Option ");
           Option = accept.nextInt();
           accept.nextLine();

           // Using Switch Case To Determine Each User Input
           switch (Option){
               case 1:{
                   balance = deposit(balance,storage);
                   System.out.println();
                   break;
               }

               case 2:{
                  balance = withdraw(balance,storage);
                   System.out.println();
                  break;
               }

               case 3:{
                   balance = checkBalance(balance);
                   System.out.println();
                   break;
               }

               case 4:{
                   transactionHistory(storage);
                   System.out.println();
                   break;
               }

               case 5:{
                   System.out.println("PENDING STATUS: 404 ");
                   System.out.println();
                   break;
               }

               default:{
                   System.out.println(" PLEASE ENTER A VALID INPUT ");
               }

           }

       }while(Option != 6 );
    }

    // The Deposit Method For The Banking Features
    public static double deposit( double balance,ArrayList<transHistory> storage ){

        // Deposit Variable
        double deposit;
        double add;
        String type,dateNtime,acctNum,acctName;

        // Accepting User Input
        Scanner accept = new Scanner(System.in);

        // Deposit UI
        System.out.println("------------------------------------------------");
        System.out.println("                  DEPOSIT MENU                  ");
        System.out.println("________________________________________________");
        System.out.println();

        // Accepting User Input
        System.out.println("Enter Account Name: ");
        acctName = accept.nextLine();
        System.out.println();

        System.out.println("Enter Account Number: ");
        acctNum = accept.nextLine();
        System.out.println();

        System.out.println("Enter Transaction Type: ");
        type = accept.nextLine();
        System.out.println();

        System.out.println("Enter Transaction Date(DD - MM - YY ) ");
        dateNtime = accept.nextLine();
        System.out.println();

        System.out.println("Enter Amount To Deposit ");
        deposit = accept.nextDouble();
        System.out.println();

        // Adding to balance
       add = deposit + balance;


       // Declaring Deposit Status
        System.out.println("GH$ " + deposit + " Has Been Deposited Successfully ");
        System.out.println("Balance = GH$ " + add);
        System.out.println();

        // Adding The Accepted Elements To The Transaction History Storage
        storage.add( new transHistory( type,dateNtime,acctNum,acctName,deposit ) );

        return add;



    }


    // The Withdrawal  Method For The Banking Features
    public static double withdraw( double balance,ArrayList<transHistory> storage ){

        // Withdraw Menu variable
        double withdraw;
        double total = 0;
        String acctName,acctNum,type,dateNtime;

        // Accepting User Input
        Scanner accept = new Scanner(System.in);

        // Withdraw Menu UI
        System.out.println("------------------------------------------------- ");
        System.out.println("                   WITHDRAW MENU                  ");
        System.out.println("__________________________________________________");
        System.out.println();

        // Accepting User Input

        System.out.println("Enter Account Name: ");
        acctName = accept.nextLine();
        System.out.println();

        System.out.println("Enter Account Number: ");
        acctNum = accept.nextLine();
        System.out.println();

        System.out.println("Enter Transaction Type: ");
        type = accept.nextLine();
        System.out.println();

        System.out.println("Enter Transaction Date(DD - MM - YY ) ");
        dateNtime = accept.nextLine();
        System.out.println();

        System.out.println(" Please Enter Amount To Withdraw ");
        withdraw = accept.nextDouble();
        System.out.println();

        // Using If Statements To Determine Correct Cases
        if ( withdraw > balance ){
            System.out.println(" Insufficient Funds !!! ");
            System.out.println(" Please Deposit To Be Able To Withdraw ");
            System.out.println();

        }
        else if ( withdraw < balance ) {

            total = balance - withdraw;
            System.out.println(" The Amount Of GH$ " + withdraw + " Has Been Completed....");
            System.out.println(" Withdraw done Successfully... ");
            System.out.println(" Balance is GH$ " + total);
            System.out.println();

            // Adding The Result To The Transaction History
            storage.add( new transHistory( type,dateNtime,acctNum,acctName,withdraw ) );

        }
        else {
            System.out.println(" Please Enter A Valid Amount ");
            System.out.println(" Entered Amount Is Invalid ");
            System.out.println();
        }

        return total;
    }


    // Method For Check Balance For Banking Features
    public static double checkBalance(double balance){
        System.out.println("---------------------------------------------");
        System.out.println("                    BALANCE                  ");
        System.out.println("_____________________________________________");
        System.out.println();
        System.out.println(" Your Balance Is GH$ "+ balance);
        System.out.println();

        return balance;
    }

    // Method For Viewing Transaction History
    public static void transactionHistory(ArrayList<transHistory> storage){
        System.out.println("------------------------------------------------------------");
        System.out.println("                    TRANSACTION HISTORY                     ");
        System.out.println("____________________________________________________________");
        System.out.println();

        // Looping through the elements to be able to display them nicely
        for ( transHistory dataBase: storage ){
            System.out.println("Account Name: " + dataBase.acctName);
            System.out.println("Account Number: " + dataBase.acctNumber);
            System.out.println("Transaction Type: " + dataBase.transactionType);
            System.out.println("Date Of Transaction: " + dataBase.dateNtime);
            System.out.println("Amount: " + dataBase.amount);
            System.out.println();
            System.out.println("_______________________________________________________");
            System.out.println();

        }
    }




}
