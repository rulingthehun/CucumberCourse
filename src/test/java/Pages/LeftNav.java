package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftNav extends Parent {
    public LeftNav() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "(//*[text()='Setup'])[1]")
    private WebElement setup;

    @FindBy(xpath = "(//*[text()='Entrance Exams'])[1]")
    private WebElement entranceExams;

    @FindBy(xpath = "(//*[text()='Parameters'])")
    private WebElement parameters;

    @FindBy(xpath = "(//span[text()='Setup'])[2]")
    private WebElement examSetup;

    @FindBy(xpath = "(//*[text()='Entrance Exams'])[2]")
    private WebElement entranceExamsSetup;

    @FindBy(xpath = "(//*[text()='Countries'])[1]")
    private WebElement countries;

    @FindBy(xpath = "(//*[text()='Citizenships'])[1]")
    private WebElement citizenships;

    @FindBy(xpath = "//span[text()='Nationalities']")
    private WebElement nationalities;

    @FindBy(xpath = "(//span[text()='Fees'])[1]")
    private WebElement fees;

    WebElement myElement;

    public void findAndClick(String strElement) {

        switch (strElement) {
            case "setup":
                myElement = setup;
                break;
            case "entranceExams":
                myElement = entranceExams;
                break;
            case "parameters":
                myElement = parameters;
                break;
            case "examSetup":
                myElement = examSetup;
                break;
            case "entranceExamsSetup":
                myElement = entranceExamsSetup;
                break;
            case "countries":
                myElement = countries;
                break;
            case "citizenships":
                myElement = citizenships;
                break;
            case "nationalities":
                myElement = nationalities;
                break;
            case "fees":
                myElement = fees;
                break;
        }

        clickFunction(myElement);
    }

}
