package com.part2.task3.eBay;

public class eBayOperator {
    private boolean isScraped = true;//States that we are currently in the SCRAPER state.
    private boolean isBad = false;//States that we are currently in the BAD_STATE state.
    private boolean isGood = false;//States that we are currently in the MARKET_ALERT_UM state.
    //When the SUT sends a bad API request.
    void badApiRequest(){
        //Checking that we are not in any other state.
        if (!(isBad || isGood)) {
            //Stating that we are currently in the BAD_STATE.
            isBad = true;
        } else {
            throw new IllegalStateException();
        }
    }
    //When the SUT reverts to the SCRAPER  from the BAD_STATE.
    void retry() {
        //Making sure that we are in a bad state before attempting to retry.
        if(isBad){
            //Stating that we are in the SCRAPER state.
            isScraped = true;
            //Stating that we are not in the bad state anymore.
            isBad = false;
        }else {
            throw new IllegalStateException();
        }
    }
    //When the SUT sends a good request to the website.
    void goodApiRequest(){
        //Checking that we do mot have a bad request pending(Not crucial but can be covered).
        if (!isBad) {
            //Stating that we are currently in the MARKET_ALERT_UM state.
            isGood = true;
            //Stating that we are not in the SCRAPER state anymore.
            isScraped = false;
        } else {
            throw new IllegalStateException();
        }
    }
    //When the website sends back a good response.
    void goodResponse(){
        //Checking if we are currently in the MARKET_ALERT_UM state with a good alert.
        if(isGood){
            //Stating that we are no longer in the MARKET_ALERT_UM state.
            isGood = false;
            //Stating that we are back to the SCRAPER state.
            isScraped = true;
        }else {
            throw new IllegalStateException();
        }
    }
    /*Methods to check current location.*/
    boolean isInScraper() {return isScraped;} //Checking if we are in the SCRAPER state.
    boolean isInBadState(){ return isBad;} //Checking if we are in the BAD_STATE
    boolean isInMarketAlert(){ return isGood;} //Checking if we are in the MARKET_ALERT_UM state.
}

