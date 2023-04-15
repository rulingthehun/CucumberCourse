package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DialogContent extends Parent {

    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(css = "input[formcontrolname='username']")
    private WebElement username;

    @FindBy(css = "input[formcontrolname='password']")
    private WebElement password;

    @FindBy(css = "button[aria-label='LOGIN']")
    private WebElement loginButton;

    @FindBy(css = "span[class='mat-tooltip-trigger logo-text']")
    private WebElement txtTechnoStudy;

    @FindBy(xpath = "//ms-add-button[contains(@tooltip,'TITLE.ADD')]//button")
    private WebElement addButton;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='name']//input")
    private WebElement countryName;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='code']//input")
    private WebElement countryCode;

    @FindBy(xpath = "//ms-save-button//button")
    private WebElement saveButton;

    @FindBy(xpath = "//div[contains(text(),'successfully')]")
    private WebElement successMessage;

    //@FindBy(css = "button[class='consent-give']")
    //private WebElement acceptCookies;


    WebElement myElement;

    public void findAndSend(String strElement, String value) {
        //element get :burda string isimden weblemente ulaşıcam
        switch (strElement) {
            case "username":
                myElement = username;
                break;
            case "password":
                myElement = password;
                break;
            case "countryName":
                myElement = countryName;
                break;
            case "countryCode":
                myElement = countryCode;
                break;
        }

        sendKeysFunction(myElement, value);
    }

    public void findAndClick(String strElement) {
        //element get :burda string isimden weblemente ulaşıcam
        switch (strElement) {
            case "loginButton":
                myElement = loginButton;
                break;
            case "addButton":
                myElement = addButton;
                break;
            case "saveButton":
                myElement = saveButton;
                break;
        }

        clickFunction(myElement);
    }

    public void findAndContainsText(String strElement, String text) {
        //element get :burda string isimden weblemente ulaşıcam
        switch (strElement) {
            case "txtTechnoStudy":
                myElement = txtTechnoStudy;
                break;
            case "successMessage":
                myElement = successMessage;
                break;
        }

        verifyContainsTextFunction(myElement, text);
    }
}
