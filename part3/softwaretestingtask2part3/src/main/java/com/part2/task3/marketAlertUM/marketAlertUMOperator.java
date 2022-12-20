package com.part2.task3.marketAlertUM;

public class marketAlertUMOperator {
    private boolean login = false;//States that we are in the LOGIN state.
    private boolean logout = false; //States that we are in the MARKET ALERT UM state
    private boolean view = false;//States that we are in the ALERTS state.
    //Sending a login request from the market alert site.
    void loginRequest(){
        //Checking that there are no other requests pending.
        if(!(login || view)){
            //Stating that we are in the LOGIN state.
            login = true;
        }else {
            throw new IllegalStateException();
        }
    }

    void badLoginRequest(){
        //Checking that there are no other requests pending.
        if(!(login || view)){
            //Stating that we are in the LOGIN state.
            login = false;
            logout = true;
        }else {
            throw new IllegalStateException();
        }
    }

    //Viewing the alerts (GOAL)
    void viewAlert(){
        //Checking if there has been a login request
        if(login){
            //Stating that we are in the ALERTS state.
            view = true;
        }else {
            throw new IllegalStateException();
        }
    }

    void exitAlert(){
        //Checking if there has been a login request
        if(login){
            //Stating that we are in the MARKET ALERT UM state.
            view = false;
            login = false;
            logout = true;
        }else {
            throw new IllegalStateException();
        }
    }

    /*Methods to determine the current location of the SUT.*/
    boolean isInMARKET_ALERT_UM(){ return logout;}//Checking if we are in the BLOCKED state.
    boolean isInLogin(){return login;}//Checking if we are in the LOGIN state.
    boolean isInAlerts(){return view;}//Checking if we are in the ALERTS state.

}
