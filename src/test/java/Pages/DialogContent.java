package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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

    @FindBy(xpath = "(//div//button)[47]")
    private WebElement closePanelButton;

    //@FindBy(xpath = "(//ms-text-field//input)[1]")
    @FindBy(xpath = "//mat-form-field//input[@data-placeholder='Name']")
    private WebElement generalFieldName;

    @FindBy(xpath = "//ms-text-field[@placeholder='GENERAL.FIELD.SHORTNAME']//input")
    private WebElement generalFieldShortName;

    @FindBy(xpath = "//ms-search-button//button")
    private WebElement searchButton;

    @FindBy(xpath = "(//td[@role='cell'])[2]")
    private WebElement searchResultCell;

    @FindBy(xpath = "//ms-delete-button//button")
    private WebElement deleteButton;

    @FindBy(xpath = "//div//button[@type='submit']")
    private WebElement deleteSubmitButton;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='name']//input")
    private WebElement nameInput;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='firstName']//input")
    private WebElement firstNameInput;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='code']//input")
    private WebElement codeInput;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='shortName']//input")
    private WebElement shortNameInput;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='lastName']//input")
    private WebElement lastNameInput;

    @FindBy(xpath = "//div//input[@data-placeholder='Employee ID']")
    private WebElement EmployeeIDInput;

    @FindBy(xpath = "(//div//mat-form-field)[8]")
    private WebElement statusInput;

    @FindBy(xpath = "//span[text()=' Passive ']")
    private WebElement statusPassive;

    @FindBy(xpath = "//span[text()=' Active ']")
    private WebElement statusActive;

    @FindBy(xpath = "(//div//mat-form-field)[13]")
    private WebElement documentType;

    @FindBy(xpath = "//span[text()=' Personal ID ']")
    private WebElement dCPersonalID;

    @FindBy(xpath = "//span[text()=' Passport ']")
    private WebElement dCPassport;

    @FindBy(xpath = "//span[text()=' Birth Certificate ']")
    private WebElement dCBirthCertificate;

    @FindBy(xpath = "(//div[@role='tab'])[2]")
    private WebElement contactAddress;

    @FindBy(xpath = "(//div//input)[8]")
    private WebElement countryInput;

    @FindBy(xpath = "//ms-save-button//button")
    private WebElement saveButton;

    @FindBy(xpath = "//div[contains(text(),'successful')]")
    private WebElement successMessage;

    @FindBy(xpath = "//div[contains(text(),'already exists')]")
    private WebElement unsuccessMessage;

    @FindBy(xpath = "//ms-integer-field[@formcontrolname='priority']//input")
    private WebElement priorityInput;

    @FindBy(xpath = "//mat-slide-toggle[@formcontrolname='active']")
    private WebElement toggleSlide;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='budgetAccountIntegrationCode']//input")
    private WebElement integrationCode;

    @FindBy(xpath = "//tbody[@role='rowgroup']/tr/td[2]")
    public List<WebElement> nameList;

    //@FindBy(css = "button[class='consent-give']")
    //private WebElement acceptCookies;


    WebElement myElement;

    public void findAndSend(String strElement, String value) {
        //element get :burada string isimden web elemente ulaşacağım
        switch (strElement) {
            case "username":
                myElement = username;
                break;
            case "password":
                myElement = password;
                break;
            case "nameInput":
                myElement = nameInput;
                break;
            case "firstNameInput":
                myElement = firstNameInput;
                break;
            case "codeInput":
                myElement = codeInput;
                break;
            case "shortNameInput":
                myElement = shortNameInput;
                break;
            case "lastNameInput":
                myElement = lastNameInput;
                break;
            case "EmployeeIDInput":
                myElement = EmployeeIDInput;
                break;
            case "countryInput":
                myElement = countryInput;
                break;
            case "generalFieldName":
                myElement = generalFieldName;
                break;
            case "generalFieldShortName":
                myElement = generalFieldShortName;
                break;
            case "priorityInput":
                myElement = priorityInput;
                break;
            case "integrationCode":
                myElement = integrationCode;
                break;
        }

        sendKeysFunction(myElement, value);
    }

    public void findAndClick(String strElement) {
        //element get :burada string isimden web elemente ulaşacağım
        switch (strElement) {
            case "loginButton":
                myElement = loginButton;
                break;
            case "addButton":
                myElement = addButton;
                break;
            case "statusInput":
                myElement = statusInput;
                break;
            case "statusPassive":
                myElement = statusPassive;
                break;
            case "statusActive":
                myElement = statusActive;
                break;
            case "documentType":
                myElement = documentType;
                break;
            case "dCPersonalID":
                myElement = dCPersonalID;
                break;
            case "dCPassport":
                myElement = dCPassport;
                break;
            case "dCBirthCertificate":
                myElement = dCBirthCertificate;
                break;
            case "contactAddress":
                myElement = contactAddress;
                break;
            case "saveButton":
                myElement = saveButton;
                break;
            case "searchButton":
                myElement = searchButton;
                break;
            case "deleteButton":
                myElement = deleteButton;
                break;
            case "deleteSubmitButton":
                myElement = deleteSubmitButton;
                break;
            case "closePanelButton":
                myElement = closePanelButton;
                break;
            case "toggleSlide":
                myElement = toggleSlide;
                break;

            //case "acceptCookies":
            //    myElement = acceptCookies;
            //    break;
        }

        clickFunction(myElement);
    }

    public void findAndContainsText(String strElement, String text) {
        //element get :burada string isimden web elemente ulaşacağım
        switch (strElement) {
            case "txtTechnoStudy":
                myElement = txtTechnoStudy;
                break;
            case "successMessage":
                myElement = successMessage;
                break;
            case "unsuccessMessage":
                myElement = unsuccessMessage;
                break;
            case "searchResultCell":
                myElement = searchResultCell;
                break;
        }

        verifyContainsTextFunction(myElement, text);
    }

    public void findAndDelete(String searchText) {
        findAndSend("generalFieldName", searchText);  // aranacak kelimeyi kutucuğa gönder
        findAndClick("searchButton"); // arama butonuna bas

        //wait.until(ExpectedConditions.stalenessOf(deleteButton)); stale zamanını yakalayamadım
        //wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.xpath("//tbody[@role='rowgroup']//tr"),5));
        findAndContainsText("searchResultCell",searchText);
        /*
        arama sonuçlarının ilkinde aranan
        kelime gözükene kadar bekle
         */
        waitUntilLoading();
        findAndClick("deleteButton"); // silme butonua bas, çöp kutusu
        findAndClick("deleteSubmitButton"); // dialogda ki silme butonuna bas

    }
}
