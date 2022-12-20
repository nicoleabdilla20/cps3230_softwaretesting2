package com.part2.task3.marketAlertUM;

import com.part2.task3.marketAlertUM.enums.MarketAlertUMStateEnum;
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

public class MarketAlertUMTest implements FsmModel {
    //Create a new System under test object.
    marketAlertUMOperator systemUnderTest = new marketAlertUMOperator();
    //Initializing the starting state of the system.
    MarketAlertUMStateEnum stateEnum = MarketAlertUMStateEnum.MARKET_ALERT_UM;
    //Initializing all the necessary variables.
    boolean isLoggedIn = false;
    boolean isLoggedOut = false;
    boolean isBadLogin = false;
    boolean isView = false;
    //Getting the current state of the FSM.
    @Override
    public MarketAlertUMStateEnum getState() {
        return stateEnum;
    }
    //Resetting the FSM to its initial states.
    @Override
    public void reset(boolean b) {
        if(b) {
            systemUnderTest = new marketAlertUMOperator();
        }
        isLoggedIn = false;
        isLoggedOut = false;
        isBadLogin = false;
        isView = false;
        stateEnum = MarketAlertUMStateEnum.MARKET_ALERT_UM;
    }

    public boolean loggingInGuard(){return getState().equals(MarketAlertUMStateEnum.MARKET_ALERT_UM);}
    public @Action void loggingIn(){
        // Login request
        systemUnderTest.loginRequest();

        //Updating model
        stateEnum = MarketAlertUMStateEnum.LOGIN;
        isLoggedIn = true;
        //Testing that MARKET_ALERT_UM -> LOGIN state is TRUE
        Assert.assertEquals("The SUT state does not match to the model's Login state.", isLoggedIn, systemUnderTest.isInLogin());
    }

    public boolean badLoggingInGuard(){return getState().equals(MarketAlertUMStateEnum.MARKET_ALERT_UM);}
    public @Action void badLoggingIn(){
        // Bad login request
        systemUnderTest.badLoginRequest();

        //Updating model
        stateEnum = MarketAlertUMStateEnum.MARKET_ALERT_UM;
        isBadLogin = true;
        //Testing that we have moved from the MARKET_ALERT_UM to the LOGIN state.
        Assert.assertEquals("The SUT state does not match to the model's MARKET ALERT UM state.", isBadLogin, systemUnderTest.isInMARKET_ALERT_UM());
    }

    public boolean viewingGuard(){
        return getState().equals(MarketAlertUMStateEnum.LOGIN);
    }
    public @Action void viewing(){
        // Viewing the alerts
        systemUnderTest.viewAlert();

        //Updating model
        stateEnum = MarketAlertUMStateEnum.ALERTS;
        isView = true;
        // Testing that LOGIN -> ALERTS state is TRUE
        Assert.assertEquals("The SUT state does not match to the model's Alert state.", isView, systemUnderTest.isInAlerts());
    }

    public boolean loggingOutFromAlertsGuard(){
        return getState().equals(MarketAlertUMStateEnum.ALERTS);
    }
    public @Action void loggingOutFromAlerts(){
        // Exiting from Alerts i.e. logging out
        systemUnderTest.exitAlert();
        //Updating model
        stateEnum = MarketAlertUMStateEnum.MARKET_ALERT_UM;
        isLoggedOut = true;
        //Testing that LOGIN state -> MARKET_ALERT_UM state is True
        Assert.assertEquals("The SUT state does not match to the model's MARKET ALERT UM state.", isLoggedOut, systemUnderTest.isInMARKET_ALERT_UM());

    }

    // runner copied from tutorial project
    @Test
    public void MarketAlertUMRunner() {
        final GreedyTester tester = new GreedyTester(new MarketAlertUMTest()); //Creates a test generator that can generate random walks. A greedy random walk gives preference to transitions that have never been taken before. Once all transitions out of a state have been taken, it behaves the same as a random walk.
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
