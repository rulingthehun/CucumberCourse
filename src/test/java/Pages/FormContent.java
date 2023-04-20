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

    @FindBy(xpath = "(//mat-option/span)[1]")
    private WebElement academicPeriodClick;


    @FindBy(xpath = "(//span[text()='Grade Level'])[1]")
    private WebElement gradeLevel;

    @FindBy(xpath = "(//mat-option//span)[2]")
    private WebElement gradeLevel2;


    WebElement myElement;
    public void findAndClick(String strlement) {
        //element get :burda string isimden weblemente ulaşıcam
        switch (strlement) {
            case "academicPeriod":
                myElement = academicPeriod;
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
        }

        clickFunction(myElement);
    }

}
