package util;

import io.cucumber.java.*;

public class Hooks {
	public static Scenario scenario;

    @Before
    public void setup(Scenario scenario) {
        Hooks.scenario = scenario;
        
    }
}
