package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;

public class _04_CitizenShipSteps {
    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();

    @And("Navigate to citizenships page")
    public void navigateToCitizenshipsPage(){
        ln.findAndClick("setup");
        ln.findAndClick("parameters");
        ln.findAndClick("citizenships");
    }

    @When("Add a citizenship")
    public void addACitizenship() {
        dc.findAndClick("addButton");
        dc.findAndSend("nameInput", "someRndmName2");
        dc.findAndSend("shortNameInput", "someRndmShortName2");
        dc.findAndClick("saveButton");
    }

    @Then("Success message should be displayed for citizenship")
    public void successMessageShouldBeDisplayedForCitizenship() {
        dc.findAndContainsText("successMessage","success");
    }

    @Then("Unsuccess message should be displayed")
    public void unsuccessMessageShouldBeDisplayed() {
        dc.findAndContainsText("unsuccessMessage","already exists");
    }

    @When("Add a citizenship name as {string} short name as {string}")
    public void addACitizenshipNameAsShrotNameAs(String name, String shortName) {
        dc.findAndClick("addButton");
        dc.findAndSend("nameInput", name);
        dc.findAndSend("shortNameInput", shortName);
        dc.findAndClick("saveButton");
    }
}
