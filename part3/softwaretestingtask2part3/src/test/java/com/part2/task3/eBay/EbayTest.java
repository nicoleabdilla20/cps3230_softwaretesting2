package com.part2.task3.eBay;

import com.part2.task3.eBay.enums.EbayStateEnum;
import nz.ac.waikato.modeljunit.Action;
import nz.ac.waikato.modeljunit.FsmModel;
import nz.ac.waikato.modeljunit.GreedyTester;
import nz.ac.waikato.modeljunit.StopOnFailureListener;
import nz.ac.waikato.modeljunit.coverage.ActionCoverage;
import nz.ac.waikato.modeljunit.coverage.StateCoverage;
import nz.ac.waikato.modeljunit.coverage.TransitionPairCoverage;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class EbayTest implements FsmModel {
    //Create a new System under test object.
    eBayOperator systemUnderTest = new eBayOperator();
    //Initializing the starting state of the system.
    EbayStateEnum stateEnum = EbayStateEnum.EBAY;
    //Initializing all the necessary variables.
    boolean isScraped = true;
    boolean isBad = false;
    boolean isGood = false;

    //Getting the current state of the FSM.
    @Override
    public EbayStateEnum getState() {
        return stateEnum;
    }
    //Resetting to the initial states of the FSM.
    @Override
    public void reset(boolean b) {
        if(b) {
            systemUnderTest = new eBayOperator();
        }
        isScraped = true;
        isBad = false;
        isGood = false;
        stateEnum = EbayStateEnum.EBAY;
    }

    public boolean badApiRequestGuard(){
        return (getState().equals(EbayStateEnum.EBAY));
    }

    public @Action void badApiRequest(){
        //Sending a bad request.
        systemUnderTest.badApiRequest();

        //Updating model
        stateEnum = EbayStateEnum.BAD_STATE;
        isBad = true;
        //Testing that we have moved from the scraper to the bad state.
        Assert.assertEquals("The SUT state does not match to the model's BAD STATE state.", isBad, systemUnderTest.isInBadState());
    }
    public boolean returnToScraperGuard(){
        return (getState().equals(EbayStateEnum.BAD_STATE));
    }

    public @Action void returnToScraper(){
        //Retry sending the request.,
        systemUnderTest.retry();

        //Updating model
        stateEnum = EbayStateEnum.EBAY;
        isBad = false;
        isScraped = true;
        //Testing that we have moved from the bad state back to the scraper.
        Assert.assertEquals("The SUT state does not match to the model's BAD STATE state.", isBad, systemUnderTest.isInBadState());
        Assert.assertEquals("The SUT state does not match to the model's SCREEN SCRAPER state.", isScraped, systemUnderTest.isInScraper());
    }

    public boolean goodApiRequestGuard(){
        return (getState().equals(EbayStateEnum.EBAY));
    }
    public @Action void goodApiRequest(){
        //Sending a good request.
        systemUnderTest.goodApiRequest();

        //Updating model
        stateEnum = EbayStateEnum.MARKET_ALERT_UM;
        isGood = true;
        isScraped = false;
        //Testing that we have moved from the scraper to the market alert site.
        Assert.assertEquals("The SUT state does not match to the model's MARKET ALERT UM state.", isGood, systemUnderTest.isInMarketAlert());
        Assert.assertEquals("The SUT state does not match to the model's SCREEN SCRAPER state.", isScraped, systemUnderTest.isInScraper());
    }

    public boolean responseGuard(){
        return (getState().equals(EbayStateEnum.MARKET_ALERT_UM));
    }

    public @Action void response(){
        //Sending a response back.
        systemUnderTest.goodResponse();

        //Updating model
        stateEnum = EbayStateEnum.EBAY;
        isGood = false;
        isScraped = true;
        //Testing that we have moved back to the scraper from the market alert site.
        Assert.assertEquals("The SUT state does not match to the model's SCREEN SCRAPER state.", isScraped, systemUnderTest.isInScraper());
        Assert.assertEquals("The SUT state does not match to the model's MARKET ALERT UM state.", isGood, systemUnderTest.isInMarketAlert());

    }

    // Runner copied from Tutorial Project
    @Test
    public void EbayTestRunner() {
        final GreedyTester tester = new GreedyTester(new EbayTest()); //Creates a test generator that can generate random walks. A greedy random walk gives preference to transitions that have never been taken before. Once all transitions out of a state have been taken, it behaves the same as a random walk.
        tester.setRandom(new Random()); //Allows for a random path each time the model is run.
        tester.buildGraph(); //Builds a model of our FSM to ensure that the coverage metrics are correct.
        tester.addListener(new StopOnFailureListener()); //This listener forces the test class to stop running as soon as a failure is encountered in the model.
        tester.addListener("verbose"); //This gives you printed statements of the transitions being performed along with the source and destination states.
        tester.addCoverageMetric(new TransitionPairCoverage()); //Records the transition pair coverage i.e. the number of paired transitions traversed during the execution of the test.
        tester.addCoverageMetric(new StateCoverage()); //Records the state coverage i.e. the number of states which have been visited during the execution of the test.
        tester.addCoverageMetric(new ActionCoverage()); //Records the number of @Action methods which have been executed during the execution of the test.
        tester.generate(500); //Generates 500 transitions
        tester.printCoverage(); //Prints the coverage metrics specified above.
    }

}
