package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	public static Scenario scenario;

    @Before
    public void setup(Scenario scenario) {
        Hooks.scenario = scenario;
        
    }
}
