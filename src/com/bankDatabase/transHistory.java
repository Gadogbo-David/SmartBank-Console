package com.bankDatabase;

// A Transaction History Java Class that collects import data
public class transHistory {

    // Declaring Variables
    String transactionType,dateNtime,acctName;
    double amount;

    // Constructors
    transHistory( String transactionType, String dateNtime,String acctName, double amount){
        this.transactionType = transactionType;
        this.dateNtime = dateNtime;
        this.acctName = acctName;
        this.amount = amount;

    }

}
