package com.bankDatabase;

public class User {

    // Declaring Variables Names
    String firstName,lastName,dateOfBirth,email,occupation,address,phoneNumber,idNUmber,Password,UserName;
    double balance;

    // Constructors
    User( String firstName, String lastName, String dateOfBirth, String email,
          String occupation, String address, String phoneNumber, String idNUmber, double balance, String Password,String UserName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.occupation = occupation;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.idNUmber = idNUmber;
        this.balance = balance;
        this.Password = Password;
        this.UserName = UserName;
    }

}
