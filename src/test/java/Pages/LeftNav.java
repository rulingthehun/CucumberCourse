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

    @FindBy(xpath = "(//*[text()='Parameters'])")
    private WebElement parameters;

    @FindBy(xpath = "(//*[text()='Countries'])[1]")
    private WebElement countries;

    @FindBy(xpath = "(//*[text()='Citizenships'])[1]")
    private WebElement citizenships;

    WebElement myElement;

    public void findAndClick(String strElement) {

        switch (strElement) {
            case "setup":
                myElement = setup;
                break;
            case "parameters":
                myElement = parameters;
                break;
            case "countries":
                myElement = countries;
                break;
            case "citizenships":
                myElement = citizenships;
                break;
        }

        clickFunction(myElement);
    }

}
