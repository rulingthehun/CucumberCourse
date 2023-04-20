package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormContent extends Parent{
    public FormContent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }


    @FindBy(xpath = "//mat-select//span[text()='Academic Period']")
    private WebElement academicPeriod;

    @FindBy(xpath = "(//mat-option/span)")
    private WebElement academicPeriodOption;

    @FindBy(xpath = "(//mat-option/span)")
    private WebElement academicPeriodClick;

    @FindBy(xpath = "(//mat-select[@role='combobox'])[2]")
    private WebElement gradeLevel;

    @FindBy(xpath = "(//mat-option//span)[2]")
    private WebElement gradeLevel2;

    @FindBy(xpath = "(//mat-option//span)[3]")
    private WebElement gradeLevel3;

    @FindBy(xpath = "(//mat-option//span)[4]")
    private WebElement gradeLevel4;

    @FindBy(xpath = "(//mat-option//span)[5]")
    private WebElement gradeLevel5;


    WebElement myElement;
    public void findAndClick(String strlement) {
        //element get :burda string isimden weblemente ulaşıcam
        switch (strlement) {
            case "academicPeriod":
                myElement = academicPeriod;
                break;
            case "academicPeriodOption":
                myElement = academicPeriodOption;
                break;
            case "academicPeriodClick":
                myElement = academicPeriodClick;
                break;
            case "gradeLevel":
                myElement = gradeLevel;
                break;
            case "gradeLevel2":
                myElement = gradeLevel2;
                break;
            case "gradeLevel3":
                myElement = gradeLevel3;
                break;
            case "gradeLevel4":
                myElement = gradeLevel4;
                break;
            case "gradeLevel5":
                myElement = gradeLevel5;
                break;
        }

        clickFunction(myElement);
    }

}
