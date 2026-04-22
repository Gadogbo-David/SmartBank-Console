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


                // Making the program run until the user exist
                do{

                    // The Bank's User Interface Format
                    System.out.println();
                    System.out.println(" ******************************************** ");
                    System.out.println(" *****   SMART-BANK CONSOLE APPLICATION  ***** ");
                    System.out.println(" ******************************************** ");
                    System.out.println();

                    // Making The User Choose A Valid Menu
                    System.out.println("1. User Account System ");
                    System.out.println("2. Admin Panel [ Separate Login ] ");
                    System.out.println("3. Transaction History System  ");
                    System.out.println("4. Exit ");
                    System.out.println();
                    System.out.println("Select An Option ");

                    // Involving Try And Catch
                    try{

                        Option = input.nextInt();
                        input.nextLine();

                        // Using Switch Cases To Determine The User Input
                        switch (Option) {
                            case 1 -> userAccountSystem(dataBank, storage, input);
                            case 2 -> adminPanel(dataBank, input);
                            case 3 -> System.out.println("Transaction History Pending ");
                            case 4 -> System.out.println("Thank You For Visiting SmartBank Console ");
                            default -> System.out.println("Please Enter A Valid Input ");

                        }


                    } catch (Exception e){
                        System.out.println("STATUS 404: INVALID INPUT " + e);
                        System.out.println(" Enter Valid Number Between 1 - 4");
                        input.nextLine();
                        Option = 0;
                    }


                }while(Option != 4 );

    }

    // User Account System Method
   public static void  userAccountSystem( ArrayList<User> dataBank, ArrayList<transHistory> storage, Scanner accept) {

       // Accepting Variable
       int option;

         do{

             // User Account UI
             System.out.println("--------------------------------------------------------");
             System.out.println("                * USER ACCOUNT SYSTEM *                 ");
             System.out.println("________________________________________________________");
             System.out.println();
             System.out.println("1. Create A New Account ");
             System.out.println("2. Already Have An Account [ Login ] ");
             System.out.println("3. Exit ");
             System.out.println();

             try {

                 option = accept.nextInt();
                 accept.nextLine();

                 // Using Switch Case to check the option
                 switch (option) {
                     case 1 -> {

                         // Variables For The New Account Creation
                         String firstName, lastName, dateOfBirth, email, occupation, address, phoneNumber, idNUmber, Password, UserName;
                         double balance;

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

                         // Accepting UserName
                         System.out.println(" Create UserName: ");
                         UserName = accept.nextLine();
                         System.out.println();

                         // Accepting Date Of Birth
                         System.out.println(" Enter Date Of Birth [DD / MM / YY ] ");
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
                         System.out.println(" Enter Address [ REGION - CITY ] ");
                         address = accept.nextLine();
                         System.out.println();

                         // Accepting Phone Number
                         System.out.println(" Enter Phone Number [ +233 ****** ] ");
                         phoneNumber = accept.nextLine();
                         System.out.println();

                         // Accepting ID Number
                         System.out.println(" Enter Id Number ");
                         idNUmber = accept.nextLine();
                         System.out.println();

                         // Accepting Password
                         System.out.println(" Enter New Password: ");
                         Password = accept.nextLine();
                         System.out.println();

                         // Accepting Initial Deposit
                         System.out.println(" Enter Minimal Deposit Amount ");

                         try {
                             balance = accept.nextDouble();
                             System.out.println();
                         } catch (Exception e) {
                             System.out.println("STATUS 404: ERROR MESSAGE " + e);
                             System.out.println("Please Enter A Valid Number ");
                             accept.nextDouble();
                             balance = 0;

                         }


                         System.out.println("-----------------------------------------------------");
                         System.out.println("           ** Account Creation Completed **          ");
                         System.out.println("_____________________________________________________");
                         System.out.println();

                         dataBank.add(new User(firstName, lastName, dateOfBirth, email, occupation, address, phoneNumber, idNUmber, balance, Password, UserName));
                     }
                     case 2 -> loginAccount(dataBank, storage, accept);

                     case 3 -> System.out.println(" STATUS 404:  EXITED COMPLETED ");

                     default -> {
                         System.out.println();
                         System.out.println("Please Enter A Valid Input ");
                     }
                 }

             }
             catch (Exception e){
                 System.out.println("STATUS 404: ERROR MESSAGE "+ e);
                 System.out.println("Please Enter A Valid Number ");
                 accept.nextLine();
                 option = 0;
             }

         }while (option!=3);


   }

   // Banking Features Method
    public static void bankingFeatures( ArrayList<transHistory> storage, Scanner accept){

        // Variable Selection
        int Option;
        double balance = 0;

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
           switch (Option) {
               case 1 -> balance = deposit(balance, storage, accept);

               case 2 -> balance = withdraw(balance, storage, accept);

               case 3 -> balance = checkBalance(balance);

               case 4 -> transactionHistory(storage);

               case 5 -> balance = transferFunds(storage, balance, accept);

               case 6 -> {
                   System.out.println("THANK YOU FOR USING SMART-BANK");
                   System.out.println(" COME BACK AGAIN ");
               }

               default -> System.out.println(" PLEASE ENTER A VALID INPUT ");

           }

       }while(Option != 6 );
    }

    // Login Process Account
    public static void loginAccount(ArrayList<User> dataBank,ArrayList<transHistory> storage,Scanner accept){

        // Variables
        String UserName,Password;


        System.out.println("-------------------------------------------------------------");
        System.out.println("                ACCOUNT LOGIN VERIFICATION                   ");
        System.out.println("_____________________________________________________________");
        System.out.println();

        System.out.println(" Enter UserName: ");
        UserName = accept.nextLine();
        System.out.println();

        System.out.println(" Enter Account Password: ");
        Password = accept.nextLine();
        System.out.println();

        // Using Try And Catch To Detect Errors
        try {
            for ( User frank : dataBank ){

                if ( UserName.equals(frank.UserName) && Password.equals(frank.Password)){
                    bankingFeatures(storage,accept);
                }

                else {
                    System.out.println(" STATUS 404: WRONG LOGIN INFORMATION ");
                    System.out.println(" LOGIN AGAIN OR CREATE A NEW ACCOUNT ");
                    System.out.println();
                }
            }


        }
        catch ( Exception e){
            System.out.println(" STATUS 404 : " + e);

            System.out.println(" Enter A Valid Username: ");
            accept.nextLine();
            UserName = accept.nextLine();

            System.out.println(" Enter User Password: ");
            accept.nextLine();
            Password = accept.nextLine();

        }

    }


    // The Deposit Method For The Banking Features
    public static double deposit( double balance,ArrayList<transHistory> storage,Scanner accept ){

        // Deposit Variable
        double deposit;
        double add;
        String type,date_time,acctNum,acctName;

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
        date_time = accept.nextLine();
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
        storage.add( new transHistory( type,date_time,acctNum,acctName,deposit ) );

        return add;



    }


    // The Withdrawal  Method For The Banking Features
    public static double withdraw( double balance,ArrayList<transHistory> storage, Scanner accept ){

        // Withdraw Menu variable
        double withdraw;
        double total = 0;
        String acctName,acctNum,type,date_time;

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
        date_time = accept.nextLine();
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
            storage.add( new transHistory( type,date_time,acctNum,acctName,withdraw ) );

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

    // Method For Transferring funds between two accounts
    public static double transferFunds(ArrayList<transHistory> storage,double balance, Scanner input){

        // Declaring Variables
        String send,receive,sendName,receiveName,type,date_type;
        double amount,total = 0;

        System.out.println("----------------------------------------------------------------");
        System.out.println("                          TRANSFER FUNDS                        ");
        System.out.println("________________________________________________________________");
        System.out.println();

        // Accepting Senders Account Name
        System.out.println(" Enter Sender's Account Name ");
        sendName = input.nextLine();
        System.out.println();

        // Accepting Senders Account Number
        System.out.println(" Enter Sender's Account Number ");
        send = input.nextLine();
        System.out.println();

        // Accepting Receivers Account Name
        System.out.println(" Enter Receiver's Account Name ");
        receiveName = input.nextLine();
        System.out.println();

        // Accepting Receivers Account Number
        System.out.println(" Enter Receiver's Account Number ");
        receive = input.nextLine();
        System.out.println();

        // Type Of Transaction
        System.out.println(" Enter Transaction Type ");
        type = input.nextLine();
        System.out.println();

        // Date And Time Of Transaction
        System.out.println(" Enter Date Of Transaction [DD/ MM/ YYY ]");
        date_type = input.nextLine();
        System.out.println();

        // Accepting Amount To Transfer
        System.out.println(" Enter Amount To Transfer ");
        amount = input.nextDouble();
        System.out.println();

        // Using If Statements To Check For The Actual Error
        if( amount > balance ){
            System.out.println("PENDING STATUS: 404 ");
            System.out.println("INSUFFICIENT BALANCE ");
            System.out.println();
        }

        else if ( amount < balance ) {
            System.out.println("TRANSFER SUCCESSFUL ");
            System.out.println("Amount of GHC " + amount + " Has Been Transferred From: " );
            System.out.println(" Sender's Account Name: " + sendName);
            System.out.println(" Sender's Account Number: " + send);
            System.out.println();

            System.out.println("TRANSFER RECEIVED ");
            System.out.println("Amount Of GHC "+ amount + " Has Been Received From: ");
            System.out.println(" Receiver's Account Name: "+ receiveName);
            System.out.println(" Receiver's Account Number: "+ receive);
            System.out.println();

            total = balance - amount;
            System.out.println(" Balance: GHC " +total );

        }

        else{
            System.out.println("PENDING STATUS: 404 ");
            System.out.println(" PLEASE ENTER A VALID AMOUNT ");
            System.out.println();
        }

        storage.add(new transHistory( type,date_type,send,sendName,amount ));

        return total;

    }

    // Method For The Admin Panel [ Separate Login ]
    public static void adminPanel(ArrayList<User> dataBank,Scanner input){

        // Declaring Variables
        int option;

       do{

          try {

              System.out.println("-------------------------------------------------------");
              System.out.println("             ADMIN PANEL [ SEPARATE LOGIN ]            ");
              System.out.println("_______________________________________________________");
              System.out.println();
              System.out.println("1.View All Customers ");
              System.out.println("2.Search Customers [ ID NUMBER ] ");
              System.out.println("3.Delete Customer Account ");
              System.out.println("4.Freeze Customer Account ");
              System.out.println("5.Exit ");

              System.out.println("Please select An Option ");
              option = input.nextInt();
              System.out.println();

              // Using Switch Case To Determine User Input
              switch (option) {
                  case 1 -> viewCustomers(dataBank);

                  case 2 -> searchCustomer(dataBank, input);

                  case 3 -> deleteCustomer(dataBank, input);

                  case 4 -> System.out.println(" STATUS 404: FREEZE PENDING ");

                  case 5 -> System.out.println(" COME BACK NEXT TIME ");

                  default -> System.out.println(" PLEASE ENTER A VALID INPUT ");

              }
          }catch (Exception e){
              System.out.println("STATUS 404: INVALID INPUT " + e);
              System.out.println(" Enter Valid Number Between 1 - 4");
              input.nextLine();
              option = 0;

          }

       }while (option != 5);

    }

    // Method For View All Customers
    public static void viewCustomers(ArrayList<User> data_bank){
        System.out.println("----------------------------------------------------------");
        System.out.println("                   VIEW ALL CUSTOMERS                     ");
        System.out.println("__________________________________________________________");
        System.out.println();

        for( User storage : data_bank ){
            System.out.println(" Personal Details: ");
            System.out.println("First Name    : " + storage.firstName);
            System.out.println("Last Name     : " + storage.lastName);
            System.out.println("Date Of Birth : " + storage.dateOfBirth);
            System.out.println("ID Number     : " + storage.idNUmber);
            System.out.println();

            System.out.println(" Bank Details: ");
            System.out.println("Email        : " + storage.email);
            System.out.println("Phone Number : " + storage.phoneNumber);
            System.out.println("Address      : " + storage.address);
            System.out.println("Occupation   : " + storage.occupation);

            System.out.println(" Account Balance: ");
            System.out.println(" Balance: " + storage.balance);
            System.out.println("=====================================================");
            System.out.println();



        }


    }

    // Method For Searching For Customers
    public static void searchCustomer(ArrayList<User> data_bank, Scanner input){

        String idNumber;

        System.out.println("----------------------------------------------------");
        System.out.println("               SEARCH ALL CUSTOMER                  ");
        System.out.println("----------------------------------------------------");
        System.out.println();

        // Customer Identification Number
        System.out.println(" Enter Customer's id Number: ");
        idNumber = input.nextLine();

        for( User search : data_bank){
              if (idNumber.equals(search.idNUmber)){

                  System.out.println("-----------------------------------------------");
                  System.out.println("                 CUSTOMER FOUND                ");
                  System.out.println("_______________________________________________");
                  System.out.println();
                  System.out.println(" Personal Details: ");
                  System.out.println("First Name    : " + search.firstName);
                  System.out.println("Last Name     : " + search.lastName);
                  System.out.println("Date Of Birth : " + search.dateOfBirth);
                  System.out.println("ID Number     : " + search.idNUmber);
                  System.out.println();

                  System.out.println(" Bank Details: ");
                  System.out.println("Email        : " + search.email);
                  System.out.println("Phone Number : " + search.phoneNumber);
                  System.out.println("Address      : " + search.address);
                  System.out.println("Occupation   : " + search.occupation);

                  System.out.println(" Account Balance: ");
                  System.out.println(" Balance: " + search.balance);
                  System.out.println("=====================================================");
                  System.out.println();
              }


        }

         if (idNumber.isEmpty()){
            System.out.println("---------------------------------------------------");
            System.out.println("                   NO CUSTOMER FOUND !!!           ");
            System.out.println("___________________________________________________");
            System.out.println();
        }
        
    }

    // Method For Deleting Customer Account
    public static void deleteCustomer(ArrayList<User> data_bank, Scanner input){
        String idNumber;

        System.out.println("---------------------------------------------------------");
        System.out.println("               DELETE CUSTOMER ACCOUNT                   ");
        System.out.println("_________________________________________________________");
        System.out.println();
        System.out.println(" Enter Customer Id Number: ");
        idNumber = input.nextLine();
        for ( User stick : data_bank){
               if (idNumber.equalsIgnoreCase(stick.idNUmber)){
                   System.out.println("--------------------------------------------");
                   System.out.println("         CUSTOMER DELETION COMPLETED        ");
                   System.out.println("____________________________________________");
                   System.out.println("Deletes All Customers For Now ");
                   data_bank.clear();

               }
        }
    }

}
