package clogger;

import io.cucumber.java8.En;

public class StepCustomLogger implements En{

    public StepCustomLogger() {
        Given("I have {int} cukes in my belly", (Integer cukes) -> {
            System.out.format("Cukes: %n\n", cukes);
        });

        Given("this reads and writes system properties", () -> {
            System.out.format("Given this reads and writes system properties\n");
        });

        Given("this reads system properties", () -> {
            System.out.format("Given this reads system properties\n");
        });

        Then("it will not be executed concurrently with the {string} example", (String example) -> {
            System.out.format("Example: %n\n", example);
        });

        When("it is executed", () -> {
            System.out.format("When executed\n");
        });

    }
}