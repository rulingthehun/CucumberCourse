package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;

public class _02_CountrySteps {
    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();
    @And("Navigate to country page")
    public void navigateToCountryPage() {
        ln.findAndClick("setup");
        ln.findAndClick("parameters");
        ln.findAndClick("countries");
    }

    @When("Create a country")
    public void createACountry() {
        String randomGenName= RandomStringUtils.randomAlphanumeric(8);
        String randomGenCode= RandomStringUtils.randomNumeric(4);
        dc.findAndClick("addButton");
        dc.findAndSend("countryName", randomGenName);
        dc.findAndSend("countryCode", randomGenCode);
        dc.findAndClick("saveButton");
    }

    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {
        dc.findAndContainsText("successMessage","success");
    }
}
