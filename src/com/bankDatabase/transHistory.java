package com.bankDatabase;

// A Transaction History Java Class that collects import data
public class transHistory {

    // Declaring Variables
    String transactionType,dateNtime,acctNumber,acctName;
    double amount;

    // Constructors
    transHistory( String transactionType, String dateNtime, String acctNumber, String acctName, double amount){
        this.transactionType = transactionType;
        this.dateNtime = dateNtime;
        this.acctNumber = acctNumber;
        this.acctName = acctName;
        this.amount = amount;

    }

}
