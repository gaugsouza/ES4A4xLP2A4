package ES4A4xLP2A4.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

class IsItFryday {
    static String isItFriday(String today){
        return "Friday".equals(today) ? "Yep" : "Nope";
    }
}

public class Stepdefs{
    private String today;
    private String answer;

    @Given("today is Sunday")
    public void today_is_Sunday() {
        today = "Sunday";
    }

    @Given("today is Friday")
    public void today_is_Friday() {
        today = "Friday";
    }

    @When("I ask wheter it's Friday yet")
    public void i_ask_wheter_it_s_Friday_yet() {
        answer = IsItFryday.isItFriday(today);
    }

    @Then("I should be told {string}")
    public void i_should_be_told(String expectedAnswer) {
        assertEquals(expectedAnswer, answer);
    }

}